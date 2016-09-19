package com.journaldev.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.journaldev.model.filters.ProducerFilter;

public class FilterDAO {
	String menuName;
	private static Map<String, Set> filterMenuConfig;
	private static Set <String> mobileFilterList;
	private static Set <String> tempProdesersSet;
	private static Set <String> tempOZUSet;
	private static Set <String> tempButterySet;
	private static  Map<String, Set<String>> mobileFiltersTempData;
	private static Map<String, Map<String, Set<String>>> menuFiltersTempData;
	
	
	static{
		tempProdesersSet = new HashSet<>();
		tempProdesersSet.add("Sumsuhg");
		tempProdesersSet.add("HTC");
		tempProdesersSet.add("Applle");
		
		tempOZUSet = new HashSet<>();
		tempOZUSet.add("1");
		tempOZUSet.add("2");
		tempOZUSet.add("3");
		
		tempButterySet = new HashSet<>();		
		tempButterySet.add("1000");
		tempButterySet.add("2000");
		tempButterySet.add("4000");
		
		mobileFiltersTempData = new HashMap<String, Set<String>>();
		mobileFiltersTempData.put("ProducerFilter", tempProdesersSet);
		mobileFiltersTempData.put("OZUFilter", tempOZUSet);
		mobileFiltersTempData.put("ButteryFilter", tempButterySet);
		
		menuFiltersTempData = new HashMap<String, Map<String, Set<String>>>();
		menuFiltersTempData.put("MenuMobPhone", mobileFiltersTempData);
		
		mobileFilterList = new HashSet<>();
		
		/*mobileFilterList.add("ProducerFilter");
		mobileFilterList.add("OZUFilter");
		mobileFilterList.add("ButteryFilter");
		
		filterMenuConfig = new HashMap<String, Set>();
		filterMenuConfig.put("MenuMobPhone", mobileFilterList);*/
	}

	public FilterDAO(String menuName) {
		this.menuName = menuName;
		
	}
	
	public List <ProducerFilter> getProdecerFilter (){
		ArrayList<ProducerFilter> producerFilterList = new ArrayList<ProducerFilter>();
		ProducerFilter producerFilter = null;
		if(menuName.equalsIgnoreCase("MenuMobPhone")){
			Iterator<String> tempProdesersSetIter = mobileFiltersTempData.get("ProducerFilter").iterator();
			while (tempProdesersSetIter.hasNext()) {
				String value =  tempProdesersSetIter.next();
				if(value != null && value!=""){
					producerFilter = new ProducerFilter();
					producerFilter.setFilterName(value);
					producerFilter.setFilterNameDescription(value);
					producerFilter.setActionParamValue(value);
					producerFilterList.add(producerFilter);
				}
			}
			
		}
		
		return producerFilterList;
	}
	
	
	
	
	
	
	
	
	
	

}
