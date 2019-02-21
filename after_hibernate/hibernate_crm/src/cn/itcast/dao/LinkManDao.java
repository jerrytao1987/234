package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;

public interface LinkManDao {

	void save(LinkMan lm);

	List<LinkMan> getAll();

	List<LinkMan> getAll(DetachedCriteria dc);

}
