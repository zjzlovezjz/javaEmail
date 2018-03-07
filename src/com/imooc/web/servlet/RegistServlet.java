package com.imooc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;
import com.imooc.utils.UUIDUtils;

/**
 * 用户注册的Servlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
		//接收数据,处理中文乱码
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
	   //封装数据
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setEmail(email);
		user.setState(0);   //0:代表未激活 1：代表已经激活
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID(); //产生一个是32位，觉得不够再加一个变成64位
		user.setCode(code);
	   //调用业务层处理数据
		UserService userService = new UserServiceImpl();
		userService.regist(user);
	   //进行页面的跳转
		request.setAttribute("msg", "您已经注册成功！请去邮箱激活！");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
       }catch(Exception e){
    	   e.printStackTrace();
    	   throw new RuntimeException();
       }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
