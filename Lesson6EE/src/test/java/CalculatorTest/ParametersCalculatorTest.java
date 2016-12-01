package CalculatorTest;

import calculatorTest.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ParametersCalculatorTest {

    private Calculator calculator = new Calculator();
    private int fNumber, sNumber;

    public ParametersCalculatorTest(int a, int b) {
        fNumber = a;
        sNumber = b;
    }


    @Parameterized.Parameters
    public static List<Object[]> data() {
        Object[][] data = new Object[][]{
                {1, 3},
                {4, 5},
                {6, 7},
                {8, 9}
        };

        return Arrays.asList(data);
    }

    @Test
    public void test_sum_calc() {
        Calculator calculator = new Calculator();
        int sum = calculator.add(fNumber, sNumber);
        Assert.assertEquals(sum,fNumber+sNumber);
    }

}
