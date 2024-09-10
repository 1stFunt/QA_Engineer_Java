package Lesson_12_testng_5;

// Напишите программу, позволяющую вычислить факториал числа. Напишите юнит-тесты, используя TestNG.
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

