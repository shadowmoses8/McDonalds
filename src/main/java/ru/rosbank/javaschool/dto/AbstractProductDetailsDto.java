package ru.rosbank.javaschool.dto;


import lombok.*;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.model.BurgerModel;
import ru.rosbank.javaschool.model.DrinkModel;
import ru.rosbank.javaschool.model.PotatoModel;
import ru.rosbank.javaschool.model.ProductModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractProductDetailsDto {
    private int id;
    private String name;
    private int price;

    public AbstractProductDetailsDto(ProductModel product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
    }

    public static AbstractProductDetailsDto from(ProductModel product) {
        if (product instanceof BurgerModel) {
            return new BurgerDetailsDto((BurgerModel) product);
        }
        if (product instanceof DrinkModel) {
            return new DrinkDetailsDto((DrinkModel) product);
        }
        if (product instanceof PotatoModel) {
            return new PotatoDetailsDto((PotatoModel) product);
        }
        throw new InvalidDataException("Такого класса нет ");
    }
}
