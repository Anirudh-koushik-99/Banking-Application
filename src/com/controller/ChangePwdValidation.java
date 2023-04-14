package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePwdValidation extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// Fetch the form data
			String op = req.getParameter("op");
			String np = req.getParameter("np");
			String cp = req.getParameter("cp");

			// Validation of the form data
			if (op.length() == 0 || np.length() == 0 || cp.length() == 0) {
				resp.sendRedirect("/BankingApplication2/changepwderror.html");
			} else {
				if (np.equals(cp)) {
					req.getServletContext().getRequestDispatcher("/ChangePwd").forward(req, resp);
				}
				else{
					resp.sendRedirect("/BankingApplication2/changepwderror.html");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
