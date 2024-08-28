package de.ait.shop43.product.service;

import de.ait.shop43.exception.ProductNotFoundException;
import de.ait.shop43.product.dto.ProductRequestDto;
import de.ait.shop43.product.dto.ProductResponseDto;
import de.ait.shop43.product.entity.Product;
import de.ait.shop43.product.repository.IProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService{

    private final IProductRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<ProductResponseDto> findAll() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, ProductResponseDto.class))
                .toList();
    }

    @Override
    public ProductResponseDto save(ProductRequestDto dto) {
        Product entity = mapper.map(dto, Product.class); // Request -> Product
        Product newProduct = repository.save(entity);
        return mapper.map(newProduct, ProductResponseDto.class); // Product -> Response
    }

    @Override
    @Transactional
    public ProductResponseDto update(Long id, ProductRequestDto dto) {

        Product entity = mapper.map(dto, Product.class);
        entity.setId(id);
        entity = repository.save(entity);
        return mapper.map(entity, ProductResponseDto.class);
    }

    @Override
    @Transactional
    public ProductResponseDto updateActiveStatus(Long id, boolean active) {
        Product entity = findProductById(id);
        entity.setActive(active);

        // отсутствует метод save -> update в базу. Это spring (hibernate) делает автоматически.
        // при получении сущности (findById) именно из репозитория, hibernate помещает эту сущность в свой контекст и отслеживает изменения этой сущности
        // и синхронизирует эти изменения с БД.
        // ! Если получить сущность не из репозитория, то изменения отслеживаться не будут
        // ошибкой не будет если прописать save руками

        return mapper.map(entity, ProductResponseDto.class);
    }


    @Override
    public List<ProductResponseDto> findByTitle(String title) {
        List<Product> productsByTitle = repository.findByTitleIsContainingIgnoreCase(title);
        return productsByTitle.stream()
                .map(p -> mapper.map(p, ProductResponseDto.class))
                .toList();
    }

    @Override
    public ProductResponseDto findById(Long id) {
        return mapper.map(findProductById(id), ProductResponseDto.class);
    }

    public Product findProductById(Long id) {
        Product entity = repository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found!"));
        return entity;
    }
}
