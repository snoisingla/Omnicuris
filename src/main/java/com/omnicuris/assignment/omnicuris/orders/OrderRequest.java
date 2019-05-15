package com.omnicuris.assignment.omnicuris.orders;

import java.util.List;

import com.omnicuris.assignment.omnicuris.items.ItemRequest;

public class OrderRequest {
	
	private String userEmail;
	private List<ItemRequest> itemList;
	
	
	public OrderRequest(String userEmail, List<ItemRequest> itemList) {
		super();
		this.userEmail = userEmail;
		this.itemList = itemList;
	}
	
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public List<ItemRequest> getItemList() {
		return itemList;
	}
	
	public void setItemList(List<ItemRequest> itemList) {
		this.itemList = itemList;
	}
	
	

}
