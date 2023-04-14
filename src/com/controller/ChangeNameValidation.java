package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeNameValidation extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// Fetch the form data
			String newname = req.getParameter("newname");
			String pass = req.getParameter("pass");

			// Validation of the form data
			if (newname.length() == 0 || pass.length() == 0) {
				resp.sendRedirect("/BankingApplication2/changenameerror.html");
			} else {
				req.getServletContext().getRequestDispatcher("/ChangeName").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
