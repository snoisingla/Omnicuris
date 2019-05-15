package com.omnicuris.assignment.omnicuris.items;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omnicuris.assignment.omnicuris.orders.OrderItem;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private double price;
	
	private int quantity;
	
	@OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderItem> orderItems;	
	
	public Item() {
		
	}

	public Item(long id, String name, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Item(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
