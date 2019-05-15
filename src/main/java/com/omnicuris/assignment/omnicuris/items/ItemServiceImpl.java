package com.omnicuris.assignment.omnicuris.items;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Repository
public class ItemServiceImpl {
	
	@Lazy
	@Autowired
	private ItemService itemService;
	
	public void addItem(Item item) {
		itemService.save(item);
	}
	
	public Item getItem(long id) {
		return itemService
				.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Item with "+id+" not found"));
	}
	
	public void updateItem(long id, Item newItem) {
		if(newItem.getQuantity() <= 0) {
			throw new IllegalArgumentException("Quantity can't be less than zero");
		}
		if(newItem.getPrice() < 0) {
			throw new IllegalArgumentException("Price can't be less than zero");
		}
		
		Item item = getItem(id);
		
		item.setPrice(newItem.getPrice());
		item.setName(newItem.getName());
		item.setQuantity(newItem.getQuantity());
	}
	
	public void deleteItem(long id) {
		itemService.deleteById(id);
	}
	
	public List<Item> getAllItems(){
		return itemService.findAll();
	}
}
