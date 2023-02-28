package com.tlquick.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tlquick.pokie.PokieApplication;
import com.tlquick.pokie.models.Pokie;

@SpringBootTest
@ContextConfiguration(classes = PokieApplication.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PokieTests {

	@Autowired
	Pokie pokie;

	@Test
	void testPokie_BetSpin() {
		pokie.addCredit(100);
		pokie.bet(1);
		pokie.betLines(3);
		pokie.spin();
		assertEquals(12, pokie.getResult().length());
		assertEquals(1, pokie.getSpins());
		assertEquals(3, pokie.turnover());
	}

	@Test
	void testPokie_Payout() {
		pokie.payOut();
		assertEquals("Congratulations! You won $200", pokie.getMsg());
	}

	@Test
	void testPokie_toString() {
		pokie.addCredit(100);
		pokie.bet(1);
		pokie.betLines(3);
		pokie.spin();
		assertEquals(
				"Cherry Bomb: payouts = $0.0 turnover = $3.0 spins = 1\nPlayer: bet $1.0 balance $97.0 games played 1",
				pokie.toString());

	}
}
