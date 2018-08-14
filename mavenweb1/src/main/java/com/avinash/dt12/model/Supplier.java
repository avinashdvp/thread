package com.avinash.dt12.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Supplier 
{
@Id
private String supplierId;
@Column
private String suppliername;
@Column
private String supplierDescription;
public String getSupplierId() {
	return supplierId;
}
public void setSupplierId(String supplierId) {
	this.supplierId = supplierId;
}
public String getSuppliername() {
	return suppliername;
}
public void setSuppliername(String suppliername) {
	this.suppliername = suppliername;
}
public String getSupplierDescription() {
	return supplierDescription;
}
public void setSupplierDescription(String supplierDescription) {
	this.supplierDescription = supplierDescription;
}



}
