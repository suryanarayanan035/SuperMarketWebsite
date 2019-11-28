package com.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDaoImpl;
import com.mysql.jdbc.Blob;


public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Blob blob=null;
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id").toString());
		ProductDaoImpl dao= new ProductDaoImpl();
		try {
			ResultSet rs=dao.viewProducts(id);
			rs.next();
			InputStream is = rs.getBinaryStream(5);
			OutputStream output = response.getOutputStream();
			response.setContentType("image/gif");
			blob=(Blob) rs.getBlob(5);
			 int length = (int) blob.length();
			 int bufferSize=4096;
			 byte []buffer = new byte[bufferSize];
			 while ((length = is.read(buffer)) != -1) {
			        System.out.println("writing " + length + " bytes");
			        output.write(buffer, 0, length);
			      }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		ProductDaoImpl dao= new ProductDaoImpl();
		try {
			ResultSet rs=dao.viewProducts(id);
			InputStream is = rs.getBinaryStream(5);
			OutputStream output = response.getOutputStream();
			response.setContentType("image/gif");
			blob=(Blob) rs.getBlob(5);
			 int length = (int) blob.length();
			 int bufferSize=4096;
			 byte []buffer = new byte[bufferSize];
			 while ((length = is.read(buffer)) != -1) {
			        System.out.println("writing " + length + " bytes");
			        output.write(buffer, 0, length);
			      }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
