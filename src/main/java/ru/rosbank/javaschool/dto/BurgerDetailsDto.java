package ru.rosbank.javaschool.dto;

import lombok.Data;
import ru.rosbank.javaschool.model.BurgerModel;
import ru.rosbank.javaschool.model.PotatoModel;

@Data
public class BurgerDetailsDto extends AbstractProductDetailsDto {
    private int cutletCount;
    private int bunCount;
    private int cheeseCount;

    public BurgerDetailsDto(BurgerModel product) {
        super(product);
        cutletCount = product.getCutletCount();
        bunCount = product.getBunCount();
        cheeseCount = product.getCheeseCount();
    }

}
