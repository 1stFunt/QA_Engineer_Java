package Lesson_12_junit_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialCalculatorTest {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    void testFactorialOfZero() {
        Assertions.assertEquals(1, calculator.calculateFactorial(0), "Факториал 0 должен быть 1");
    }

    @Test
    void testFactorialOfPositiveNumber() {
        Assertions.assertEquals(120, calculator.calculateFactorial(5), "Факториал 5 должен быть 120");
    }

    @Test
    void testFactorialOfOne() {
        Assertions.assertEquals(1, calculator.calculateFactorial(1), "Факториал 1 должен быть 1");
    }

    @Test
    void testFactorialOfLargeNumber() {
        Assertions.assertEquals(2432902008176640000L, calculator.calculateFactorial(20),
                "Факториал 20 должен быть 2432902008176640000");
    }

    @Test
    void testNegativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-1),
                "Должно выбрасываться исключение для отрицательных чисел");
    }
}
