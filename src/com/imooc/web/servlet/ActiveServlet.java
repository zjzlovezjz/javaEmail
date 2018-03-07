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
 * �û������servlet
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		     //1.���ռ�����
		     String code = request.getParameter("code");
		
		     //2.���ݼ������ѯ�û�
		     UserService userService = new UserServiceImpl();
		     User user = userService.findByCode(code);
		
		     if(user!=null){
		    	  //�Ѿ���ѯ�����޸��û���״̬
		    	  user.setState(1);        //1:�����Ѿ�����
		    	  user.setCode(null);      //����Ϊ����Ϊ��ֻ����һ�ξ͹�
		    	  userService.update(user);
		    	  request.setAttribute("msg", "���Ѿ�����ɹ�����ȥ��¼!");
		     }else{
		    	  //���ݼ�����û�в�ѯ�����û�
		    	  request.setAttribute("msg", "���ļ��������������¼��");
		     }
		     //3.ҳ����ת
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
