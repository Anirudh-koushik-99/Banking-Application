package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;

public class ForgotPwd extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String accno = req.getParameter("accno");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String np = req.getParameter("np");
			String cnp = req.getParameter("cnp");
			
			Model m = new Model();
			m.setAccno(accno);
			m.setName(name);
			m.setMail(email);	
			
			boolean status = m.forgotPassword(np);
			if(status == true){
				resp.sendRedirect("/BankingApplication2/forgotpwdsuccess.html");
			}
			else{
				resp.sendRedirect("/BankingApplication/forgotpwdfail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
