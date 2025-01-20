package ru.innopolis.homework.classes03;

import java.util.Random;

/*
Домашнее задание по темам «Классы: поля, свойства, методы» и «Класс Object. Класс String»
Формулировка задания:Реализовать класс Телевизор. У класса есть поля, свойства и методы.
роверить работу в классе App, методе main. Обратить внимание на переопределение метода toString.
Ожидаемый результат:
1. Создан класс  Телевизор;
2. У класса есть поля, свойства и методы. Поля желательно сделать private. Задать новые значения полям класса можно через конструктор и setters.
3. В классе переопределен метод toString.
4. Создан класс App с методом main.
5. В методе main класса App создано несколько экземпляров классаТелевизор и проверено, как распечатываются заполненные данные обэкземплярах класса.
6. Дополнительно. Задавать параметры класса Телевизор с клавиатуры или случайным числом. Формат представления работы:
 */

public class App {
    public static void main(String[] args) {
        //Filling by constructor
        Television tv1 = new Television("Xiaomi", "X500", 101, 56000);
        Television tv2 = new Television("LG", "B10001", 280, 320000);
        Television tv3 = new Television("Sony", "X500", 101, 95000);
        Television tv4 = new Television("Panasonic", "P4000", 108, 80000);

        // Filling by Setter and Randomizer
        Television tv5 = new Television();
        tv5.setBrand("Samsung");
        tv5.setModel("L50005");
        Random random = new Random();
        tv5.setSize(random.nextInt());
        tv5.setPrice(random.nextInt());

        System.out.println(tv1.toString() + '\n' + tv2.toString() + '\n' + tv3.toString() + '\n' + tv4.toString() + '\n' + tv5.toString());
    }
}
