package ru.innopolis.homeworks.homework02;

import java.util.Scanner;

public class Jvm02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задачи 1-4:");
        int task = sc.nextInt();
        switch (task) {
            case 1:
                Task1(sc);
                break;
            case 2:
                Task2(sc);
                break;
            case 3:
                Task3(sc);
                break;
            case 4:
                Task4(sc);
                break;
            default:
                System.out.println("Неверное значение");
        }
    }

    /* Задача 1. Напишите Java-программу для преобразования температуры изФаренгейта в градусы Цельсия. */
    private static void Task1(Scanner sc) {
        System.out.println("Введите температуру в Фаренгейтах:");
        float fg = sc.nextFloat();
        float celsius = (fg - 32) * 5 / 9;
        System.out.println(fg + " градусов по Фаренгейту равна " + celsius + " по Цельсию");
    }

    /*Задача 2.  Напишите программу на Java, которая принимает два целыхчисла от пользователя,
    а затем печатает сумму, разницу, произведение, среднеезначение, расстояние (разница между целыми числами),
    максимум (большее издвух целых чисел), минимум (меньшее из двух целых чисел).
    */
    public static void Task2(Scanner sc) {
        System.out.println("Введите 1-е целое число:");
        int firstNum = sc.nextInt();
        System.out.println("Введите второе целое число:");
        int secondNum = sc.nextInt();
        System.out.println("Сумма двух целых чисел:" + (firstNum + secondNum) + '\n' +
                "Разница двух целых чисел:" + (firstNum - secondNum) + '\n' +
                "Произведение из двух целых чисел:" + (firstNum * secondNum) + '\n' +
                "Среднее из двух целых чисел:" + (firstNum + secondNum) / 2 + '\n' +
                "Расстояние двух целых чисел:" + Math.abs(firstNum - secondNum) + '\n' +
                "Максимальное целое число:" + Math.max(firstNum, secondNum) + '\n' +
                "Минимальное целое число:" + Math.min(firstNum, secondNum));
    }

    /* Задача 3*. Напишите Java-программу для объединения данной строки с самим собой заданное количество раз. */
    public static void Task3(Scanner sc) {
        System.out.println("Исходная строка:");
        String str = sc.next();
        System.out.println("Сколько раз вывести строку?");
        int choice = sc.nextInt();
        String output = new String();
        for (int i = 0; i < choice; i++) {
            output = output + str;
        }
        System.out.println(output);
    }

    /* Задача 4*. Напишите программу на Java для печати сетки из заданныхэлементов. */
    public static void Task4(Scanner sc) {
        System.out.println("Введите число строк и столбцов сетки: ");
        int size = sc.nextInt();
        System.out.println("Введите повторяемый элемент сетки: ");
        String element = sc.next();
        String line = new String();
        for (int i = 0; i < size; i++) {
            line = line + element;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(line);
        }
    }
}
