package org.ahmadiyya.halqa.software.dao;

import org.ahmadiyya.halqa.software.model.User;

public interface UserDao {

	User findByUserName(String username);

}
