package com.avinash.dt12.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table(name="pro")
public class Product 
{
@Id
private int productId;	
@Column(name="proname")
private String name;
@Column
private int price;
@Column
private String description;
@Column
private String categoryName;
@Column
private String supplierName;
@Column
private int stock;
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
@Transient
private MultipartFile productimg;
public MultipartFile getProductimg() {
	return productimg;
}
public void setProductimg(MultipartFile productimg) {
	this.productimg = productimg;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
