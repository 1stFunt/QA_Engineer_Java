package Lesson_2;

import java.util.Scanner;
import java.util.Arrays;

public class Tasks {
    /*
    1. Создайте метод printThreeWords(), который при вызове должен
    отпечатать в столбец три слова: Orange, Banana, Apple.
    */
    public static void printThreeWords() {
        System.out.println("1). Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /*
    2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми
    значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше
    или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
    */
    public static void checkSumSign(int a, int b) {
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("2). Сумма положительная");
        } else {
            System.out.println("2). Сумма отрицательная");
        }
    }

    /*
    3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
    Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах
    от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
    */
    public static void printColor(int value) {
        if (value < 0) {
            System.out.println("3). Красный");
        } else if (value <= 100) {
            System.out.println("3). Желтый");
        } else {
            System.out.println("3). Зеленый");
        }
    }

    /*
    4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их
    любыми значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение
    “a >= b”, в противном случае “a < b”;
    */
    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("4). a >= b");
        } else {
            System.out.println("4). a < b");
        }
    }

    /*
    5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
    (включительно), если да – вернуть true, в противном случае – false.
     */
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkUserSumInRange() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        boolean result = isSumInRange(num1, num2);
        System.out.println("5). Результат: " + result);

        scanner.close();
    }

    /*
    6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void printSignOfNumber(int number) {
        if (number >= 0) {
            System.out.println("6). Число положительное");
        } else {
            System.out.println("6). Число отрицательное");
        }
    }

    /*
    7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    если число отрицательное, и вернуть false если положительное. Замечание: ноль считаем положительным числом.
     */
    public static void printIsNegative(int number) {
        boolean result = number < 0;
        System.out.println("7). Результат: " + result);
    }

    /*
    8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
    в консоль указанную строку, указанное количество раз;
     */
    public static void printStringMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("8). " + text);
        }
    }

    /*
    9. Напишите метод, который определяет, является ли год високосным,
    и возвращает boolean (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом
    каждый 400-й – високосный.
     */
    public static void checkLeapYear(int year) {
        boolean isLeapYear = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        System.out.println("9). Год " + year + " високосный: " + isLeapYear);
    }

    /*
    10. Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0.
    После замены вывести исходный и измененный массив на экран.
     */
    public static void invertArrayAndPrint(int[] array) {
        System.out.print("10). Исходный массив: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
        System.out.print("Массив после замены: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*
    11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
    значениями 1, 2, 3, 4, 5, 6, 7, 8, ..., 100.
     */
    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.print("11). ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*
    12. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]. Пройти по нему циклом и числа, меньшие 6, умножить на 2.
    После обработки массива вывести его на экран.
     */
    public static void multiplyIfLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.print("12). ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*
    13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
    цикла(-ов) заполнить его диагональные элементы единицами.
    Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
    то есть [0][0], [1][1], [2][2], ..., [n][n];
     */
    public static void fillDiagonal() {
        int size = 5;
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
        }
        System.out.println("13). Массив с диагональю:");
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    /*
    14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
    типа int длиной len, каждая ячейка которого равна initialValue.
     */
    public static void createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        System.out.print("14). ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}