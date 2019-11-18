package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.DrinkDetailsDto;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DrinkModel extends ProductModel {
    private int volumeInMilliliters;
    private int typeDrink;

    public DrinkModel(DrinkDetailsDto dto) {
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setPrice(dto.getPrice());
        this.volumeInMilliliters = dto.getVolumeInMilliliters();
        this.typeDrink = dto.getTypeDrink();
    }
}
