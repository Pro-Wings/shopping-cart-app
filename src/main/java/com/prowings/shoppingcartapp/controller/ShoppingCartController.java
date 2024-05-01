package com.prowings.shoppingcartapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.shoppingcartapp.model.dto.BillDTO;
import com.prowings.shoppingcartapp.model.dto.Item;
import com.prowings.shoppingcartapp.service.CartService;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/items")
	public ResponseEntity<String> addItemToCart(@RequestBody Item item) {
		if(cartService.addItemToCart(item))
		return ResponseEntity.status(HttpStatus.CREATED).body("Product added to cart successfully.");
		else
			return new ResponseEntity<String>("Item not added to cart!!", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/bill")
	public ResponseEntity<BillDTO> calculateBill() {
		BillDTO billDTO = cartService.calculateBill();
				
		return new ResponseEntity<BillDTO>(billDTO, HttpStatus.OK);
	}

}
