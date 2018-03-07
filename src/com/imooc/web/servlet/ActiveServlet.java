package com.imooc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;

/**
 * 用户激活的servlet
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		     //1.接收激活码
		     String code = request.getParameter("code");
		
		     //2.根据激活码查询用户
		     UserService userService = new UserServiceImpl();
		     User user = userService.findByCode(code);
		
		     if(user!=null){
		    	  //已经查询到，修改用户的状态
		    	  user.setState(1);        //1:代表已经激活
		    	  user.setCode(null);      //设置为空是为了只激活一次就够
		    	  userService.update(user);
		    	  request.setAttribute("msg", "您已经激活成功，请去登录!");
		     }else{
		    	  //根据激活码没有查询到该用户
		    	  request.setAttribute("msg", "您的激活码有误，请重新激活！");
		     }
		     //3.页面跳转
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
