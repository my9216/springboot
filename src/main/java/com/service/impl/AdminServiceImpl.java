package com.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mapper.AdminMapper;
import com.model.Admin;
import com.service.IAdminService;

import java.awt.print.Book;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Resource
	AdminMapper adminMapper;

	@Override
	public void insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminMapper.insert(admin);
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	@Cacheable(cacheNames = "admin")
	public Admin addAdmin(int id) {
		simulateSlowService();
		return new Admin(id,"123",50);
	}

	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
