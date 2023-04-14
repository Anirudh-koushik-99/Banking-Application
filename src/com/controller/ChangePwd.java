package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class ChangePwd extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String op = req.getParameter("op");
			String np = req.getParameter("np");

			HttpSession hs = req.getSession();

			// get value from session
			String accno = (String) hs.getAttribute("accno");

			// get form data
			Model m = new Model();
			m.setAccno(accno);
			m.setPass(op);
			
			boolean status = m.changePwd(np);
			if (status == true) {
				resp.sendRedirect("/BankingApplication2/changepwdsuccess.html");
			} else {
				resp.sendRedirect("/BankingApplication2/changepwdfail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
