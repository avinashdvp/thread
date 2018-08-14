package com.avinash.dt12.productins;

import java.util.List;

import com.avinash.dt12.model.Product;

public interface ProductDao
{
	boolean insert(Product pro);
	 public List getAllProducts();
}
