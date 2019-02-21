package cn.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;
import cn.e3mall.pojo.TbContentExample;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	@Autowired
	private TbContentMapper contentMapper;
	@Override
	public List<EasyUITreeNode> getContentCatList(Long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> catList = contentCategoryMapper.selectByExample(example );
		List<EasyUITreeNode> nodeList = new ArrayList<EasyUITreeNode>();
		for (TbContentCategory tbContentCategory : catList) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			nodeList.add(node);
		}
		return nodeList;
	}
	@Override
	public E3Result addContentCategory(long parentId, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		//1(正常),2(删除)
		contentCategory.setStatus(1);
		//默认排序就是1
		contentCategory.setSortOrder(1);
		Date date = new Date();
		contentCategory.setCreated(date);
		contentCategory.setUpdated(date);
		//新添加的节点一定是叶子节点
		contentCategory.setIsParent(false);
		contentCategoryMapper.insert(contentCategory);
		//根据parentId查询父节点
		TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!parent.getIsParent()){
			parent.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parent);
		}
		return E3Result.ok(contentCategory);
	}
	@Override
	public E3Result updateContentCategory(Long id, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setId(id);
		contentCategory.setName(name);
		contentCategory.setUpdated(new Date());
		contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
		return E3Result.ok();
	}
	
	@Override
	public E3Result deleteContentCategory(Long id) {
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(contentCategory.getParentId());
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example );
		if(list.isEmpty()){
			TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(contentCategory.getParentId());
			parent.setIsParent(false);
			parent.setUpdated(new Date());
			contentCategoryMapper.updateByPrimaryKey(parent);
		}
		batchDeleteContentCategory(id);
		return E3Result.ok();
	}
	
	//递归删除
	public void batchDeleteContentCategory(Long id){
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
		if(contentCategory.getIsParent()){
			TbContentCategoryExample example = new TbContentCategoryExample();
			Criteria criteria = example.createCriteria();
			criteria.andParentIdEqualTo(contentCategory.getId());
			List<TbContentCategory> list = contentCategoryMapper.selectByExample(example );
			for (TbContentCategory tbContentCategory : list) {
				batchDeleteContentCategory(tbContentCategory.getId());
			}
		}
		contentCategoryMapper.deleteByPrimaryKey(id);
		TbContentExample example=new TbContentExample();
		cn.e3mall.pojo.TbContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(id);
		contentMapper.deleteByExample(example);
	}
}
