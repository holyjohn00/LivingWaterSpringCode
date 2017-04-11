package com.LivingWater.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

import com.LivingWater.dao.UsersDao;
import com.LivingWater.entities.User;
import com.LivingWater.utility.StringUtility;

@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private JpaTransactionManager transactionManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		EntityManager entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
		Query sqlQuery = entityManager.createQuery("FROM Users users");
		List<User> userList = sqlQuery.getResultList();
		if (entityManager.isOpen())
			entityManager.close();

		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers(User searchObject, int startPage, int maxResults) {
		EntityManager entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
		StringBuilder sqlQuerySB = new StringBuilder("FROM Users users");
		boolean paramExists = false;

		if (!StringUtility.isStringNullOrEmpty(searchObject.getUserid()) || !StringUtility.isStringNullOrEmpty(searchObject.getFirstName())
				|| !StringUtility.isStringNullOrEmpty(searchObject.getFamilyName()) || !StringUtility.isStringNullOrEmpty(searchObject.getEmail())) {
			sqlQuerySB.append(" WHERE ");
		}

		if (!StringUtility.isStringNullOrEmpty(searchObject.getUserid())) {
			sqlQuerySB.append(" users.userid LIKE :userId ");
			paramExists = true;
		}

		if (!StringUtility.isStringNullOrEmpty(searchObject.getFamilyName())) {
			if (paramExists)
				sqlQuerySB.append(" AND ");
			else
				paramExists = true;
			sqlQuerySB.append(" users.familyName LIKE :familyName ");
		}

		if (!StringUtility.isStringNullOrEmpty(searchObject.getFirstName())) {
			if (paramExists)
				sqlQuerySB.append(" AND ");
			else
				paramExists = true;
			sqlQuerySB.append(" users.firstName LIKE :firstName ");
		}

		if (!StringUtility.isStringNullOrEmpty(searchObject.getEmail())) {
			if (paramExists)
				sqlQuerySB.append(" AND ");
			sqlQuerySB.append(" users.email LIKE :email ");
		}

		Query sqlQuery = entityManager.createQuery(sqlQuerySB.toString());

		if (!StringUtility.isStringNullOrEmpty(searchObject.getUserid())) {
			sqlQuery.setParameter("userId", "%" + searchObject.getUserid() + "%");
		}

		if (!StringUtility.isStringNullOrEmpty(searchObject.getFamilyName())) {
			sqlQuery.setParameter("familyName", "%" + searchObject.getFamilyName() + "%");
		}

		if (!StringUtility.isStringNullOrEmpty(searchObject.getFirstName())) {
			sqlQuery.setParameter("firstName", "%" + searchObject.getFirstName() + "%");
		}

		if (!StringUtility.isStringNullOrEmpty(searchObject.getEmail())) {
			sqlQuery.setParameter("email", "%" + searchObject.getEmail() + "%");
		}

		List<User> userList = sqlQuery.setFirstResult(startPage).setMaxResults(maxResults).getResultList();
		if (entityManager.isOpen())
			entityManager.close();

		return userList;
	}

	@Override
	public void insertUser(User user) {
		EntityManager entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
		} catch (Exception exc) {
			if (transaction.isActive())
				transaction.rollback();
		} finally {
			if (entityManager.isOpen())
				entityManager.close();
		}
	}

	@Override
	public void updateUser(User user) {
		EntityManager entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(user);
			transaction.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			if (transaction.isActive())
				transaction.rollback();
		} finally {
			if (entityManager.isOpen())
				entityManager.close();
		}
		System.out.println("MANA UG UPDATE");
	}

	@Override
	public void deleteUser(List<String> userIds) {
		EntityManager entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.createQuery("DELETE FROM Users user Where user.userid IN (:userIdList)").setParameter("userIdList", userIds).executeUpdate();
			transaction.commit();
		} catch (Exception exc) {
			if (transaction.isActive())
				transaction.rollback();
		} finally {
			if (entityManager.isOpen())
				entityManager.close();
		}
	}

	@Override
	public User getUserByUserId(String strUserId) {
		EntityManager entityManager = transactionManager.getEntityManagerFactory().createEntityManager();
		StringBuilder sqlQuerySB = new StringBuilder("FROM Users users WHERE users.userid = :userId");
		Query query = entityManager.createQuery(sqlQuerySB.toString());
		query.setParameter("userId", strUserId);
		User user = (User) query.getSingleResult();
		return user;
	}

}
