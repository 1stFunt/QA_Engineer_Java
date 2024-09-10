package Lesson_12_junit_5;

// Напишите программу, позволяющую вычислить факториал числа. Напишите юнит-тесты для этой программы, используя Junit 5.
public class FactorialCalculator {
    public long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
