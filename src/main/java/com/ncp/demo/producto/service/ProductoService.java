package com.ncp.demo.producto.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.ncp.demo.producto.dto.ProductoDto;
import com.ncp.demo.producto.entity.ProductoEntity;
import com.ncp.demo.producto.repository.ProductoRepository;

@Service
public class ProductoService {

	public ProductoRepository productoRepository;

	public ProductoService(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	public ProductoDto createProduct(ProductoDto productoDto) {

		ProductoEntity productoEntity = new ProductoEntity();
		productoEntity.setName(productoDto.getName());
		productoEntity.setPrice(productoDto.getPrice());
		productoEntity.setCreationDate(LocalDateTime.now());

		ProductoEntity saveEntity = productoRepository.save(productoEntity);
		productoDto.setId(saveEntity.getId());
		productoDto.setCreationDate(saveEntity.getCreationDate());

		return productoDto;
	}

}
