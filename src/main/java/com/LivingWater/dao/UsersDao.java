package com.LivingWater.dao;

import java.util.List;

import com.LivingWater.entities.User;

public interface UsersDao {

	public List<User> getAllUsers();

	public List<User> getUsers(User searchObject, int startPage, int maxResults);
	
	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(List<String> userIds);

	public User getUserByUserId(String strUserId);
}
