package cn.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.SaleVisitDao;
import cn.itcast.domain.SaleVisit;
import cn.itcast.service.SaleVisitService;
import cn.itcast.utils.PageBean;

@Service("saleVisitService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class SaleVisitServiceImpl implements SaleVisitService {
	
	private SaleVisitDao svd;
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(SaleVisit saleVisit) {
		svd.saveOrUpdate(saleVisit);
	}
	@Resource(name="saleVisitDao")
	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}
	@Override
	public PageBean<SaleVisit> getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = svd.getTotalCount(dc);
		PageBean<SaleVisit> pb = new PageBean<SaleVisit>(currentPage, totalCount, pageSize);
		List<SaleVisit> pageList = svd.getPageList(dc, pb.getStart(), pb.getPageSize());
		pb.setList(pageList);
		return pb;
	}
	@Override
	public SaleVisit getById(String visit_id) {
		return svd.getById(visit_id);
	}

}
