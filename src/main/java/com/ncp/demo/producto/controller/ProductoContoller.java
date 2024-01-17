package com.ncp.demo.producto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncp.demo.producto.dto.ProductoDto;
import com.ncp.demo.producto.entity.ProductoEntity;
import com.ncp.demo.producto.service.ProductoService;

@RestController
@RequestMapping("producto")
public class ProductoContoller {

	public ProductoService productoService;

	public ProductoContoller(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}

	// duda responseEntity
	@PostMapping
	public ResponseEntity<ProductoDto> createProduct(@RequestBody ProductoDto productoDto) {
		ProductoDto createdProduct = productoService.createProduct(productoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
	
	//subir a git con create 
	

}
