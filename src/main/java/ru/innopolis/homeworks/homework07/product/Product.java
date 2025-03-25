package ru.innopolis.homeworks.homework07.product;

import java.util.Objects;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.matches("\\d+") || name.length() < 3) {
            throw new IllegalArgumentException("Недопустимое имя продукта!");
        }
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Недопустимая стоимость продукта!");
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
