package ru.innopolis.homeworks.homework09.model;

import ru.innopolis.homeworks.homework09.model.car.Car;
import ru.innopolis.homeworks.homework09.model.car.PerformanceCar;
import ru.innopolis.homeworks.homework09.model.car.ShowCar;

import java.util.Arrays;
import java.util.Objects;

public class Garage {

    private Car[] parkedCars;
    private int size;

    public Garage() {
        parkedCars = new Car[10];
        size = 0;
    }

    public void parkCar(Car car) {
        if (size == parkedCars.length) {
            parkedCars = Arrays.copyOf(parkedCars, parkedCars.length * 2);
        }
        parkedCars[size++] = car;
    }

    public void unparkCar(Car car) {
        for (int i = 0; i < size; i++) {
            if (parkedCars[i].equals(car)) {
                System.arraycopy(parkedCars, i + 1, parkedCars, i, size - i - 1);
                parkedCars[--size] = null;
                break;
            }
        }
    }

    public void modifyCar() {
        for (int i = 0; i < size; i++) {
            Car car = parkedCars[i];
            if (car instanceof PerformanceCar) {
                ((PerformanceCar) car).addAddon("Спойлер");
                System.out.println("Для " + car.getBrand() + " " + car.getModel() + " добавлен Спойлер");
            } else if (car instanceof ShowCar) {
                ((ShowCar) car).addStars(1);
                System.out.println("Теперь у " + car.getBrand() + " " + car.getModel() + " - " + ((ShowCar) car).getStars() + " звезд");
            }
        }
    }

    public Car[] getParkedCars() {
        return Arrays.copyOf(parkedCars, size);
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    @Override
    public String toString() {
        return "Garage{" + "parkedCars=" + Arrays.toString(parkedCars) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.deepEquals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parkedCars);
    }
}
