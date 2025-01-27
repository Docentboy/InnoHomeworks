package ru.innopolis.homework.homework04;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        /* Задача 1. Для введенной с клавиатуры буквы английского алфавита нужно вывести слева стоящую букву на стандартной клавиатуре.
        При этом клавиатура замкнута, т.е.справа от буквы «p» стоитбуква «a», а слева от "а" буква "р",также соседними
        считаются буквы «l» и буква «z», а буква «m» с буквой «q».*/

        final String keyboard = "qwertyuiopasdfghjklzxcvbnm";
        char[] keyboarArray = keyboard.toCharArray();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите любую букву с клавиатуры на английской раскладке:");
        char letter = in.next().charAt(0);
        int leftIndex = 0;
        for (int i = 0; i < keyboarArray.length; i++) {
            if (keyboarArray[i] == letter) {
                if (i == 0) { leftIndex = keyboarArray.length - 1; }
                else leftIndex = i - 1;
            }
        }
        if (leftIndex >= 0) {
            System.out.println(keyboarArray[leftIndex]);
        }




    }

}
