package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.AbstractProductDetailsDto;
import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.dto.DrinkDetailsDto;
import ru.rosbank.javaschool.dto.PotatoDetailsDto;
import ru.rosbank.javaschool.exception.InvalidDataException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProductModel {
    private int id;
    private String name;
    private int price;

    public static ProductModel from(AbstractProductDetailsDto dto) {
        if (dto instanceof BurgerDetailsDto) {
            return new BurgerModel((BurgerDetailsDto) dto);
        }
        if (dto instanceof DrinkDetailsDto) {
            return new DrinkModel((DrinkDetailsDto) dto);
        }
        if (dto instanceof PotatoDetailsDto) {
            return new PotatoModel((PotatoDetailsDto) dto);
        }
        throw new InvalidDataException("Такого класса нет ");
    }
}

