package com.journaldev.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;

import com.journaldev.model.CodeBook;
import com.journaldev.model.MenuImpl;

public class MenuDAO {
	
	private CodeBook codebook;
	private Map<String, String> mapRequetTo = new HashMap<>();
	private Map<String, String> mapReqestParam = new HashMap<>();
	
	public MenuDAO() {
		super();
		this.codebook = new CodeBook().init();
	}




	public List<MenuImpl>  getMenuList (List<String> menuNameList, Map<String, String> mapRequetTo, Map<String, String> mapReqestParam, CodeBook codebook){
		Iterator<String> menuNameListIter = menuNameList.iterator();
		List<MenuImpl> menuProductsList = new ArrayList<MenuImpl>();
		while (menuNameListIter.hasNext()) {
			String currentMenuName = menuNameListIter.next();
			if(codebook.getValue(currentMenuName)!=null && mapRequetTo.get(currentMenuName)!=null && mapReqestParam.get(currentMenuName)!=null){
				menuProductsList.add(new MenuImpl(currentMenuName, codebook.getValue(currentMenuName), mapRequetTo.get(currentMenuName), mapReqestParam.get(currentMenuName)));
			}
		}
		
		/*menuProductsList.add(new MenuImpl("MenuMobPhone", codebook.getValue("MenuMobPhone"), mapRequetTo.get("MenuMobPhone"), mapReqestParam.get("MenuMobPhone")));
		menuProductsList.add(new MenuImpl("MenuPC", codebook.getValue("MenuPC"), mapRequetTo.get("MenuPC"), mapReqestParam.get("MenuPC")));*/
		
		return  menuProductsList;
	}
}
