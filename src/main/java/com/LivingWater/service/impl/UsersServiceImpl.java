package com.LivingWater.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LivingWater.dao.UsersDao;
import com.LivingWater.entities.Users;
import com.LivingWater.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public List<Users> getAllUsers() {
		return usersDao.getAllUsers();
	}

	@Override
	public List<Users> getUsers(Users searchObject, int startPage, int maxResults) {
		return usersDao.getUsers(searchObject, startPage, maxResults);
	}

	@Override
	public void insertUser(Users user) {
		usersDao.insertUser(user);
		
	}

	@Override
	public void updateUser(Users user) {
		usersDao.updateUser(user);
	}

	@Override
	public void deleteUser(List<String> userIds) {
		usersDao.deleteUser(userIds);
	}

	@Override
	public Users getUserByUserId(String strUserId) {
		return usersDao.getUserByUserId(strUserId);
	}

}
