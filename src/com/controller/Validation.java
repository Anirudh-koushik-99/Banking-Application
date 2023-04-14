package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// Fetch the form data
			String accno = req.getParameter("accno");
			String pass = req.getParameter("pass");

			// Validation of the form data
			if (accno.length() != 4 || pass.length() == 0) {
				resp.sendRedirect("/BankingApplication2/invalidLogin.html");
			} else {
				req.getServletContext().getRequestDispatcher("/Login").forward(req, resp);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
