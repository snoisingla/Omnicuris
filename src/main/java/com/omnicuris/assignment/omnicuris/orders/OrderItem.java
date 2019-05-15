package com.omnicuris.assignment.omnicuris.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omnicuris.assignment.omnicuris.items.Item;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private long id;
	
	@ManyToOne
	@JsonIgnore
	private Order order;
	
	@ManyToOne
	private Item item;
	
	private int quantity;
	
	protected OrderItem() {
		
	}

	public OrderItem(Order order, Item item, int quantity) {
		super();
		this.order = order;
		this.item = item;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	

}
