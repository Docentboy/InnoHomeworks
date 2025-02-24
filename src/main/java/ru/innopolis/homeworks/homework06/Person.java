package ru.innopolis.homeworks.homework06;

import java.util.Arrays;
import java.util.List;

public class Person {

    private String name;
    private int money;
    private Product[] basket = new Product[10];

    private int index = 0;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
    }


    public void addProductToBasket(Product product) {
        if (this.money > product.getPrice()) {
            this.basket[index] = product;
            index++;
            this.money -= product.getPrice();
            System.out.println(this.getName() + " купил " + product.getName());
        } else {
            System.out.println(this.getName() + " не может позволить себе " + product.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым!");
        } else {
            this.name = name;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            System.out.println("Сумма покупателя не может быть отрицательной");
        } else {
            this.money = money;
        }
    }



    public String toPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " - ");

        for (Product item : basket) {
            if (item != null) {
                sb.append(item.toString() + " ");
            }
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", basket=" + Arrays.toString(basket) +
                ", index=" + index +
                '}';
    }
}
