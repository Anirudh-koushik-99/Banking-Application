<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Display</title>
</head>
<body>
	<%
		session = request.getSession();
		String name = (String) session.getAttribute("name");
		String accno = (String) session.getAttribute("accno");

		out.println("<h3>Welcome " + name + " </h3><br>");
		out.println("Account number :" + accno + "<br>");
	%>
	<br>
	<a href="/BankingApplication2/balance.html">View Balance</a>
	<br>
	<a href="/BankingApplication2/loan.html">Apply Loan</a>
	<br>
	<a href="/BankingApplication2/transfer.html">Transfer Money</a>
	<br>
	<a href="/BankingApplication2/changepwd.html">Change Password</a>
	<br>
	<a href="/BankingApplication2/changename.html">Change Name</a>
	<br>
	<a href="/BankingApplication2/Logout.jsp">Logout</a>

</body>
</html>