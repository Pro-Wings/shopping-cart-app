package com.prowings.shoppingcartapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.shoppingcartapp.model.dto.BillDTO;
import com.prowings.shoppingcartapp.model.dto.CartDTO;
import com.prowings.shoppingcartapp.model.dto.Item;
import com.prowings.shoppingcartapp.model.dto.ProductDTO;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private ProductService productService;

	List<ProductDTO> items = new ArrayList();
	private CartDTO cartDTO = new CartDTO();

	public boolean addItemToCart(Item item) {
		// Get product details from ProductService
		ProductDTO product = productService.getProductById(item.getProductId());
		// add fetched product to cart
		if (product != null) {
			cartDTO.setItems(items);
			cartDTO.getItems().add(product);
			return true;
		}
		return false;
	}

	@Override
	public BillDTO calculateBill() {
		double totalPrice = 0;
		for(ProductDTO p : cartDTO.getItems())
		{
			totalPrice += p.getPrice();
		}
		
		double taxablePrice = calculateTax();
		double finalPrice = totalPrice + taxablePrice;
		return new BillDTO(totalPrice, taxablePrice, finalPrice);
	}

	private double calculateTax() {
		return 110;
	}

}
