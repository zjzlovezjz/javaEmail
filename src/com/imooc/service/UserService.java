package com.imooc.service;

import java.sql.SQLException;

import com.imooc.domain.User;

public interface UserService {

	void regist(User user) throws Exception;

	User findByCode(String code) throws Exception;

	void update(User user) throws Exception;


}
