package com.example.log4j;

import org.example.log4j.CalculatorApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorAppTest {
    private CalculatorApp calc_app;

    @Test
    public void getSum() {
        assertEquals(14, calc_app.getSum(7,7));
    }

    @Test
    public void getDivide() {
        assertEquals(25, calc_app.getDivide(100,4));
    }

    @Test(expected = ArithmeticException.class)
    public void divisionWithException() {
        calc_app.getDivide(15,0);
    }

    @Test
    public void getMultiple() {
        assertEquals(48, calc_app.getMultiple(6,8));
    }

    @Test
    public void getSub() {
        assertEquals(12, calc_app.getSub(71,59));
    }


    @Before
    public void initTest() {
        calc_app = new CalculatorApp();
    }

    @After
    public void afterTest() {
        calc_app = null;
    }
}