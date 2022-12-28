package com.infy.springbootrestapicrudapp.app.servicei;

import com.infy.springbootrestapicrudapp.app.exception.ProductNotFoundException;
import com.infy.springbootrestapicrudapp.app.model.Product;

public interface ProductServiceI {

	public Product saveProduct(Product p);

	public Iterable<Product> getAllProducts();

	public Product getSingleProduct(int id) throws ProductNotFoundException;

	public Product editProduct(Integer productId,Product p);

	public void deleteProduct(Integer productId);

}
