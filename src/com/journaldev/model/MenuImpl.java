package com.journaldev.model;

public class MenuImpl {

	String menuName;
	String menuDescription;
	String memuRequestTo;
	String menuRequestParam;
	String menuRequestParamName = "menuName";
	
	
	public MenuImpl(String menuName, String menuDescription, String memuRequestTo,
			String menuRequestParam) {
		super();
		this.menuName = menuName;
		this.menuDescription = menuDescription;
		this.memuRequestTo = memuRequestTo;
		this.menuRequestParam = menuRequestParam;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public String getMenuDescription() {
		return menuDescription;
	}


	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}


	public String getMemuRequestTo() {
		return memuRequestTo;
	}


	public void setMemuRequestTo(String memuRequestTo) {
		this.memuRequestTo = memuRequestTo;
	}


	public String getMenuRequestParam() {
		return menuRequestParam;
	}


	public void setMenuRequestParam(String menuRequestParam) {
		this.menuRequestParam = menuRequestParam;
	}
	
		
	public String getMenuRequestParamName() {
		return menuRequestParamName;
	}


	public void setMenuRequestParamName(String menuRequestParamName) {
		this.menuRequestParamName = menuRequestParamName;
	}


	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", menuDescription="
				+ menuDescription + ", memuRequestTo=" + memuRequestTo
				+ ", menuRequestParam=" + menuRequestParam + "]";
	}
	
	
	
	
	
}
