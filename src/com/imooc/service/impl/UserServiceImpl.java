package com.imooc.service.impl;

import com.imooc.dao.UserDao;
import com.imooc.dao.impl.UserDaoImpl;
import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.utils.MailUtils;

public class UserServiceImpl implements UserService {

	//ҵ����û�ע��ķ���
	@Override
	public void regist(User user) throws Exception{
		//�����ݴ������ݿ�
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		//����һ�⼤���ʼ�
		MailUtils.sendMail(user.getEmail(), user.getCode());
	}

	//���ݼ������ѯ�û��ķ���
	@Override
	public User findByCode(String code) throws Exception {
		UserDao userDao = new UserDaoImpl();
		return userDao.findByCode(code);
	}

	//ҵ����޸��û��ķ�������Ҫ���޸ļ���״̬����ռ�����
	@Override
	public void update(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.update(user);
	}

}
