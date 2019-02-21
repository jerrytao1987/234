package cn.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.IDUtils;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination topicDestination;
	@Resource
	private Destination topicDelDestination;
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_ITEM_PRE}")
	private String REDIS_ITEM_PRE;
	@Value("${ITEM_CACHE_EXPIRE}")
	private Integer ITEM_CACHE_EXPIRE;

	@Override
	public TbItem getItemById(long itemId) {
		// 查询缓存
		try {
			String json = jedisClient.get(REDIS_ITEM_PRE + ":" + itemId + ":BASE");
			if (StringUtils.isNotBlank(json)) {
				TbItem tbItem = JsonUtils.jsonToPojo(json, TbItem.class);
				return tbItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根据主键查询
		// TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		// 设置条件查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			// 添加缓存
			try {
				jedisClient.set(REDIS_ITEM_PRE + ":" + itemId + ":BASE", JsonUtils.objectToJson(list.get(0)));
				// 设置过期时间
				jedisClient.expire(REDIS_ITEM_PRE + ":" + itemId + ":BASE", ITEM_CACHE_EXPIRE);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		// 执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
		// easyUIDataGridResult.setRows(list);
		// 取分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		easyUIDataGridResult.setTotal(pageInfo.getTotal());
		easyUIDataGridResult.setRows(pageInfo.getList());
		return easyUIDataGridResult;
	}

	@Override
	public E3Result addItem(TbItem item, String desc) {
		final long itemId = IDUtils.genItemId();
		item.setId(itemId);
		// 1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);

		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		itemDescMapper.insert(itemDesc);
		// 发送商品添加信息
		jmsTemplate.send(topicDestination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(itemId + "");
				// TextMessage textMessage =
				// session.createTextMessage("add:"+itemId);
				return textMessage;
			}
		});

		return E3Result.ok();
	}

	@Override
	public E3Result getItemDescByItemId(Long itemId) {
		// 查询缓存
		try {
			String json = jedisClient.get(REDIS_ITEM_PRE + ":" + itemId + ":DESC");
			if (StringUtils.isNotBlank(json)) {
				TbItemDesc itemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
				return E3Result.ok(itemDesc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		// 添加缓存
		try {
			jedisClient.set(REDIS_ITEM_PRE + ":" + itemId + ":DESC", JsonUtils.objectToJson(itemDesc));
			// 设置过期时间
			jedisClient.expire(REDIS_ITEM_PRE + ":" + itemId + ":DESC", ITEM_CACHE_EXPIRE);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return E3Result.ok(itemDesc);
	}

	@Override
	public E3Result updateItem(final TbItem item, String desc) {
		TbItem originalItem = itemMapper.selectByPrimaryKey(item.getId());
		item.setUpdated(new Date());
		item.setStatus(originalItem.getStatus());
		item.setCreated(originalItem.getCreated());
		itemMapper.updateByPrimaryKey(item);
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setUpdated(new Date());
		itemDescMapper.updateByPrimaryKey(itemDesc);
		// 发送商品添加信息
		jmsTemplate.send(topicDestination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(item.getId() + "");
				// TextMessage textMessage =
				// session.createTextMessage("add:"+item.getId());
				return textMessage;
			}
		});
		return E3Result.ok();
	}

	@Override
	public E3Result deleteItem(final String ids) {

		String[] idArray = ids.split(",");
		for (String id : idArray) {
			long itemId = Long.parseLong(id);
			itemMapper.deleteByPrimaryKey(itemId);
			itemDescMapper.deleteByPrimaryKey(itemId);
		}
		// 发送商品添加信息
		/*
		 * jmsTemplate.send(topicDestination, new MessageCreator() {
		 * 
		 * @Override public Message createMessage(Session session) throws
		 * JMSException { TextMessage textMessage =
		 * session.createTextMessage("del:"+ids); return textMessage; } });
		 */
		jmsTemplate.send(topicDelDestination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(ids);
				return textMessage;
			}
		});

		return E3Result.ok();
	}

}
