package de.ait.shop43.customer.service;

import de.ait.shop43.customer.dto.CustomerRequestDto;
import de.ait.shop43.customer.dto.CustomerResponseDto;
import de.ait.shop43.product.dto.ProductRequestDto;

import java.util.List;

public interface ICustomerService {

    public CustomerResponseDto createCustomer(CustomerRequestDto dto);
    public List<CustomerResponseDto> getAllCustomers();
    public CustomerResponseDto getCustomerById(Long id);
    public CustomerResponseDto addProductToCart(Long customerId, Long productId);
    public CustomerResponseDto removeProductFromCart(Long customerId, Long productId);
    public CustomerResponseDto changeStatus (Long customerId, boolean isActive);


}
