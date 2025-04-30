package ru.innopolis.homeworks.homework09.model.car;

import java.util.Objects;

public class ShowCar extends Car {

    private int stars;

    public ShowCar() {
        super();
    }

    public ShowCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability, int stars) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void addStars(int stars) {
        this.stars += stars;
    }

    @Override
    public String toString() {
        return "ShowCar{" + super.toString() + ", Stars=" + stars + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}
