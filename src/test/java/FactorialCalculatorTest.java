import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialCalculatorTest {

    // Экземпляр класса FactorialCalculator для тестирования
    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    void testFactorialOfZero() {
        assertEquals(1, calculator.calculateFactorial(0), "Факториал 0 должен быть 1");
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, calculator.calculateFactorial(5), "Факториал 5 должен быть 120");
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, calculator.calculateFactorial(1), "Факториал 1 должен быть 1");
    }

    @Test
    void testFactorialOfLargeNumber() {
        assertEquals(2432902008176640000L, calculator.calculateFactorial(20),
                "Факториал 20 должен быть 2432902008176640000");
    }

    @Test
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-1),
                "Должно выбрасываться исключение для отрицательных чисел");
    }
}
