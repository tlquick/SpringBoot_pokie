package com.tlquick.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tlquick.pokie.models.Line;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LineTests {

	@Test
	void testLine() {
		Line line = new Line(1);
		assertEquals(200, line.payOff());
	}
}