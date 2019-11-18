package ru.rosbank.javaschool.dto;

import lombok.Data;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.model.SaleModel;

import java.util.ArrayList;
import java.util.List;

@Data
public class SaleDto {
    private int id;
    private List<ProductModel> products = new ArrayList<>();
    private int totalPrice;

    public SaleDto(int id, List<ProductModel> products, int totalPrice) {
        this.id = id;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public static SaleDto from(SaleModel saleModel) {
        return new SaleDto(
                saleModel.getId(),
                saleModel.getProducts(),
                saleModel.getTotalPrice()
        );
    }
}
