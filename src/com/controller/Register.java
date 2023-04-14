package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class Register extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// Fetch the form data
			String raccno = req.getParameter("raccno");
			String rname = req.getParameter("rname");
			String rpass = req.getParameter("rpass");
			String remail = req.getParameter("remail");
			int rbalance = Integer.parseInt(req.getParameter("rbalance"));

			//Connect to model
			Model m = new Model();
			m.setAccno(raccno);
			m.setName(rname);
			m.setPass(rpass);
			m.setMail(remail);
			m.setBalance(rbalance);
		
			boolean status = m.register(raccno, rname, rpass, remail,rbalance);
			if (status == true) {
				resp.sendRedirect("/BankingApplication2/registersuccess.html");
			} else {
				resp.sendRedirect("/BankingApplication2/registerfail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
