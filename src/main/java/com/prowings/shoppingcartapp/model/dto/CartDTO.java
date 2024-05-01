package com.prowings.shoppingcartapp.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartDTO {
	
	private List<ProductDTO> items;
	private double totalAmount;
	private double taxAmount;
	private double finalAmount;

}
