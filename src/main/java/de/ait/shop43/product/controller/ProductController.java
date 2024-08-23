package de.ait.shop43.product.controller;

import de.ait.shop43.product.dto.RequestProductDto;
import de.ait.shop43.product.dto.ResponseProductDto;
import de.ait.shop43.product.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final IProductService service;

    @GetMapping("/products")
    public List<ResponseProductDto> getProducts(){
        return service.findAll();
    }

    @PostMapping("/products")
    public ResponseProductDto createProduct (@RequestBody RequestProductDto dto){
        return service.save(dto);
    }
}
