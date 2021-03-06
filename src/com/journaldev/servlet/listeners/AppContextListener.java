package com.journaldev.servlet.listeners;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import com.journaldev.dao.MenuDAO;
import com.journaldev.model.FilterMenu;
import com.journaldev.model.MenuImpl;
import com.journaldev.model.Product;
import com.journaldev.util.DBConnectionManager;
import com.journaldev.util.DataInitialisation;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	System.out.println("!!!!!contextInitialized!!!!");
    	//initialize DB Connection
    	
    	String dbURL = ctx.getInitParameter("dbURL");
    	String user = ctx.getInitParameter("dbUser");
    	String pwd = ctx.getInitParameter("dbPassword");
    	
    	System.out.println("dbURL = " + dbURL);
    	
    	try {
			DBConnectionManager connectionManager = new DBConnectionManager(dbURL);
			ctx.setAttribute("DBConnection", connectionManager.getConnection());
			System.out.println("DB Connection initialized successfully.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	    	
    	/*Зробитти загрузку з xml,загрузку класу через спрінг
    	 *Ініціалізація кодбуків 
    	 * */
    	DataInitialisation dataInitialisation = DataInitialisation.INIT();
    	List<MenuImpl> menuList = dataInitialisation.MENUINIT();
    	List<Product> productLst = dataInitialisation.PRODUCTLISTINIT();
    	Map<String, HashMap<String, String>> filterConfig = new HashMap<String,  HashMap<String, String>>();
    	FilterMenu selectedFilterList = new FilterMenu();
		/*filterConfig.put("PRODUCER_FILTER", producerFilterConfig);
    	ctx.setAttribute("productsListCtx", productLst);*/
		
		//Menu ProductList initialisation strat
		
    	ctx.setAttribute("selectedFilters", selectedFilterList);
		ctx.setAttribute("menuProductsMapCtx", menuList);
		//Menu ProductList initialisation End
		
		
    	
    	
    	//initialize log4j
    	String log4jConfig = ctx.getInitParameter("log4j-config");
    	if(log4jConfig == null){
    		System.err.println("No log4j-config init param, initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
    	}else {
			String webAppPath = ctx.getRealPath("/");
			String log4jProp = webAppPath + log4jConfig;
			File log4jConfigFile = new File(log4jProp);
			if (log4jConfigFile.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				DOMConfigurator.configure(log4jProp);
			} else {
				System.err.println(log4jProp + " file not found, initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
    	System.out.println("log4j configured properly");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	Connection con = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
    	try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}