package com.tlquick.models;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import com.tlquick.pokie.models.Line;

public class LineTests {

	@Test
	void testLine() {
		Line line = new Line(1);
		assertEquals(200, line.payOff());
	}
}