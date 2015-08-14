package org.ahmadiyya.halqa.software.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ahmadiyya.halqa.software.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String username) {
		List<User> users = new ArrayList<User>();
		users = entityManager.createQuery("from User where username=?0")
				.setParameter(0, username).getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
