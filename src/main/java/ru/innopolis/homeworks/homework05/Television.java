package ru.innopolis.homeworks.homework05;

import java.util.Objects;

public class Television {

    public Television(String brand, String model, int size, int price, int channel, int volume, boolean switchedon) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.price = price;
        this.channel = channel;
        this.volume = volume;
        this.switchedon = switchedon;
    }

    private String brand;
    private String model;
    private int size;
    private int price;
    private int channel;
    private int volume;
    private boolean switchedon;

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

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isSwitchedon() {
        return switchedon;
    }

    public void setSwitchedon(boolean switchedon) {
        this.switchedon = switchedon;
    }

    @Override
    public String toString() {
        return "Television{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", channel=" + channel +
                ", volume=" + volume +
                ", switchedon=" + switchedon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return size == that.size && price == that.price && channel == that.channel && volume == that.volume && switchedon == that.switchedon && Objects.equals(brand, that.brand) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, size, price, channel, volume, switchedon);
    }

}