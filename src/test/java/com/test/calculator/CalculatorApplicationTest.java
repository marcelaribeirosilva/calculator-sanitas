package com.test.calculator;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.test.calculator.controller.CalculatorController;
import com.test.calculator.service.CalculatorService;
import com.test.calculator.service.impl.CalculatorServiceImpl;

@WebMvcTest(CalculatorController.class)
public class CalculatorApplicationTest {

	
	@MockBean
	private CalculatorService calculatorService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();

	@Test
	public void testSum_OK() throws Exception {
		
		calculatorService = new CalculatorServiceImpl();

		Long number1 = Long.valueOf(2);
		Long number2 = Long.valueOf(3);

		assertTrue(calculatorService.sum(number1, number2) == 5, () -> "Sum should be equal to 5");

	}

	@Test
	public void testSumUrl_OK() throws Exception {
		Long number1 = Long.valueOf(1);
		Long number2 = Long.valueOf(2);
		Long result = Long.valueOf(3);

		Mockito.when(calculatorService.sum(number1, number2)).thenReturn(result);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculator/sum/1/2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Sum Result")));

	}

	@Test
	public void testSum_KO_400() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/calculator/sum/a/b").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest()).andExpect(content().string(containsString("Message")));

	}

}