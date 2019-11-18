package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.model.ProductModel;

import java.util.List;

public interface ProductRepository {
    ProductModel create(ProductModel item);

    ProductModel update(ProductModel item);

    boolean removeById(int id);

    List<ProductModel> getItems();

    List<ProductModel> getItemsByCategory(ProductModel model);

    ProductModel getById(int id);

    int sizeProductRepository();
}
