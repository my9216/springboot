package com.service;

import com.model.Admin;

public interface IAdminService {

	void insertAdmin(Admin admin);

	Admin getAdminById(int id);

	Admin addAdmin(int id);

}
