package com.omnicuris.assignment.omnicuris.orders;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.omnicuris.assignment.omnicuris.items.Item;
import com.omnicuris.assignment.omnicuris.items.ItemRequest;
import com.omnicuris.assignment.omnicuris.items.ItemServiceImpl;

@Transactional
@Service
@Repository
public class OrderServiceImpl {
	
	@Lazy
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ItemServiceImpl itemService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	public List<Order> getAllOrders(){
		return orderService.findAll();
	}
	
	public void createOrder(OrderRequest orderRequest) {
		validateOrderRequest(orderRequest);

		String userEmail = orderRequest.getUserEmail();
		Order newOrder = new Order();
		newOrder.setUserEmail(userEmail);
		orderService.save(newOrder); //Order created
		
		int noOfItems = orderRequest.getItemList().size();

		for(int i = 0; i < noOfItems; i++) {
			ItemRequest currentItemRequest = orderRequest.getItemList().get(i);
			long itemId = currentItemRequest.getId();
			Item item = itemService.getItem(itemId); //getting item from itemID
			
			int itemQtyInStock = item.getQuantity();
			int itemQtyRequested = currentItemRequest.getQuantity();
			
			OrderItem orderItem = new OrderItem(newOrder,item, itemQtyRequested);
			item.setQuantity(itemQtyInStock - itemQtyRequested); // update original item qty	
			orderItemService.save(orderItem);
		}
	}

	private void validateOrderRequest(OrderRequest orderRequest) {
		int noOfItems = orderRequest.getItemList().size();

		for(int i = 0; i < noOfItems; i++) {
			ItemRequest currentItemRequest = orderRequest.getItemList().get(i);
			long itemId = currentItemRequest.getId();
			Item item = itemService.getItem(itemId); //item
			int itemQtyInStock = item.getQuantity();
			int itemQtyRequested = currentItemRequest.getQuantity();
			
			if(itemQtyRequested <= 0) {
				throw new OutOfStockException("Item quantity should be greater than zero");
			}
			if(itemQtyRequested > itemQtyInStock ) {
				throw new OutOfStockException(item.getName()+ " is out of Stock");
			}
		}
	}
	

}
