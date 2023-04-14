package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class ChangeName extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String newname = req.getParameter("newname");
			String pass = req.getParameter("pass");

			HttpSession hs = req.getSession();

			// get value from session
			String accno = (String) hs.getAttribute("accno");

			// get form data
			Model m = new Model();
			m.setAccno(accno);
			m.setPass(pass);
			
			boolean status = m.changeName(newname);
			if (status == true) {
				resp.sendRedirect("/BankingApplication2/changenamesuccess.html");
			} else {
				resp.sendRedirect("/BankingApplication2/changenamefail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
