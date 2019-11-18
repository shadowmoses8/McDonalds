package ru.rosbank.javaschool.service;

import lombok.var;
import ru.rosbank.javaschool.dto.AbstractProductDetailsDto;
import ru.rosbank.javaschool.dto.SaleDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.model.SaleModel;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;
import ru.rosbank.javaschool.repository.SalesRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class McDonaldServiceImpl implements McDonaldService {
    public final ProductRepositoryImpl productRepository;
    public final SalesRepositoryImpl salesRepository;
    private SaleModel basket = new SaleModel();
    private List<ProductModel> orderList = new ArrayList();


    public McDonaldServiceImpl(ProductRepositoryImpl productRepository, SalesRepositoryImpl salesRepository) {
        this.productRepository = productRepository;
        this.salesRepository = salesRepository;
    }

    public void saveProduct(AbstractProductDetailsDto dto) {
        if (dto.getId() < 0) {
            throw new InvalidDataException("id не может быть меньше 0");
        }
        if (dto.getName().isEmpty()) {
            throw new InvalidDataException("Введите пожалуйста имя");
        }
        if (dto.getPrice() < 0) {
            throw new InvalidDataException("цена не может быть меньше 0");
        }
        if (dto.getId() == 0) {
            productRepository.create(ProductModel.from(dto));
            return;
        }
        productRepository.update(ProductModel.from(dto));
    }

    public List<AbstractProductDetailsDto> getAllProducts() {
        return productRepository.getItems().stream()
                .map(AbstractProductDetailsDto::from)
                .collect(Collectors.toList());
    }


    public List<AbstractProductDetailsDto> searchByName(String name) {
        return productRepository.getItems().stream()
                .filter(o -> o.getName().toLowerCase().equals(name.toString()))
                .map(AbstractProductDetailsDto::from)
                .collect(Collectors.toList())
                ;
    }

    public ProductModel getById(int id) {
        return productRepository.getById(id);
    }

    public void removeById(int id) {
        boolean removed = productRepository.removeById(id);
        if (!removed) {
            throw new DataNotFoundException();
        }

    }

    public void addToBasket(ProductModel dto) {
        orderList.add(dto);
    }

    public void removeItemInBasket(SaleDto dto) {
        for (var e : orderList) {
            if (e.getId() == dto.getId()) {
                orderList.remove(e);
                break;
            }
        }
    }

    public void createSale() {
        if (orderList.isEmpty()) {
            throw new InvalidDataException("Вы не выбрали продукты для заказа");
        } else {
            orderList.forEach(e -> {
                basket.getProducts().add(e);
                basket.setPrice(e.getPrice());
            });
            salesRepository.create(basket);
            orderList.clear();
        }
    }

    public List<ProductModel> getCategory(ProductModel model) {
        return productRepository.getItemsByCategory(model);
    }
}

