package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class Transfer extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// Fetch the form data
			String taccno = req.getParameter("taccno");
			int amount = Integer.parseInt(req.getParameter("amount"));
			String pass = req.getParameter("pass");

			// Get data from session
			HttpSession hs = req.getSession();
			String accno = (String) hs.getAttribute("accno");

			// Connect to model
			Model m = new Model();
			m.setAccno(accno);

			boolean status1 = m.viewBalance();
			if (status1 == true) {
				int bal = m.getBalance();
				if (bal > amount) {
					boolean status2 = m.transfer(amount, taccno);
					if (status2 == true) {
						resp.sendRedirect("/BankingApplication2/transfersuccess.html");
					} else {
						resp.sendRedirect("/BankingApplication2/transferfail.html");
					}
				} else {
					resp.sendRedirect("/BankingApplication2/transferfail.html");
				}
			} else {
				resp.sendRedirect("/BankingApplication2/transferfail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
