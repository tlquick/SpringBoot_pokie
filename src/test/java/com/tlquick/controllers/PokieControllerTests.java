package com.tlquick.controllers;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tlquick.pokie.PokieApplication;
import com.tlquick.pokie.models.Pokie;
import com.tlquick.pokie.services.PokieService;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.*;
@SpringBootTest(classes = PokieApplication.class)
@AutoConfigureMockMvc
class PokieControllerTests {

    @MockBean
    private PokieService service;

    @Autowired
    private MockMvc mockMvc;
    
    private Pokie pokie = new Pokie(1);


	@Test
	void testPokieController_Index() throws Exception {
		//return the pokie object data through the mocked interface
		Mockito.when(service.getPokie()).thenReturn(Optional.of(pokie));
		 mockMvc.perform(MockMvcRequestBuilders
	                .get("/index")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$", notNullValue()));
	}

	@Test
	void testPokieController_AddCredit()  throws Exception{
		Mockito.when(service.getPokie()).thenReturn(Optional.of(pokie));
		 mockMvc.perform(MockMvcRequestBuilders
	                .get("/addCredit")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$", notNullValue()));
	}

	@Test
	void testPokieController_Collect() throws Exception{
		Mockito.when(service.getPokie()).thenReturn(Optional.of(pokie));
		 mockMvc.perform(MockMvcRequestBuilders
	                .get("/collect")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$", notNullValue()));
	}
	@Test
	void testPokieController_Credits() throws Exception{
		Mockito.when(service.getPokie()).thenReturn(Optional.of(pokie));
		 mockMvc.perform(MockMvcRequestBuilders
	                .get("/credits/1")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$", notNullValue()));
	}
	@Test
	void testPokieController_Lines() throws Exception{
		Mockito.when(service.getPokie()).thenReturn(Optional.of(pokie));
		 mockMvc.perform(MockMvcRequestBuilders
	                .get("/lines/1")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$", notNullValue()));
	}
	public static void afterclass() {
		System.out.println("after class");
	}
}
