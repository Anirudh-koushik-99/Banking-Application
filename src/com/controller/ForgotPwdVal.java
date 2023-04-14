package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotPwdVal extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String accno = req.getParameter("accno");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String np = req.getParameter("np");
			String cnp = req.getParameter("cnp");

			if (accno.length() == 0 || name.length() == 0 || email.length() == 0 || np.length() == 0
					|| cnp.length() == 0) {
				resp.sendRedirect("/BankingApplication2/forgotpwderror.html");
			} else {
				if (np.equals(cnp)) {
					req.getServletContext().getRequestDispatcher("/ForgotPwd").forward(req, resp);
				} else {
					resp.sendRedirect("/BankingApplication2/forgotpwderror.html");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
