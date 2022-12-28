package com.infy.springbootrestapicrudapp.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.springbootrestapicrudapp.app.exception.ProductNotFoundException;
import com.infy.springbootrestapicrudapp.app.model.Product;
import com.infy.springbootrestapicrudapp.app.repository.ProductRepository;
import com.infy.springbootrestapicrudapp.app.servicei.ProductServiceI;
@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	ProductRepository pr;
	
	@Override
	public Product saveProduct(Product p) {
		
		Product saveproduct = pr.save(p);
		return saveproduct;
	}

	@Override
	public Iterable<Product> getAllProducts() {
		
	   List<Product> products = pr.findAll();
		return products;
	}
	@Override
	public Product getSingleProduct(int id) throws ProductNotFoundException {
		Product product = pr.findByProductId(id);
		
		if(product!=null) {
			return product;
					 }
		else {
			throw new ProductNotFoundException("Product Not Found With id"+id);
		}
	}

	@Override
	public Product editProduct(Integer productId, Product p) {
		
		Product singleProduct = pr.findByProductId(productId);
		
		if(singleProduct.getProductId()==productId) 
		{
			
		   Product updatedProduct = pr.save(p);
		   return updatedProduct;
		}
		return null;
	}

	@Override
	public void deleteProduct(Integer productId) {
		
		pr.deleteById(productId);
		
	}

}
