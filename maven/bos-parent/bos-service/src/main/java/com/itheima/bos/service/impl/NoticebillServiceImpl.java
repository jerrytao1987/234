package com.itheima.bos.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IDecidedzoneDao;
import com.itheima.bos.dao.INoticebillDao;
import com.itheima.bos.dao.IWorkbillDao;
import com.itheima.bos.entity.Decidedzone;
import com.itheima.bos.entity.Noticebill;
import com.itheima.bos.entity.Staff;
import com.itheima.bos.entity.User;
import com.itheima.bos.entity.Workbill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.crm.ICustomerService;
@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService {
	@Autowired
	private IWorkbillDao workbillDao;
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private INoticebillDao noticebillDao;
	
	@Override
	public void save(Noticebill model) {
		User user = BOSUtils.getLoginUser();
		model.setUser(user);
		noticebillDao.save(model);
		String pickaddress = model.getPickaddress();
		String decidedzoneId = customerService.findDecidedzoneIdByAddress(pickaddress);
		if(decidedzoneId != null){
			Decidedzone decidedzone = decidedzoneDao.findById(decidedzoneId);
			Staff staff = decidedzone.getStaff();
			model.setStaff(staff);
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));
			workbill.setNoticebill(model);
			workbill.setPickstate(Workbill.PICKSTATE_NO);
			workbill.setStaff(staff);
			workbill.setType(Workbill.TYPE_1);
			workbillDao.save(workbill);
		}else{
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
	}
}
