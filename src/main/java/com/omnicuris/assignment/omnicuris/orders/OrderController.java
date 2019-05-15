package com.omnicuris.assignment.omnicuris.orders;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private OrderServiceImpl orderService;
	
	@PostMapping(path = "orders")
	public void addOrder(@RequestBody OrderRequest order,HttpServletResponse response) {
		orderService.createOrder(order);
	    response.setStatus(HttpServletResponse.SC_CREATED);
	}
	
	@GetMapping(path = "orders")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	

}
