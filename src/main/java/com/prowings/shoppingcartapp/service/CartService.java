package com.prowings.shoppingcartapp.service;

import com.prowings.shoppingcartapp.model.dto.BillDTO;
import com.prowings.shoppingcartapp.model.dto.CartDTO;
import com.prowings.shoppingcartapp.model.dto.Item;

public interface CartService {
	
	public boolean addItemToCart(Item item);

//	public boolean updateCartItem(String productId, Item item);
//
//	public boolean removeItemFromCart(String productId);
//
//	public CartDTO getCart();
//
	public BillDTO calculateBill();
	
}
