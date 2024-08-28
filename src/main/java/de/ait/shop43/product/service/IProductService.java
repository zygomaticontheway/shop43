package de.ait.shop43.product.service;


import de.ait.shop43.product.dto.ProductRequestDto;
import de.ait.shop43.product.dto.ProductResponseDto;
import de.ait.shop43.product.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductResponseDto> findAll();
    ProductResponseDto save (ProductRequestDto dto);
    ProductResponseDto update(Long id, ProductRequestDto dto);
    ProductResponseDto updateActiveStatus(Long id, boolean active);
    List<ProductResponseDto> findByTitle(String title);
    ProductResponseDto findById(Long id);
    Product findProductById(Long id);
}
