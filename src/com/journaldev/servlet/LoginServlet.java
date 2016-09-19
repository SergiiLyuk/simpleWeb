package com.journaldev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.journaldev.model.LoginingUser;
import com.journaldev.util.User;

/*@WebServlet( "/Login" )*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextHomePage = "home.jsp";
	private String nextRegistrationPage = "register.html";
	
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Gson gson = null;
	private String jsonrequestToString = null;
	private String jsonPageRedirect = null;
	private LoginingUser loginUser = null;
	
	static Logger logger = Logger.getLogger(LoginServlet.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		con =  (Connection) getServletContext().getAttribute("DBConnection");
		jsonrequestToString = request.getParameter("d");
		gson = new Gson();
		loginUser = (LoginingUser) gson.fromJson(jsonrequestToString,LoginingUser.class);
		
		String login = loginUser.getUserLogin();
		String pwd = loginUser.getUserPwd();
		System.out.println(loginUser);
		try {
			ps = con.prepareStatement("select name, password from Users where name=? and password=? ");
			ps.setString(1, login);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			
			/*ps = con.prepareStatement("select id, name, email, country from Users where name=? and password=? ");
			ps.setString(1, login);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			
			User user = new User(rs.getString("name"),
					rs.getString("email"), rs.getString("country"),
					rs.getInt("id"));
			System.out.println(user);*/
			if ( rs.next()) {
				ps = con.prepareStatement("select id, name, email, country from Users where name=? and password=? ");
				ps.setString(1, login);
				ps.setString(2, pwd);
				rs = ps.executeQuery();
				
				User user = new User(rs.getString("name"),
						rs.getString("email"), rs.getString("country"),
						rs.getInt("id"));
				System.out.println(user);
				logger.info("User found with details=" + user);
				HttpSession session = request.getSession();
				session.setAttribute("User", user);
				//response.sendRedirect("home.jsp");
				jsonPageRedirect = new Gson().toJson(nextHomePage);
				System.out.println("json = " + jsonPageRedirect);
				System.out.println("User  serched");
			    response.getWriter().write(jsonPageRedirect);
				
			} else {
				jsonPageRedirect = new Gson().toJson(nextRegistrationPage);
				System.out.println("json = " + jsonPageRedirect);
				System.out.println("User no serched");
			    response.getWriter().write(jsonPageRedirect);
				logger.error("User not found with email=" + login);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Database connection problem");
			throw new ServletException("DB Connection problem.");
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				logger.error("SQLException in closing PreparedStatement or ResultSet");
				;
			}

		}
	}
}
