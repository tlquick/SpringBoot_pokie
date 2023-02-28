package com.tlquick.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.tlquick.pokie.models.Lines;

public class LinesTests {

	@Test
	void testLines() {
		Lines lines = new Lines();
		String[][] result = lines.getResultImages();

		assertEquals(3, result.length);
		assertEquals(3, result[0].length);
	}

	@Test
	void testLinesPayoff() {
		Lines lines = new Lines();

		assertEquals(200, lines.payOff(1));

	}
}
