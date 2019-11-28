package com.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.ProductDaoImpl;
import com.models.Products;

@MultipartConfig
public class ProductRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Products product=new Products();
		HttpSession session=request.getSession();
		ProductDaoImpl dao=new ProductDaoImpl();
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		Part part=request.getPart("image");
		InputStream is=null;
		if(part!=null)
		{
			System.out.println(part.getName());
			System.out.println(part.getSize());
			System.out.println(part.getContentType());
			is=part.getInputStream();
		}
		product.setImage(is);
		product.setPrice(Integer.parseInt(request.getParameter("price").toString()));
		product.setMarketId(session.getAttribute("marketId").toString());
		try
		{
			int i=dao.registerProducts(product);
			if(i!=0)
			{
				session.setAttribute("mas", "Product Added Succesfully");
				response.sendRedirect("AddProducts.jsp");
			}
			else
			{
				System.out.println("Error Occured");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
