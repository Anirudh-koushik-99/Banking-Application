package com.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Model extends HttpServlet {
	// ALL COLUMNS DECLARATIONS
	private String accno;
	private String name;
	private String pass;
	private String mail;
	private int balance;

	// SETTERS AND GETTERS
	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getAccno() {
		return accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// LOGIN CREDENTIALS
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String pwd = "system";
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	PrintWriter pw = null;
	HttpSession hs = null;

	// CONSTRUCTOR
	public Model() {
		// Loading the driver
		try {
			Class.forName(driver);
			// Establish the Connection
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean login() {
		try {
			String sql = "select * from JUNE_BANK where ACCNO = ? and PASS = ?";
			// Creating the medium
			pst = con.prepareStatement(sql);
			// Completing the query
			pst.setString(1, accno);
			pst.setString(2, pass);

			// Execute the query
			rs = pst.executeQuery();

			// Fetching and disply the data
			if (rs.next() == true) {
				accno = rs.getString(1);
				name = rs.getString(2);
				pass = rs.getString(3);
				mail = rs.getString(4);
				balance = rs.getInt(5);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean viewBalance() {
		try {
			String sql1 = "select BALANCE from JUNE_BANK where ACCNO = ?";
			pst = con.prepareStatement(sql1);
			pst.setString(1, accno);
			rs = pst.executeQuery();

			if (rs.next() == true) {
				balance = rs.getInt("balance");
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean changePwd(String np) {
		try {
			String sql2 = "update JUNE_BANK set PASS = ? where accno = ? and pass = ?";
			pst = con.prepareStatement(sql2);
			pst.setString(1, np);
			pst.setString(2, accno);
			pst.setString(3, pass);
			int row = pst.executeUpdate();
			if (row == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean changeName(String newname) {
		try {
			String sql3 = "update JUNE_BANK set name = ? where accno = ? and pass = ?";
			pst = con.prepareStatement(sql3);
			pst.setString(1, newname);
			pst.setString(2, accno);
			pst.setString(3, pass);
			int row = pst.executeUpdate();
			if (row == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean register(String raccno, String rname, String rpass, String remail, int rbalance) {
		try {
			String sql4 = "insert into JUNE_BANK values (?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql4);
			pst.setString(1, raccno);
			pst.setString(2, rname);
			pst.setString(3, rpass);
			pst.setString(4, remail);
			pst.setInt(5, rbalance);
			int row = pst.executeUpdate();
			if (row == 0) {
				System.out.println("row = 0 ");
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean transfer(int amount, String taccno) {
		try {
			String sql5 = "update JUNE_BANK set BALANCE = BALANCE - ? where ACCNO  = ?";
			pst = con.prepareStatement(sql5);
			pst.setInt(1, amount);
			pst.setString(2, accno);
			int row1 = pst.executeUpdate();

			String sql6 = "update JUNE_BANK set BALANCE = BALANCE + ? where ACCNO  = ?";
			pst = con.prepareStatement(sql6);
			pst.setInt(1, amount);
			pst.setString(2, taccno);
			int row2 = pst.executeUpdate();

			if (row1 == 0 || row2 == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean forgotPassword(String np) {
		try {
			String sql7 = "update JUNE_BANK set pass = ? where accno = ? and name = ? and mail = ?";
			pst = con.prepareStatement(sql7);
			pst.setString(1, np);
			pst.setString(2, accno);
			pst.setString(3, name);
			pst.setString(4, mail);
			int row = pst.executeUpdate();

			if (row == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
