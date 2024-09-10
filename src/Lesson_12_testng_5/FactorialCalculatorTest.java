package Lesson_12_testng_5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120);
    }

    @Test
    public void testFactorialOfLargeNumber() {
        Assert.assertEquals(FactorialCalculator.factorial(20), 2432902008176640000L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }
}