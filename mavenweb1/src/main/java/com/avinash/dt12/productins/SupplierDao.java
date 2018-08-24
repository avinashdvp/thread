package com.avinash.dt12.productins;

import java.util.List;

import com.avinash.dt12.model.Supplier;

public interface SupplierDao
{
	boolean insert(Supplier supply);
	public List getallSuppliers();
	public boolean deleteSupplier(int supplierId);
}
