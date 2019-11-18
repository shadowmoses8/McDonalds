package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.PotatoDetailsDto;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PotatoModel extends ProductModel {
    private int volumeCount;
    private boolean itsFrenchFries;

    public PotatoModel(PotatoDetailsDto dto) {
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setPrice(dto.getPrice());
        this.volumeCount = dto.getVolumeCount();
        this.itsFrenchFries = dto.isItsFrenchFries();
    }
}
