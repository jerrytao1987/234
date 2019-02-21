package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	public int addZhangWu(ZhangWu zw){
		return dao.addZhangWu(zw);
	}
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate, endDate);
	}
	public List<ZhangWu> selectAll(){
		return dao.selectAll();
	}
	public int editZhangWu(ZhangWu zw) {
		return dao.editZhangWu(zw);
	}
	public int deleteZhangWu(int id) {
		return dao.deleteZhangWu(id);
	}
}
