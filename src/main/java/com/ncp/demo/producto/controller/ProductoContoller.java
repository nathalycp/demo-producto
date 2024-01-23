package com.ncp.demo.producto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncp.demo.producto.dto.ProductoDto;
import com.ncp.demo.producto.service.ProductoService;

@RestController
@RequestMapping("producto")
public class ProductoContoller {

	public ProductoService productoService;

	public ProductoContoller(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}

//	@PostMapping
//	public ResponseEntity<ProductoDto> createProduct(@RequestBody ProductoDto productoDto) {
//		ProductoDto createdProduct = productoService.createProduct(productoDto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
//	}

	@PostMapping
	public ResponseEntity<ProductoDto> createProduct(@RequestBody ProductoDto productoDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.createProduct(productoDto));
	}

	@GetMapping
	public ResponseEntity<List<ProductoDto>> getAllProducts() {
		return ResponseEntity.ok(productoService.getAllProducts());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductoDto> updateProduct(@PathVariable Integer id, @RequestBody ProductoDto updateProduct) {
		ProductoDto updatedProduct = productoService.updateProduct(id, updateProduct);
		return ResponseEntity.ok(updatedProduct);
	}

}
