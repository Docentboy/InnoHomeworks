package ru.innopolis.homeworks.homework09.model.car;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String[] addOns = new String[10];
    private int addonCount = 0;

    public PerformanceCar() {
        super();
    }

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, (int)(horsepower * 1.5), acceleration, (int)(suspension * 0.75), durability);
    }

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    public void addAddon(String addon) {
        if (addonCount < addOns.length) {
            addOns[addonCount++] = addon;
        } else {
            System.out.println("Превышено максимальное количество улучшений.");
        }
    }

    @Override
    public String toString() {
        return "PerformanceCar{" + super.toString() +
                ", addons=" + (addOns != null ? Arrays.toString(addOns) : "[]") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
