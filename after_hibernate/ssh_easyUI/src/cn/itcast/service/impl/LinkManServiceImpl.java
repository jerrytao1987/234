package cn.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.utils.PageBean;

@Service("linkManService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class LinkManServiceImpl implements LinkManService {
	
	private LinkManDao lmd;
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(LinkMan linkMan) {
		lmd.saveOrUpdate(linkMan);

	}
	@Resource(name="linkManDao")
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		int totalCount = lmd.getTotalCount(dc);
		PageBean<LinkMan> pb = new PageBean(currentPage, totalCount, pageSize);
		List<LinkMan> list = lmd.getPageList(dc, pb.getStart(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	@Override
	public LinkMan getById(Long lkm_id) {
		LinkMan linkMan = lmd.getById(lkm_id);
		return linkMan;
	}
	
}
