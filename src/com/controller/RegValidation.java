package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegValidation extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// Fetch the form data
			String raccno = req.getParameter("raccno");
			String rname = req.getParameter("rname");
			String rpass = req.getParameter("rpass");
			String remail = req.getParameter("remail");
			String rbalance = req.getParameter("rbalance");
			
			// Validation of the form data
			if (rname.length() == 0 || rpass.length() == 0 || raccno.length() != 4 || remail.length() == 0 || rbalance.length() == 0) {
				resp.sendRedirect("/BankingApplication2/registereerror.html");
			} else {
				req.getServletContext().getRequestDispatcher("/Register").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
