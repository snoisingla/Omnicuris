package com.omnicuris.assignment.omnicuris.items;

public class ItemRequest {
	private long id;
	
	private int quantity;

	public ItemRequest(long id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
