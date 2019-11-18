package ru.rosbank.javaschool.model;

import lombok.Data;
import ru.rosbank.javaschool.dto.SaleDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class SaleModel {
    private int id;
    private List<ProductModel> products = new ArrayList<>();
    private int totalPrice;

    public void setPrice(int price) {
        totalPrice += price;
    }

}

