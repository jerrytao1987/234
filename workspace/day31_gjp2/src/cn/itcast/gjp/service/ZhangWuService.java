package cn.itcast.gjp.service;

import java.util.Date;
import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao zd = new ZhangWuDao();

	public List<ZhangWu> selectAll() {
		return zd.selectAll();
	}

	public List<ZhangWu> select(Date startDate, Date endDate) {
		return zd.select(startDate,endDate);
	}

	public int updateZhangWu(ZhangWu zw) {
		return zd.updateZhangWu(zw);
	}
}
