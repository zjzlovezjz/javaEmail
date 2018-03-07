package com.imooc.dao;

import java.sql.SQLException;

import com.imooc.domain.User;

public interface UserDao {

	void regist(User user) throws SQLException;

	User findByCode(String code) throws SQLException;

	void update(User user) throws SQLException; 

}
