package ru.rosbank.javaschool.dto;

import lombok.Data;
import ru.rosbank.javaschool.model.PotatoModel;

@Data
public class PotatoDetailsDto extends AbstractProductDetailsDto {
    private int volumeCount;
    private boolean itsFrenchFries;


    public PotatoDetailsDto(PotatoModel product) {
        super(product);
        volumeCount = product.getVolumeCount();
        itsFrenchFries = product.isItsFrenchFries();
    }
}