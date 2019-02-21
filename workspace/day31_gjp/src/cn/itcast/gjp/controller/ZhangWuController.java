package cn.itcast.gjp.controller;

import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	public int editZhangWu(ZhangWu zw){
		return service.editZhangWu(zw);
	}
	public int addZhangWu(ZhangWu zw){
		return service.addZhangWu(zw);
	}
	public List<ZhangWu> select(String startDate,String endDate){
		return service.select(startDate, endDate);
	}
	public List<ZhangWu> selectAll(){
		return service.selectAll();
	}
	public int deleteZhangWu(int id) {
		return service.deleteZhangWu(id);
	}
}
