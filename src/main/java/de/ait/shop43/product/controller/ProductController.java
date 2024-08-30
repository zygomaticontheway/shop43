package de.ait.shop43.product.controller;

import de.ait.shop43.product.dto.ProductRequestDto;
import de.ait.shop43.product.dto.ProductResponseDto;
import de.ait.shop43.product.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final IProductService service;

    //localhost:8080/products
    //localhost:8080/products?title=milk
    @GetMapping("/products")
    public List<ProductResponseDto> getProducts(@RequestParam(name = "title", required = false, defaultValue = "") String title){
        if(title.isEmpty()) {
            return service.findAll();
        } else {
            return service.findByTitle(title);
        }
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProductById (@PathVariable(name = "id") Long id){
        return service.findById(id);
    }


    @PostMapping("/products")
    public ProductResponseDto createProduct (@RequestBody ProductRequestDto dto){
        return service.save(dto);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct (@RequestBody ProductRequestDto dto, @PathVariable (name = "id") Long id){
        return service.update(id, dto);
    }

    // PATCH products/3?active=true
    @PatchMapping("/products/{id}")
    public ProductResponseDto setActive (@PathVariable (name = "id") Long id,
                                         @RequestParam (name = "active", required = true) boolean active) {
        return service.updateActiveStatus(id, active);
    }
}
