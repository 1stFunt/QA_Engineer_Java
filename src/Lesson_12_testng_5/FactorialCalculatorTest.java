package Lesson_12_testng_5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialCalculator.factorial(1), 1, "Факториал 1 должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120, "Факториал 5 должен быть 120");
    }

    @Test
    public void testFactorialOfLargeNumber() {
        Assert.assertEquals(FactorialCalculator.factorial(20), 2432902008176640000L, "Факториал 20 должен быть 2432902008176640000");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число должно быть неотрицательным")
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }
}