package com.tlquick.controllers;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tlquick.pokie.PokieApplication;
import com.tlquick.pokie.controllers.PokieController;

@SpringBootTest
@ContextConfiguration(classes = PokieApplication.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PokieControllerTests {

	@Autowired
	PokieController controller;

	@Test
	void testPokieController_Index() {

		assertNotNull(controller.viewHomePage());
	}

	@Test
	void testPokieController_AddCredit() {

		assertNotNull(controller.addCredit());
	}

	@Test
	void testPokieController_Collect() {

		assertNotNull(controller.collect());
	}
	@Test
	void testPokieCredits() {
		
		assertNotNull(controller.credits(1));
	}
	@Test
	void testPokieApplicationLines() {
		
		assertNotNull(controller.lines(1));
	}
	public static void afterclass() {
		System.out.println("after class");
	}
}
