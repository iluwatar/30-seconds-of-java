/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package math;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

/**
 * Tests for 30 Seconds of Java code library.
 */
public class RandomNumberTest {
	
	/**
	 * Test for generating random short number
	 */
	@Test
	void test_shortRandomNumber() {
		// Test for Short range
		Number shortResult = RandomNumber.getRandomNumber(Short.valueOf((short) 2), Short.valueOf((short) 7));
		assertTrue(shortResult instanceof Short);
		assertTrue((shortResult.shortValue() >= 2) && (shortResult.shortValue() <= 7));
	}
	
	/**
	 * Test for generating random integer number
	 */
	@Test
	void test_intRandomNumber() {
		// Test for Integer range
		Number intResult = RandomNumber.getRandomNumber(Integer.valueOf(5), Integer.valueOf(10));
		assertTrue(intResult instanceof Integer);
		assertTrue((intResult.intValue() >= 5) && (intResult.intValue() <= 10));
	}
	
	/**
	 * Test for generating random long number
	 */
	@Test
	void test_longRandomNumber() {
		// Test for Long range
		Number longResult = RandomNumber.getRandomNumber(Long.valueOf((long) -100), Long.valueOf((long) 2500));
		assertTrue(longResult instanceof Long);
		assertTrue((longResult.longValue() <= -100) && (longResult.longValue() <= 2500));
	}
	
	/**
	 * Test for generating random float number
	 */
	@Test
	void test_floatRandomNumber() {
		// Test for Float range
		Number floatResult = RandomNumber.getRandomNumber(Float.valueOf((float) 2.5f), Float.valueOf((float) 25.4f));
		assertTrue(floatResult instanceof Float);
		assertTrue((floatResult.floatValue() >= 2.5f) && (floatResult.floatValue() <= 25.4f));
	}
	
	/**
	 * Test for generating random double number
	 */
	@Test
	void test_doubleRandomNumber() {
		// Test for Double range
		Number doubleResult = RandomNumber.getRandomNumber(Double.valueOf((double) 100.12), Double.valueOf((double) 200.28));
		assertTrue(doubleResult instanceof Double);
		assertTrue((doubleResult.doubleValue() >= 100.12) && (doubleResult.doubleValue() <= 200.28));
	}
}
