package com.springdemo.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class UserServiceImpl implements UserService {
	private TransactionTemplate tt;
	public TransactionTemplate getTt() {
		return tt;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}

	public void save() {
		System.out.println("保存用户");
		tt.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				System.out.println("执行增删改操作");
			}
		});
	}

	public void delete() {
		System.out.println("删除用户");
	}

	public void update() {
		System.out.println("更新用户");
	}

	public void find() {
		System.out.println("查询用户");
	}

}
