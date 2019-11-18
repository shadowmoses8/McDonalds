package ru.rosbank.javaschool.service;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.dto.AbstractProductDetailsDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.model.BurgerModel;
import ru.rosbank.javaschool.model.DrinkModel;
import ru.rosbank.javaschool.model.PotatoModel;
import ru.rosbank.javaschool.repository.ProductRepository;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;
import ru.rosbank.javaschool.repository.SalesRepository;
import ru.rosbank.javaschool.repository.SalesRepositoryImpl;

import java.util.Optional;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class McDonaldServiceImplTest {

    @Test
    void SaveProductBurgerPositive() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        SalesRepositoryImpl salesRepository = new SalesRepositoryImpl();
        McDonaldServiceImpl orderService = new McDonaldServiceImpl(productRepository, salesRepository);
        BurgerModel burger = new BurgerModel();
        burger.setName("burger");
        burger.setPrice(2000);
        burger.setBunCount(3);
        orderService.saveProduct(AbstractProductDetailsDto.from(burger));
        assertEquals(burger, productRepository.getById(1));
    }

    @Test
    void SaveProductDrinkPositive() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        SalesRepositoryImpl salesRepository = new SalesRepositoryImpl();
        McDonaldServiceImpl orderService = new McDonaldServiceImpl(productRepository, salesRepository);
        DrinkModel drink = new DrinkModel();
        drink.setName("водка");
        drink.setPrice(2000);
        drink.setTypeDrink(2);
        orderService.saveProduct(AbstractProductDetailsDto.from(drink));
        assertEquals(drink, productRepository.getById(1));
    }

    @Test
    void SaveProductPotatoPositive() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        SalesRepositoryImpl salesRepository = new SalesRepositoryImpl();
        McDonaldServiceImpl orderService = new McDonaldServiceImpl(productRepository, salesRepository);
        PotatoModel potato = new PotatoModel();
        potato.setName("водка");
        potato.setPrice(2000);
        potato.setVolumeCount(300);
        orderService.saveProduct(AbstractProductDetailsDto.from(potato));
        assertEquals(potato, productRepository.getById(1));
    }

    @Test
    void UpdateProductDrinkPositive() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        SalesRepositoryImpl salesRepository = new SalesRepositoryImpl();
        McDonaldServiceImpl orderService = new McDonaldServiceImpl(productRepository, salesRepository);
        DrinkModel drink = new DrinkModel();
        drink.setName("водка");
        drink.setPrice(2000);
        drink.setTypeDrink(2);
        orderService.saveProduct(AbstractProductDetailsDto.from(drink));
        drink.setId(1);
        drink.setTypeDrink(3);
        orderService.saveProduct(AbstractProductDetailsDto.from(drink));
        assertEquals(drink, productRepository.getById(1));
    }

    @Test
    void UpdateProductBurgerPositive() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        SalesRepositoryImpl salesRepository = new SalesRepositoryImpl();
        McDonaldServiceImpl orderService = new McDonaldServiceImpl(productRepository, salesRepository);
        BurgerModel burger = new BurgerModel();
        burger.setName("burger");
        burger.setPrice(2000);
        burger.setBunCount(3);
        orderService.saveProduct(AbstractProductDetailsDto.from(burger));
        burger.setId(1);
        burger.setBunCount(4);
        orderService.saveProduct(AbstractProductDetailsDto.from(burger));
        assertEquals(burger, productRepository.getById(1));
    }

    @Test
    void UpdateProductPotatoPositive() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        SalesRepositoryImpl salesRepository = new SalesRepositoryImpl();
        McDonaldServiceImpl orderService = new McDonaldServiceImpl(productRepository, salesRepository);
        PotatoModel potato = new PotatoModel();
        potato.setName("водка");
        potato.setPrice(2000);
        potato.setVolumeCount(300);
        orderService.saveProduct(AbstractProductDetailsDto.from(potato));
        potato.setId(1);
        potato.setVolumeCount(200);
        orderService.saveProduct(AbstractProductDetailsDto.from(potato));
        assertEquals(potato, productRepository.getById(1));
    }


//    @Test
//    void SaveProductExceptionId() {
//        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
//        SalesRepositoryImpl salesRepository =  new SalesRepositoryImpl();
//        McDonaldServiceImpl orderService = new McDonaldServiceImpl(productRepository, salesRepository);
//        BurgerModel burger = new BurgerModel();
//        burger.setId(0);
//        orderService.saveProduct(AbstractProductDetailsDto.from(burger));
//        assertEquals(,productRepository.getById(1));
//        //burger.setBunCount(3);
//    }
}
