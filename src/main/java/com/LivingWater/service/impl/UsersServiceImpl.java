package com.LivingWater.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LivingWater.dao.UsersDao;
import com.LivingWater.entities.User;
import com.LivingWater.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}

	@Override
	public List<User> getUsers(User searchObject, int startPage, int maxResults) {
		return usersDao.getUsers(searchObject, startPage, maxResults);
	}

	@Override
	public void insertUser(User user) {
		usersDao.insertUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		usersDao.updateUser(user);
	}

	@Override
	public void deleteUser(List<String> userIds) {
		usersDao.deleteUser(userIds);
	}

	@Override
	public User getUserByUserId(String strUserId) {
		return usersDao.getUserByUserId(strUserId);
	}

}
