package day6;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathExampleTestingTest {
	MathExampleTesting math;

	@BeforeEach
	void setup() {
		math = new MathExampleTesting();
	}

	@Test
	void test() {

		int result = math.add(3, 5);// act
		assertEquals(8, result);// assert

	}

	@Test
	void testAddNegativeNumbers() {

		int result = math.add(-2, -5);// act
		assertEquals(-7, result);// assert
	}

	@Test
	void testAddNegativeAndPositveNumbers() {
		int result = math.add(2, -5);// act
		assertEquals(-3, result);// assert
	}

	// 2nd method
	@Test
	void testWithArray() {
		int result = math.addWithArray(new Integer[] { 1, 2, 3, 4, 5 });
		assertEquals(15, result);
	}

	@Test
	void testdivide() {
		int result = math.divide(4, 2);
		assertEquals(2, result);
	}


//	void testWithZero() {
//		//assertThrows(ArithmeticException.class, () -> {
//			math.divide(20, 0);
//		});
//	}
	// if junit testing shows failure,it means,test case failure,it it shows
	// error,code is not working
}
