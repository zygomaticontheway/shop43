package de.ait.shop43.product.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private BigDecimal price;
}
