package com.journaldev.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.journaldev.dao.FilterDAO;
import com.journaldev.model.filters.ProducerFilter;

@WebServlet("/ServletFilterDAO")
public class ServletFilterDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Set <String> mobileFilterList;   
    
	public ServletFilterDAO() {
        super();
    }
    
    public void Init(){
    	mobileFilterList.add("ProducerFilter");
		mobileFilterList.add("OZUFilter");
		mobileFilterList.add("ButteryFilter");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession currentSession = request.getSession();
		String req = (String) request.getParameter("menuName");
		FilterDAO filterDAO = null;
		List <ProducerFilter> producerFilterList= new ArrayList<>();
		if(req.equalsIgnoreCase("MenuMobPhone")){
			System.out.println("request menuName = " + req);
			currentSession.setAttribute("selecteMenu", req);
			filterDAO = new FilterDAO(req);
			producerFilterList = filterDAO.getProdecerFilter();
		}
		
		currentSession.setAttribute("ProducerFilterList", producerFilterList);
		request.getRequestDispatcher("/addProduct.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
