package de.ait.shop43.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseProductDto {
    private Long id;
    private String title;
    private BigDecimal price;
    private boolean isActive;
}
