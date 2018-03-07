package com.imooc.service.impl;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtils;

public class UserServiceImpl implements UserService {

	//业务层用户注册的方法
	@Override
	public void regist(User user) throws Exception{
		//将数据存入数据库
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		//发送一封激活邮件
		MailUtils.sendMail(user.getEmail(), user.getCode());
	}

	//根据激活码查询用户的方法
	@Override
	public User findByCode(String code) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.findByCode(code);
	}

	//业务层修改用户的方法，主要是修改激活状态和清空激活码
	@Override
	public void update(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.update(user);
	}

}
