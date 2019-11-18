package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.BurgerDetailsDto;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BurgerModel extends ProductModel {
    private int cutletCount;
    private int bunCount;
    private int cheeseCount;

    public BurgerModel(BurgerDetailsDto dto) {
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setPrice(dto.getPrice());
        this.cutletCount = dto.getCutletCount();
        this.bunCount = dto.getBunCount();
        this.cheeseCount = dto.getCheeseCount();
    }

//    public BurgerModel from(BurgerDetailsDto dto) {
//        return new BurgerModel(
//                dto.getId(),
//                dto.getName(),
//                dto.getPrice(),
//                dto.getCutletCount(),
//                dto.getBunCount(),
//                dto.getCheeseCount());
//    }

//
//    public BurgerModel(int id, String name, int price, int cutletCount, int bunCount, int cheeseCount) {
//        this.setId(id);
//        this.setName(name);
//        this.setPrice(price);
//        this.cutletCount =cutletCount;
//        this.bunCount = bunCount;
//        this.cheeseCount= cheeseCount;
//    }
}

