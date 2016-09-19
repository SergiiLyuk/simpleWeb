package com.journaldev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.journaldev.model.LoginingUser;
import com.journaldev.model.RegistrationUser;

/*@WebServlet( "/Register" )*/
public class RegisterServlet extends HttpServlet {
	private String redirectToLogin = "login.html";
	
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Gson gson = null;
	private String jsonrequestToString = null;
	private String jsonPageRedirect = null;
	private RegistrationUser registrationUser = null;
	
	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(RegisterServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		con =  (Connection) getServletContext().getAttribute("DBConnection");
		jsonrequestToString = request.getParameter("user");
		System.out.println("jsonrequestToString = " + jsonrequestToString);
		gson = new Gson();
		registrationUser = (RegistrationUser) gson.fromJson(jsonrequestToString,RegistrationUser.class);
		System.out.println(registrationUser);
		/*String userName = registrationUser.getUserName();
		String userEMail = registrationUser.getUserEMail();
		String userCountry = registrationUser.getUserCountry();
		String userPwd = registrationUser.getUserPwd();*/
		
	/*	String errorMsg = null;*/
		
		
		
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");/*DriverManager.getConnection("jdbc:sqlite:D:\\Work\\Other\\java_lessons\\ServletDSLof4JExample\\Users.db");*/
		System.out.println("Connection = " + con);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into Users(name,email,country, password) values (?,?,?,?)");
			ps.setString(1,  registrationUser.getUserName());
			ps.setString(2, registrationUser.getUserEMail());
			ps.setString(3, registrationUser.getUserCountry());
			ps.setString(4, registrationUser.getUserPwd());
			
			ps.executeUpdate();
			System.out.println("PreparedStatement = " + ps);
			//logger.info("User registered with email="+email);
			
			//forward to login page to login
			jsonPageRedirect = new Gson().toJson(redirectToLogin);
			System.out.println("json = " + jsonPageRedirect);
		    response.getWriter().write(jsonPageRedirect);
			/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=green>Registration successful, please login below.</font>");
			rd.include(request, response);*/
			
			
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Database connection problem");
			throw new ServletException("DB Connection problem.");
		}finally{
			try {
				ps.close();
				System.out.println("End Finaly");
			} catch (SQLException e) {
				logger.error("SQLException in closing PreparedStatement");
			}
		}
		
		/*jsonPageRedirect = new Gson().toJson(redirectToLogin);
		System.out.println("json = " + jsonPageRedirect);
	    response.getWriter().write(jsonPageRedirect);*/
		}
		
	}

