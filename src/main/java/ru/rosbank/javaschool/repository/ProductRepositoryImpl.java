package ru.rosbank.javaschool.repository;

import lombok.Data;
import lombok.var;
import ru.rosbank.javaschool.model.BurgerModel;
import ru.rosbank.javaschool.model.DrinkModel;
import ru.rosbank.javaschool.model.PotatoModel;
import ru.rosbank.javaschool.model.ProductModel;

import java.util.LinkedList;
import java.util.List;

@Data
public class ProductRepositoryImpl implements ProductRepository {
    private final List<ProductModel> items = new LinkedList<>();
    private int nextId = 1;


    public ProductModel create(ProductModel item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    public ProductModel update(ProductModel item) {
        for (var product : items) {
            if (item.getId() == product.getId()) {
                product.setName(item.getName());
                product.setPrice(item.getPrice());
                if (product instanceof BurgerModel) {
                    setItemsInProduct((BurgerModel) product, (BurgerModel) item);
                    return product;
                }
                if (product instanceof DrinkModel) {
                    setItemsInProduct((DrinkModel) product, (DrinkModel) item);
                    return product;
                }
                if (product instanceof PotatoModel) {
                    setItemsInProduct((PotatoModel) product, (PotatoModel) item);
                    return product;
                }
            }
        }
        return item;
    }

    private void setItemsInProduct(BurgerModel product, BurgerModel item) {
        product.setBunCount(item.getBunCount());
        product.setCheeseCount(item.getCheeseCount());
        product.setCutletCount(item.getCutletCount());
    }


    private void setItemsInProduct(DrinkModel product, DrinkModel item) {
        product.setTypeDrink(item.getTypeDrink());
        product.setVolumeInMilliliters(item.getVolumeInMilliliters());
    }


    private void setItemsInProduct(PotatoModel product, PotatoModel item) {
        product.setItsFrenchFries(item.isItsFrenchFries());
        product.setVolumeCount(item.getVolumeCount());
    }

    public boolean removeById(int id) {
        return items.removeIf(o -> o.getId() == id);
    }

    public List<ProductModel> getItems() {
        return items;
    }

    public List<ProductModel> getItemsByCategory(ProductModel model) {
        List<ProductModel> productModels = new LinkedList<>();
        if (model instanceof BurgerModel) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) instanceof BurgerModel) {
                    productModels.add(items.get(i));
                }
            }
        }
        if (model instanceof DrinkModel) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) instanceof DrinkModel) {
                    productModels.add(items.get(i));
                }
            }

        }
        if (model instanceof PotatoModel) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) instanceof PotatoModel) {
                    productModels.add(items.get(i));
                }
            }
        }
        return productModels;
    }


    public ProductModel getById(int id) {
        for (ProductModel item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public int sizeProductRepository() {
        return items.size();
    }

}





