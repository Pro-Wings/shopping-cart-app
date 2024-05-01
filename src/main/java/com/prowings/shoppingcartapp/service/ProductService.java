package com.prowings.shoppingcartapp.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.shoppingcartapp.model.dto.Product;
import com.prowings.shoppingcartapp.model.dto.ProductDTO;

@Service
public class ProductService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DozerBeanMapper beanMapper;
	
	
	public ProductDTO getProductById(String productId) {
		//call to product mgmt api 
		ResponseEntity<Product>  fetchedProduct = restTemplate.getForEntity("/products/"+productId, Product.class);
		Product product = fetchedProduct.getBody();
		
		ProductDTO productDTO = beanMapper.map(product, ProductDTO.class);
		
		return productDTO;
	}

}
