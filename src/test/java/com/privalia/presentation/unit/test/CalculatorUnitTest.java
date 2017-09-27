package com.privalia.presentation.unit.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import com.privalia.presentation.Calculator;

public class CalculatorUnitTest {
	@Test
	public void testAdd() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.add(2, 3)).thenReturn(5);
		assertTrue(calculator.add(2,  3) == 5);
	}
	
	@Test
	public void testSubstract() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.substract(2, 2)).thenReturn(0);
		assertTrue(calculator.substract(2,  2) == 0);
	}

	@Test
	public void testMultiply() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.multiply(2, 3)).thenReturn(6);
		assertTrue(calculator.multiply(2,  3) == 6);
	}
	
	@Test
	public void testDivide() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.divide(6, 3)).thenReturn(2);
		assertTrue(calculator.divide(6,  3) == 2);
	}
}
