package ru.innopolis.homework.homework04;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        /*Задача 2. Задана последовательность, состоящая только из символов ‘>’, ‘<’ и ‘-‘. Требуется найти количество
        стрел, которые спрятаны в этой последовательности. Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’. */
        String arrows = ">>-->--->>-->->>>>>>--><<<<>>-->>>>>>-->-----<--<<<--<<<--<<<--<<";
        Pattern pattern = Pattern.compile("<--<<|>>-->");
        Matcher matcher = pattern.matcher(arrows);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("Задача 2. Количество найденных стрел:" + count);

        /* Задача 3. Задана строка, состоящая из букв английского алфавита, разделенных одним пробелом.
        Необходимо каждую последовательность символов упорядочить по возрастанию и вывести слова в нижнем регистре.*/
        String input = "bca cba";
        String[] strings = input.split(" ");
        String output = "";
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            Arrays.sort(chars);
            output = output + new String(chars);
        }
        System.out.println("Задача 3. Результат:" + output);
    }

}
