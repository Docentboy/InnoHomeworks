package ru.innopolis.homeworks.homework08.person;

import ru.innopolis.homeworks.homework08.product.DiscountProduct;
import ru.innopolis.homeworks.homework08.product.Product;

import java.time.LocalDate;
import java.util.Arrays;

public class Person {

    private String name;
    private int money;
    private Product[] basket = new Product[10];

    private int index = 0;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
    }


    public String addProductToBasket(Product product) {
        String result = "";
        if (product instanceof DiscountProduct discountProduct) {
            if (LocalDate.now().isBefore(discountProduct.getDiscountDate()) && this.money >= discountProduct.getPrice() / discountProduct.getDiscount() * 100) {
                    index++;
                    this.money -= discountProduct.getPrice() / discountProduct.getDiscount() * 100;
                    this.basket[index] = discountProduct;
                    result = (this.getName() + " купил " + discountProduct.getName());
                }

        } else if (this.money > product.getPrice()) {
            this.money -= product.getPrice();
            this.basket[index] = product;
            index++;
            result = (this.getName() + " купил " + product.getName());
        } else {
            result = (this.getName() + " не может позволить себе " + product.getName());
        }
        return result;
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
