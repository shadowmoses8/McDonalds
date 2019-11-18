package ru.rosbank.javaschool.dto;

import lombok.Data;
import ru.rosbank.javaschool.model.DrinkModel;

@Data
public class DrinkDetailsDto extends AbstractProductDetailsDto {
    private int volumeInMilliliters;
    private int typeDrink;


    public DrinkDetailsDto(DrinkModel product) {
        super(product);
        volumeInMilliliters = product.getVolumeInMilliliters();
        typeDrink = product.getTypeDrink();
    }

}
