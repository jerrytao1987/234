package com.itheima.bos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IWorkordermanageDao;
import com.itheima.bos.entity.Workordermanage;
@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService {
	@Autowired
	private IWorkordermanageDao workordermanageDao;
	@Override
	public void save(Workordermanage model) {
		workordermanageDao.save(model);

	}

}
