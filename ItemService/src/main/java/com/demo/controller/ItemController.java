package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Item;
import com.demo.repository.ItemRepository;

/**
 * @author Abesh
 *
 */
@RestController
@RequestMapping("/item")
public class ItemController {

	private static final Logger LOG = Logger.getLogger(ItemController.class);

	@Autowired
	private ItemRepository itemRepository;

	@PostMapping("/add")
	public Item addItem(@RequestBody Item item) {
		LOG.info("Adding item to records");
		return itemRepository.save(item);
	}

	@GetMapping("/all")
	public List<Item> getAllItems() {
		LOG.info("Getting all items");
		return itemRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Item> getItemById(@PathVariable long id) {
		LOG.info("Get item by id");
		return itemRepository.findById(id);
	}

}
