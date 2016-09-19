package com.journaldev.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.journaldev.dao.MenuDAO;
import com.journaldev.dao.ProductDAOImpl;
import com.journaldev.model.CodeBook;
import com.journaldev.model.MenuImpl;
import com.journaldev.model.Product;

public class DataInitialisation {
	
	
	private static DataInitialisation dataInitialisation = null;
	private static CodeBook codebook;
	private static MenuDAO menuDAO;
	private static ProductDAOImpl productDAOImpl;
	private static List<String> menuNameList = new ArrayList<String>();
	private static Map<String, String> mapRequetTo = new HashMap<>();
	private static Map<String, String> mapReqestParam = new HashMap<>();
	
	
	private DataInitialisation() {
		this.codebook = new CodeBook().init();
		
		menuNameList.add("MenuMobPhone");
		menuNameList.add("MenuPC");
		
		mapRequetTo.put("MenuMobPhone", "ServletFilterDAO");
		mapRequetTo.put("MenuPC", "addProduct.html");
		mapReqestParam.put("MenuMobPhone", "MenuMobPhone");
		mapReqestParam.put("MenuPC", "ServletFilterDAO");
		
		menuDAO = new MenuDAO();
		productDAOImpl = new ProductDAOImpl();
		
		
	}
	
	
	
	public static DataInitialisation INIT(){
		if(dataInitialisation == null){
			dataInitialisation = new DataInitialisation();
		}

		return dataInitialisation;
	}
	
	public static List<MenuImpl> MENUINIT(){
		return menuDAO.getMenuList(menuNameList, mapRequetTo, mapReqestParam, codebook);
	}
	
	public static List<Product> PRODUCTLISTINIT(){
		return productDAOImpl.getAllProducts();
	}

	
}
