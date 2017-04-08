package com.LivingWater.service;

import java.util.List;

import com.LivingWater.entities.Users;

public interface UsersService {

	public List<Users> getAllUsers();

	public List<Users> getUsers(Users searchObject, int startPage, int maxResults);

	public void insertUser(Users user);

	public void updateUser(Users user);

	public void deleteUser(List<String> userIds);

	public Users getUserByUserId(String strUserId);
}
