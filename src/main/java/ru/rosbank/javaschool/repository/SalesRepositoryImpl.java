package ru.rosbank.javaschool.repository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.rosbank.javaschool.model.SaleModel;

import java.util.LinkedList;
import java.util.List;


@Data
@Setter
@Getter
public class SalesRepositoryImpl {
    private final List<SaleModel> items = new LinkedList<>();
    private int Id = 1;

    public void create(SaleModel model) {
        model.setId(this.Id++);
        items.add(model);
    }
}
