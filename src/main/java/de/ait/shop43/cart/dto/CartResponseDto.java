package de.ait.shop43.cart.dto;

import de.ait.shop43.product.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartResponseDto {
    private Long id;
//    private CustomerResponseDto customer;
    private List<ProductResponseDto> products;
}
