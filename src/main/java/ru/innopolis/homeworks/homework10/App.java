package ru.innopolis.homeworks.homework10;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] numbers = {12, 25, 37, 44, 58, 63, 71, 155, 160, 165};

        // Четные числа
        int[] evens = Sequence.filter(numbers, n -> n % 2 == 0);
        System.out.println("Четные: " + Arrays.toString(evens));

        // Сумма цифр — чётное число
        int[] sumEvenDigits = Sequence.filter(numbers, n -> {
            int sum = 0, temp = n;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            return sum % 2 == 0;
        });
        System.out.println("Сумма цифр — четная: " + Arrays.toString(sumEvenDigits));
    }
}
