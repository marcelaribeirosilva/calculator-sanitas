package com.test.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.calculator.service.CalculatorService;

import io.corp.calculator.TracerImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	CalculatorService calculatorService;

	TracerImpl tracerAPI = new TracerImpl();

	@GetMapping(value = "/sum/{number1}/{number2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sum(@PathVariable Long number1, @PathVariable Long number2) {
		HttpHeaders headers = new HttpHeaders();

		Long sumResult = calculatorService.sum(number1, number2);

		tracerAPI.trace("\"Sum Result\": " + sumResult);

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body("{\"Sum Result\": " + sumResult + "}");
	}

	@GetMapping(value = "/subtract/{number1}/{number2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> subtract(@PathVariable Long number1, @PathVariable Long number2) {
		HttpHeaders headers = new HttpHeaders();

		Long subtractReult = calculatorService.subtract(number1, number2);

		tracerAPI.trace("\"Subtract Result\": " + subtractReult);

		return ResponseEntity.status(HttpStatus.OK).headers(headers)
				.body("{\"Subtract Result\": " + subtractReult + "}");
	}
}
