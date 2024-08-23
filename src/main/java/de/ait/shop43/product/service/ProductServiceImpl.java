package de.ait.shop43.product.service;

import de.ait.shop43.product.dto.RequestProductDto;
import de.ait.shop43.product.dto.ResponseProductDto;
import de.ait.shop43.product.entity.Product;
import de.ait.shop43.product.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService{

    private final IProductRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<ResponseProductDto> findAll() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, ResponseProductDto.class))
                .toList();
    }

    @Override
    public ResponseProductDto save(RequestProductDto dto) {
        Product entity = mapper.map(dto, Product.class); // Request -> Product
        Product newProduct = repository.save(entity);
        return mapper.map(newProduct, ResponseProductDto.class); // Product -> Response
    }
}
