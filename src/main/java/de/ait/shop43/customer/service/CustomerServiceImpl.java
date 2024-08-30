package de.ait.shop43.customer.service;

import de.ait.shop43.cart.entity.Cart;
import de.ait.shop43.customer.dto.CustomerRequestDto;
import de.ait.shop43.customer.dto.CustomerResponseDto;
import de.ait.shop43.customer.entity.Customer;
import de.ait.shop43.customer.repository.ICustomerRepository;
import de.ait.shop43.exception.CustomerNotFoundException;
import de.ait.shop43.product.entity.Product;
import de.ait.shop43.product.service.IProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService{
    private final ICustomerRepository repository;
    private final ModelMapper mapper;
    private final IProductService productService;


    @Override
    @Transactional
    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {

        Customer entity = mapper.map(dto, Customer.class);
        Cart cart = new Cart();

        entity.setActive(true);

        //java relation setup - проделали связь
        entity.setCart(cart);
        cart.setCustomer(entity);

        entity = repository.save(entity);

        return mapper.map(entity, CustomerResponseDto.class);
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {

        List<Customer> customers = repository.findAll();

        return customers.stream()
                .map(c -> mapper.map(c, CustomerResponseDto.class))
                .toList();
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {

        return mapper.map(findCustomerById(id), CustomerResponseDto.class);
    }

    private Customer findCustomerById(Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " not found!"));
        return customer;
    }
    private Product findProductById(Long id) {
        Product product = productService.findProductById(id);
        return product;
    }

    @Override
    @Transactional
    public CustomerResponseDto addProductToCart(Long customerId, Long productId) {

        Customer customer = findCustomerById(customerId);
        Product product = findProductById(productId);

        customer.getCart().addProduct(product);

        return mapper.map(customer, CustomerResponseDto.class);
    }

    @Override
    @Transactional
    public CustomerResponseDto removeProductFromCart(Long customerId, Long productId) {

        Customer customer = findCustomerById(customerId);
        Product product = findProductById(productId);
        customer.getCart().removeProduct(product);

        return mapper.map(customer, CustomerResponseDto.class);
    }

    @Override
    public CustomerResponseDto setStatus(Long customerId, boolean isActive) {

        Customer customer = findCustomerById(customerId);
        customer.setActive(isActive);

        return mapper.map(customer, CustomerResponseDto.class);
    }
}
