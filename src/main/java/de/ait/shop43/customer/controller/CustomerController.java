package de.ait.shop43.customer.controller;

import de.ait.shop43.customer.dto.CustomerRequestDto;
import de.ait.shop43.customer.dto.CustomerResponseDto;
import de.ait.shop43.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @PostMapping
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto dto) {
        return service.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable (name = "id") Long id) {
        return service.getCustomerById(id);
    }

    @PutMapping("/{customerId}/products/{productId}")
    public CustomerResponseDto addProductToCart(@PathVariable(name = "customerId") Long customerId,
                                                @PathVariable(name = "productId") Long productId) {
        return service.addProductToCart(customerId, productId);
    }

    @DeleteMapping("/{customerId}/products/{productId}")
    public CustomerResponseDto removeProductFromCart(@PathVariable(name = "customerId") Long customerId,
                                                     @PathVariable(name = "productId") Long productId) {
        return service.removeProductFromCart(customerId, productId);
    }

    @PatchMapping("/{customerId}")
    public CustomerResponseDto changeStatus(@PathVariable(name = "customerId") Long customerId,
                                            @RequestParam(name = "isActive", defaultValue = "true") boolean isActive) {
        return service.changeStatus(customerId, isActive);
    }
}
