package cn.itcast.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.springmvc.mapper.ItemsMapper;
import cn.itcast.springmvc.pojo.Items;
import cn.itcast.springmvc.pojo.ItemsExample;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> queryItemList() {
		//ItemsExample example=new ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(null);
		return list;
	}

	@Override
	public Items queryItemById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateItem(Items item) {
		itemsMapper.updateByPrimaryKeySelective(item);
	}

}
