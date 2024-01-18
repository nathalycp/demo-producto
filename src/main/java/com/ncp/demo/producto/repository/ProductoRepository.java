package com.ncp.demo.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncp.demo.producto.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
	
	
}
