package Lesson_12_testng_5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {
    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.calculator(0), 1, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialCalculator.calculator(1), 1, "Факториал 1 должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(FactorialCalculator.calculator(5), 120, "Факториал 5 должен быть 120");
    }

    @Test
    public void testFactorialOfLargeNumber() {
        Assert.assertEquals(FactorialCalculator.calculator(20), 2432902008176640000L, "Факториал 20 должен быть 2432902008176640000");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.calculator(-1);
        Assert.fail("Должно выбрасываться исключение для отрицательных чисел");
    }
}