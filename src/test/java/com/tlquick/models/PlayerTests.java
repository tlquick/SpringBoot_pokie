package com.tlquick.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tlquick.pokie.PokieApplication;
import com.tlquick.pokie.models.Player;
import com.tlquick.pokie.models.Pokie;

@SpringBootTest
@ContextConfiguration(classes = PokieApplication.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PlayerTests {
	@Autowired
	private Pokie pokie;

	@Test
	void testPlayerInit() {
		Player player = pokie.getPlayer();
		assertNotNull(player);
		assertEquals(0.0, player.getBalance());
		assertThat(player.toString(), equalTo("Player: bet $1.0 balance $0.0 games played 0"));
	}

	@Test
	void testPlayerBalance() {
		Player player = pokie.getPlayer();
		assertEquals(0.0, player.getBalance());
		player.updateBalance(100);
		assertEquals(100.0, player.getBalance());
		player.collect();
		assertEquals(0.0, player.getBalance());

	}

	@Test
	void testPlayerBet() {
		Player player = pokie.getPlayer();
		player.setBet(1);
		assertEquals(1.0, player.getBet());
		assertFalse(player.canBet(1));
		player.updateBalance(100);
		assertTrue(player.canBet(1));
		player.placeBet(1);
		assertThat(player.toString(), equalTo("Player: bet $1.0 balance $99.0 games played 1"));
	}
}
