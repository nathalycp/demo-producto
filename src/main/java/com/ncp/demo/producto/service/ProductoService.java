package com.ncp.demo.producto.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public List<ProductoDto> getAllProducts() {
		List<ProductoEntity> productList = productoRepository.findAll();
		List<ProductoDto> productDTOList = new ArrayList<>();
		for (ProductoEntity productoEntity : productList) {
			ProductoDto productoDto = new ProductoDto();
			productoDto.setId(productoEntity.getId());
			productoDto.setName(productoEntity.getName());
			productoDto.setPrice(productoEntity.getPrice());
			productoDto.setCreationDate(productoEntity.getCreationDate());
			productDTOList.add(productoDto);
		}
		return productDTOList;

	}

	public ProductoDto updateProduct(Integer id, ProductoDto updateProductoDto) {
		Optional<ProductoEntity> optionalProduct = productoRepository.findById(id);

		if (optionalProduct.isPresent()) {
			ProductoEntity existProduct = optionalProduct.get();
			existProduct.setName(updateProductoDto.getName());
			existProduct.setPrice(updateProductoDto.getPrice());

			ProductoEntity productoEntityUpdated = productoRepository.save(existProduct);

			// convierto la entidad actualizada a DTO

			ProductoDto productoDto = new ProductoDto();
			productoDto.setId(productoEntityUpdated.getId());
			productoDto.setName(productoEntityUpdated.getName());
			productoDto.setPrice(productoEntityUpdated.getPrice());
			productoDto.setCreationDate(productoEntityUpdated.getCreationDate());

			return productoDto;
		}

		return null;

	}
}
