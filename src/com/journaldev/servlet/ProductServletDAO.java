package com.journaldev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.journaldev.dao.ProductDAOImpl;
import com.journaldev.model.FilterMenu;
import com.journaldev.model.Product;
import com.journaldev.model.filters.SearchFilterInterface;


/*@WebServlet("/ProductServletDAO")*/
public class ProductServletDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ProductServletDAO.class);   
	private HttpSession currentsession = null;
    public ProductServletDAO() {
        super();
        
    }

	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("selecteMenu = " + request.getParameter("selecteMenu"));
		System.out.println("producerName = " + request.getParameter("producerName"));
		System.out.println("cheked = " + request.getParameter("cheked"));
		
		
		String selecteMenu = request.getParameter("selecteMenu");
		String filterValue = request.getParameter("producerName");
		String fiterIsCheked = request.getParameter("cheked");
			
		
		FilterMenu selectedFilterList = (FilterMenu) getServletContext().getAttribute("selectedFilters");
		selectedFilterList.setMenuName(selecteMenu);
		
		List <SearchFilterInterface> filtersList = (List<SearchFilterInterface>) request.getSession().getAttribute("ProducerFilterList");
				
		System.out.println("Filters = " + filtersList);
		
		Iterator <SearchFilterInterface> filtersListIter = filtersList.iterator();
		
		if(fiterIsCheked == null || fiterIsCheked.equals("0")){
			while(filtersListIter.hasNext()){
				SearchFilterInterface filter = filtersListIter.next();
				if(filter.getFilterName().equalsIgnoreCase(filterValue)){
					filter.setFiterIsChecked("1");
					selectedFilterList.addSelectedFilter(filter);
					filtersList = selectedFilterList.deleteFilterFromFiltersList(filtersList, filterValue);
					break;
				}
			}
		}else if(fiterIsCheked != null && fiterIsCheked.equals("1")){
			List <SearchFilterInterface>  selectedFilterList1= selectedFilterList.getSelectedFilter();
			Iterator<SearchFilterInterface> selectedFilterList1Iter = selectedFilterList1.iterator();
			while(selectedFilterList1Iter.hasNext()){
				SearchFilterInterface filter =  selectedFilterList1Iter.next();
				System.out.println(filter.getFilterName() +" = " + filterValue +"    "+ filter.getFilterName().equalsIgnoreCase(filterValue));
				if(filter.getFilterName().equalsIgnoreCase(filterValue)){
					System.out.println("filter name = " + filter.getFilterName());
					filter.setFiterIsChecked("0");
					System.out.println("selectedFilterList before remove = " + selectedFilterList.getSelectedFilter());
					selectedFilterList.removeSelectedFilter(filter);
					System.out.println("selectedFilterList after remove = " + selectedFilterList.getSelectedFilter());
					filtersList.add(filter);
					break;
				}
			}
		}
		
		
		
		
		request.getSession().setAttribute("ProducerFilterList", filtersList);
		request.getSession().setAttribute("SelectedFilters", selectedFilterList.getSelectedFilter());
		/*System.out.println(request.getParameter("price010"));
		String reqParam = request.getParameter("price010");
		List<Product> listProdAfterFilter = new ArrayList<>();
		List<Product> productLst = new ArrayList<Product>();
		List<Product> setList = new ArrayList<Product>();
		productLst.add(new Product("Phone0",2.00, "Phone0 description"));
		productLst.add(new Product("Phone1",10.00,"Phone1 description"));
		productLst.add(new Product("Phone2",20.00,"Phone2 description"));
		productLst.add(new Product("Phone3",30.00,"Phone3 description"));
		productLst.add(new Product("Phone4",40.00,"Phone4 description"));
		productLst.add(new Product("Phone5",50.00,"Phone5 description"));
		productLst.add(new Product("Phone6",60.00,"Phone6 description"));
		productLst.add(new Product("Phone7",70.00,"Phone7 description"));
		productLst.add(new Product("Phone8",80.00,"Phone8 description"));
		
		Iterator<Product> prIter = productLst.iterator();
		//System.out.println("IUALS = " + jsonrequestToString.equals("price010"));
		if(reqParam.equals("price010") ){
		
			
			while(prIter.hasNext()){
				if(prIter.next().getProductPrice() <= 10.00){
					System.out.println(prIter.next());
					listProdAfterFilter.add((Product)(prIter.next()));
				}
			}
			logger.info("listProdAfterFilter = " + listProdAfterFilter);
			System.out.println("listProdAfterFilter = " + listProdAfterFilter.size());
			setList = listProdAfterFilter;
			System.out.println(setList);
			request.setAttribute("productsList", setList);
		}else{
			setList = productLst;
			System.out.println("FALSE!!!");
			System.out.println(setList);
			logger.info("FALSE!!!");
			
			
		}
		
		System.out.println("servlrt product list" + setList);
		request.setAttribute("productsList", setList);*/
		request.getRequestDispatcher("/addProduct.jsp").forward(request, response);
		
		
	}

	
	protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		ProductDAOImpl productDAOImpl = null;
		Product product = new Product();
		con = (Connection) getServletContext().getAttribute("DBConnection");
		productDAOImpl = new ProductDAOImpl(con);
		
		
				
		try {
			
			
			if(request.getParameter("getProducts")==null){
				String productName = request.getParameter("productName");
				double productPrice = Double.parseDouble(request.getParameter("productPrice"));
				
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				
				productDAOImpl.addProduct(product);
		
		}else{
			
			}
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/addProduct.html");
			rd.include(request, response);
		} catch (SQLException e) {
			System.out.println("FAIL Add product");
			e.printStackTrace();
		}
	}
	
	
	
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("!!!!contextDestroyed!!!!");
    	Connection con = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
    	try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
