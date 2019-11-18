package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.AbstractProductDetailsDto;
import ru.rosbank.javaschool.dto.SaleDto;
import ru.rosbank.javaschool.model.ProductModel;

import java.util.List;

public interface McDonaldService {
    void saveProduct(AbstractProductDetailsDto dto);

    List<AbstractProductDetailsDto> getAllProducts();

    List<AbstractProductDetailsDto> searchByName(String name);

    ProductModel getById(int id);

    void removeById(int id);

    void addToBasket(ProductModel dto);

    void removeItemInBasket(SaleDto dto);

    void createSale();

    List<ProductModel> getCategory(ProductModel model);
}
