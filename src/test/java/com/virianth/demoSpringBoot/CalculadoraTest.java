package com.virianth.demoSpringBoot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

//@RunWith(value = Parameterized.class)
public class CalculadoraTest {

	/*private int a, b, res;

	public void CalculadoraTest(int a, int b, int res) {
		this.a = a;
		this.b = b;
		this.res = res;
	}

	@Parameterized.Parameters
	public static Iterable<Object[]> getData() {
		return Arrays.asList(new Object[][] {
				{3, 1, 4},
				{2, 3, 5},
				{3, 3, 5}
		});
	}
*/
	@Test
	void simpleOne() {
		//fail("Not yet implemented");
		assert(1 == 1);
	}

	static Stream<Arguments> intArrayProvider() {
		return Stream.of(
				Arguments.of((Object) new Integer[]{3, 1, 4}),
				Arguments.of((Object) new Integer[]{1, 2, 3})
		);
	}
	@ParameterizedTest
	@MethodSource("intArrayProvider")
	void contextLoads(Integer[] nums) {
		//fail("Not yet implemented");
		assert(1 == 1);
		assert(nums[0] + nums[1] == nums[2]);
	}


	static Stream<Arguments> objectsArrayProvider() {
		return Stream.of(
				arguments(2, 2, true),
				arguments(3, 1, false)
		);
	}
	@ParameterizedTest
	@MethodSource("objectsArrayProvider")
	void contextLoadsObjects(int a, int b, boolean same) {
		//fail("Not yet implemented");
		assert(1 == 1);
		assert((a == b) == same);
	}

}
