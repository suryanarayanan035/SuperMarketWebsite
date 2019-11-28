package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDaoImpl;
import com.models.Admin;

public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Admin admin=new Admin();
			HttpSession session=request.getSession(true);
			String adminID=request.getParameter("adminID").toString();
			String password=request.getParameter("password").toString();
			admin.setAdminId(adminID);
			admin.setPassword(password);
			AdminDaoImpl dao=new AdminDaoImpl();
			Boolean i;
			try {
				
			 i=dao.login(admin);
			 System.out.println(i);
			if(i==true)
			{
				String msg="Success";
				session.setAttribute("msg", msg);
				session.setAttribute("adminId", admin.getAdminId());
				response.sendRedirect("Dashboard.jsp");
			}
			else
			{
				String msg="Error retry again";
				session.setAttribute("msg", msg);
				response.sendRedirect("AdminLogin.jsp");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
