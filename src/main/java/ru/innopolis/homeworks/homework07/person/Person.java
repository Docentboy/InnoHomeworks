package ru.innopolis.homeworks.homework07.person;

import ru.innopolis.homeworks.homework07.product.DiscountProduct;
import ru.innopolis.homeworks.homework07.product.Product;

import java.time.LocalDate;
import java.util.Arrays;

public class Person {

    private String name;
    private int money;
    private DiscountProduct[] basket = new DiscountProduct[10];

    private int index = 0;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
    }


    public void addProductToBasket(DiscountProduct product) {
        if (LocalDate.now().isAfter(product.getDiscountDate())) {
            if (this.money > product.getPrice() / product.getDiscount() * 100) {
                this.basket[index] = product;
                index++;
                this.money -= product.getPrice();
                System.out.println(this.getName() + " купил " + product.getName());
            } else {
                System.out.println(this.getName() + " не может позволить себе " + product.getName());
            }
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
