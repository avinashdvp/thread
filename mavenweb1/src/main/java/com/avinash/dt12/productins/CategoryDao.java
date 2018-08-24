package com.avinash.dt12.productins;

import java.util.List;

import com.avinash.dt12.model.Category;

public interface CategoryDao 
{
boolean insert(Category cat);
public List getAllCategory();
public boolean deleteCategory(int categoryId);
}
