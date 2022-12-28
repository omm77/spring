package com.infy.springbootrestapicrudapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.springbootrestapicrudapp.app.exception.ProductNotFoundException;
import com.infy.springbootrestapicrudapp.app.model.Product;
import com.infy.springbootrestapicrudapp.app.servicei.ProductServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductServiceI ps;

	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product p)
	{
		Product pr=ps.saveProduct(p);
		return pr;
	}
	@GetMapping("/getall")
	public Iterable<Product> getAllProducts()
	{
		Iterable<Product> products=	ps.getAllProducts();
		return products;
	}
	@GetMapping("get/{productId}") 
	public Product getSingleProduct(@PathVariable Integer productId) throws ProductNotFoundException
	{
		Product singleProduct = ps.getSingleProduct(productId);
		
		return singleProduct;
	}
	@PutMapping("/put/{productId}")
	public Product editProduct(@PathVariable Integer productId,@RequestBody Product p)
	{
		Product updatedProduct= ps.editProduct(productId,p);
		
		return updatedProduct;
	}
	@DeleteMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable Integer productId)
	{
		ps.deleteProduct(productId);
	}
}
