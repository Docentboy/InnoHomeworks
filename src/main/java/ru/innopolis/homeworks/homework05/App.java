package ru.innopolis.homeworks.homework05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/*
На вход программы в классе App, методе main подается информация отелевизорах в количестве 10 телевизоров.
Считать данные в массив объектов(можно выполнить считывание данных в цикле). В каждом из 10 экземпляровкласса
должны быть заполнены следующие поля:
    a. Как минимум, 1 поле по выбору, добавленное студентом в задании 3;
    b. Номер включенного канала - целое число,
    c. Громкость звука - целое число;
    d. Признак включен ли телевизор.
 */

public class App {
    public static void main(String[] args) {
        //Filling by constructor
        Television tv1 = new Television("Xiaomi", "X500", 101, 56800, 25, 30, true);
        Television tv2 = new Television("LG", "B10001", 280, 320000, 22, 40, true);
        Television tv3 = new Television("Sony", "S500", 100, 95000, 20, 50, true);
        Television tv4 = new Television("Panasonic", "P4000", 80, 890000, 19, 60, true);
        Television tv5 = new Television("Xiaomi", "X505", 101, 56000, 18, 70, true);
        Television tv6 = new Television("LG", "B15555", 280, 320000, 30, 80, true);
        Television tv7 = new Television("Sony", "S550", 120, 95000, 35, 90, true);
        Television tv8 = new Television("Panasonic", "P4500", 108, 80000, 44, 85, false);
        Television tv9 = new Television("Sony", "S700", 110, 95000, 5, 35, false);
        Television tv10 = new Television("Panasonic", "P4800", 120, 180000, 1, 10, true);

        Television[] televisions = new Television[]{tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10};

        Arrays.sort(televisions, Comparator.comparingInt(tv -> tv.getChannel()));

        int maxVolume = 100;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the maximum volume of the television:");
        maxVolume = sc.nextInt();

        for (Television television : televisions) {
            if (television.isSwitchedon() && television.getVolume() <= maxVolume) {
                System.out.println(television);
            }
        }
    }
}
