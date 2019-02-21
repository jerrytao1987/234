package cn.itcast.gjp.controller;

import java.util.Date;
import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService zs = new ZhangWuService();

	public List<ZhangWu> selectAll() {
		return zs.selectAll();
	}

	public List<ZhangWu> select(Date startDate, Date endDate) {
		return zs.select(startDate,endDate);
	}

	public int updateZhangWu(ZhangWu zw) {
		return zs.updateZhangWu(zw);
	}
}
