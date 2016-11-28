package CalculatorTest;

import calculatorTest.Calculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class CalculatorFunctionTest {


    @BeforeClass
    public static void init() {
        System.out.println("before class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void check_sum_metod() {
        Calculator calculator = mock(Calculator.class);
        when(calculator.getOperant1()).thenReturn(12);
        when(calculator.getOperant2()).thenReturn(18);

        when(calculator.add()).thenReturn(30);

        Assert.assertEquals(calculator.getOperant1(),12);
        Assert.assertEquals(calculator.getOperant2(),18);

        int sum = calculator.add();
        Assert.assertEquals(sum,30);

        verify(calculator,times(1)).add();
    }


    @Test
    public void spy_collection_test() {
        List<Integer> integers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 9, 1, 2));
        List<Integer> spy = spy(integers);
        doReturn(-1000).when(spy).get(0);

        Integer firstIntegerElement = spy.get(0);
        Assert.assertTrue(firstIntegerElement==-1000);
        Integer secondElement = spy.get(1);
        Assert.assertTrue(secondElement==3);
    }


    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @After
    public void after() {
        System.out.println("after");
    }


}
