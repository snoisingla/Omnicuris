package com.omnicuris.assignment.omnicuris.items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	private ItemServiceImpl itemServiceImpl;
	
	@PostMapping("items")
	public void addItem(@RequestBody Item item) {
		itemServiceImpl.addItem(item);
	}
	
	@GetMapping("items/{id}")
	public Item getItem(@PathVariable long id) {
		return itemServiceImpl.getItem(id);
	}
	
	@PutMapping("items/{id}")
	public void updateItem(@PathVariable long id, @RequestBody Item item) {
		itemServiceImpl.updateItem(id, item);
	}
	
	@GetMapping("items")
	public List<Item> getAllItems(){
		return itemServiceImpl.getAllItems();
	}
	
	@DeleteMapping("items/{id}")
	public void deleteItem(@PathVariable long id) {
		itemServiceImpl.deleteItem(id);
	}
}
