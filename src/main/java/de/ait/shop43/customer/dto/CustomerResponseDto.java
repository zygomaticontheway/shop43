package de.ait.shop43.customer.dto;

import de.ait.shop43.cart.dto.CartResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDto {
    private Long id;
    private String name;
    private boolean isActive;
    private CartResponseDto cart;

}
