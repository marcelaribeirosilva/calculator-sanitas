package com.test.calculator.service.impl;

import org.springframework.stereotype.Service;

import com.test.calculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public Long sum(Long number1, Long number2) {
		return number1 + number2;
	}

	@Override
	public Long subtract(Long number1, Long number2) {
		return number1 - number2;
	}
}
