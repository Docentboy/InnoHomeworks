package ru.innopolis.homeworks.homework07;

import ru.innopolis.homeworks.homework07.product.DiscountProduct;
import ru.innopolis.homeworks.homework07.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        //Вводим список продуктов формата: Хлеб = 40; Молоко = 60; Торт = 800, 15%; Кофе растворимый = 432, 50%
        System.out.println("Введите список продуктов: ");

        boolean check = true;
        while (check) {
            String input = in.nextLine();
            if (input.equals("END")) {
                check = false;
            } else {
                try {
                    String[] parts = input.split(" = ");
                    String name = parts[0].trim();
                    String pricePart = parts[1].trim();
                    if (pricePart.contains(",")) {
                        // Это скидочный продукт
                        String[] priceParts = pricePart.split(",");
                        int price = Integer.parseInt(priceParts[0].trim());
                        String discountStr = priceParts[1].trim().replace("%", "");
                        int discount = Integer.parseInt(discountStr);
                        DiscountProduct discountProduct = new DiscountProduct(name, price, discount, LocalDate.of(2025, 04, 30));
                        products.add(discountProduct);
                    } else {
                        //Обычный продукт
                        int price = Integer.parseInt(pricePart);
                        Product product = new Product(name, price);
                        products.add(product);
                    }
                    System.out.println("Продукт " + name + " добавлен в список");
                } catch (Exception e) {
                    System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
                }
            }
        }

        System.out.println("\nСписок продуктов:");
        for (Product p : products) {
            System.out.println(p.toString());
        }

    }


}
