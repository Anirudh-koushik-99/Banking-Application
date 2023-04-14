package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class Login extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// Fetch the form data
			String accno = req.getParameter("accno");
			String pass = req.getParameter("pass");

			// Connect with Model.java
			Model m = new Model();
			// set the values
			m.setAccno(accno);
			m.setPass(pass);

			boolean status = m.login();
			if (status = true) {
				String a = m.getAccno();
				String b = m.getName();
				String c = m.getPass();
				String d = m.getMail();
				int e = m.getBalance();

				// create a session
				HttpSession hs = req.getSession();
				hs.setAttribute("accno", a);
				hs.setAttribute("name", b);
				hs.setAttribute("pass", c);
				hs.setAttribute("mail", d);
				hs.setAttribute("balance", e);

				resp.sendRedirect("/BankingApplication2/welcome.jsp");
			} else {
				resp.sendRedirect("/BankingApplication2/incorrect.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
