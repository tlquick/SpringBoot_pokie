package com.tlquick.models;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tlquick.pokie.PokieApplication;
import com.tlquick.pokie.models.Reel;

@SpringBootTest
@ContextConfiguration(classes = PokieApplication.class)
@ExtendWith(SpringExtension.class)
public class ReelTests {

	@Test
	void testReel() {
		Reel reel = new Reel(1, 1);
		reel.spin();
		assertThat(reel.getResult(0), anyOf(is("J"), is("C"), is("O"), is("L")));
	}
}
