package ru.innopolis.homeworks.homework06;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        //Вводим список покупателей формата: Павел Андреевич = 10000; АннаПетровна = 2000; Борис = 10
        Scanner in = new Scanner(System.in);
        System.out.println("Введите список покупателей: ");
        String personData = in.nextLine();
        List<Person> people = fillDataByString(personData, Person.class);

        //Вводим список продуктов формата: Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150
        System.out.println("Введите список продуктов: ");
        String productData = in.nextLine();
        List<Product> products = fillDataByString(productData, Product.class);

        //Совершаем покупки. Формат: Павел Андреевич - Хлеб
        System.out.println("А теперь набираем корзину (Для окончания наберите 'END'): ");
        boolean check = true;
        while (check) {
            String input = in.nextLine();
            if (input.equals("END")) {
                check = false;
                for (Person person : people) {
                    System.out.println(person.toPrint());
                }
            } else {
                try {
                    String[] parts = input.split(" - ");
                    Person foundPerson = getPersonByName(people, parts[0].trim());
                    Product foundProduct = getProductByName(products, parts[1].trim());
                    foundPerson.addProductToBasket(foundProduct);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    //Выборка Покупателя по его Имени
    private static Person getPersonByName(List<Person> people, String name) {
        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    //Выборка продукта по его наименованию
    private static Product getProductByName(List<Product> products, String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    //Находим Покупателя или Продукт, по введенным данным.
    public static <T> List<T> fillDataByString(String input, Class<T> type) {
        String[] entries = input.split("; ");
        List<T> objects = new ArrayList<>();

        for (String entry : entries) {
            String[] parts = entry.split(" = ");
            String name = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());

            if (type == Person.class) {
                objects.add(type.cast(new Person(name, value)));
            } else if (type == Product.class) {
                objects.add(type.cast(new Product(name, value)));
            }
        }

        return objects;
    }

}
