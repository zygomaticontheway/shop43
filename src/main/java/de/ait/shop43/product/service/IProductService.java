package de.ait.shop43.product.service;


import de.ait.shop43.product.dto.RequestProductDto;
import de.ait.shop43.product.dto.ResponseProductDto;

import java.util.List;

public interface IProductService {
    List<ResponseProductDto> findAll();
    ResponseProductDto save (RequestProductDto dto);
}
