package com.journaldev.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.journaldev.model.filters.SearchFilterInterface;

public class FilterMenu {
	
	private String menuName;
	private List <SearchFilterInterface> selectedFilters;
	
	public FilterMenu(){
		selectedFilters = new ArrayList<>();
	}
	
	public FilterMenu(String menuName){
		this.menuName = menuName;
		selectedFilters = new ArrayList<>();
		
	}
	
	
	
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void addSelectedFilter (SearchFilterInterface selectedFilter){
		selectedFilters.add(selectedFilter);
	}
	
	public List<SearchFilterInterface> getSelectedFilter (){
		return  selectedFilters;
	}
	
	public List<SearchFilterInterface> deleteFilterFromFiltersList (List<SearchFilterInterface> filtersList, String filterValue){
		List<SearchFilterInterface> filters = filtersList;
		Iterator<SearchFilterInterface> filtersIter = filters.iterator();
		while(filtersIter.hasNext()){
			SearchFilterInterface filter = filtersIter.next();
			if(filter.getActionParamValue().equalsIgnoreCase(filterValue)){
				filters.remove(filter);
				break;
			}
			
		}
	return filters;
	}
	
	
	
	
	public void removeSelectedFilter (SearchFilterInterface filter){
		selectedFilters.remove(filter);
		
	}
	
	
	
	
	
}
