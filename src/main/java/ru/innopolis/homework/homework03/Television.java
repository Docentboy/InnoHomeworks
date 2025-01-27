package ru.innopolis.homework.homework03;

public class Television {
    public Television() {
    }

    public Television(String brand, String model, int size, int price) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.price = price;
    }

    private String brand;
    private String model;
    private int size;
    private int price;

    @Override
    public String toString() {
        return "Television{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}