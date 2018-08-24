package com.avinash.dt12.productins;

import java.util.List;

import com.avinash.dt12.model.Product;

public interface ProductDao
{
	boolean insert(Product pro);
	 public List getAllProducts();
	 public boolean deleteProduct(int productId);
	 public Product editProduct(int productId);
	Product cart(int proId); 
}
