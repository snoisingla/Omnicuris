package com.omnicuris.assignment.omnicuris.orders;

import java.util.List;

import com.omnicuris.assignment.omnicuris.items.ItemRequest;

public class OrderRequest {
	
	private String userEmail;
	private List<ItemRequest> items;
	
	
	public OrderRequest(String userEmail, List<ItemRequest> items) {
		super();
		this.userEmail = userEmail;
		this.items = items;
	}
	
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public List<ItemRequest> getItems() {
		return items;
	}
	
	public void setItemList(List<ItemRequest> items) {
		this.items = items;
	}
	
	

}
