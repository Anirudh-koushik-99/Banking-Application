package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BalValidation extends HttpServlet {

		protected void service(HttpServletRequest req, HttpServletResponse resp){
			try {
				String pass = req.getParameter("pass");
				if(pass.length()==0){
					resp.sendRedirect("/BankingApplication2/balanceerror.html");
				}
				else{
					req.getServletContext().getRequestDispatcher("/Balance").forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
