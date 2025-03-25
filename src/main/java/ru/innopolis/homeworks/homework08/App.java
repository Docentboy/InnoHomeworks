package ru.innopolis.homeworks.homework08;

import ru.innopolis.homeworks.homework08.person.Person;
import ru.innopolis.homeworks.homework08.product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        String string = "";
        FileReader fileReader = new FileReader("src/main/java/ru/innopolis/homeworks/homework08/input.txt");
        FileWriter fileWriter = new FileWriter("src/main/java/ru/innopolis/homeworks/homework08/output.txt");

        try (BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            int counter = 0;
            List<Person> people = new ArrayList<>();
            List<Product> products = new ArrayList<>();
            String output = "";
            while (bufferedReader.ready()) {
                string = bufferedReader.readLine();
                if (counter == 0) { // обработка строки с Покупателями
                    people = fillDataByString(string, Person.class);
                } else if (counter == 1) { // обработка строки с базой продуктов
                    products = fillDataByString(string, Product.class);
                } else { // сбор корзины покупателя
                    try {
                        if ("END".equals(string)) {
                            for (Person person : people) {
                                output += "\r\n" + person.toPrint();
                            }
                        } else  {
                            String[] parts = string.split(" - ");
                            Person foundPerson = getPersonByName(people, parts[0].trim());
                            Product foundProduct = getProductByName(products, parts[1].trim());
                            if (foundPerson != null) {
                                output = foundPerson.addProductToBasket(foundProduct) + "\r\n";
                            }
                        }
                        bufferedWriter.write(output);
                    } catch (Exception e) {
                        System.out.println("Ошибка при формировании корзины: " + e.getMessage());
                    }
                }
                counter++;
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
