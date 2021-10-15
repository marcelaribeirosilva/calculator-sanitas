package com.test.calculator.service;

public interface CalculatorService {

	/**
	 * Method responsible for adding two numbers
	 * 
	 * @param number1
	 * @param number2
	 * @return the sum result
	 */
	Long sum(Long number1, Long number2);

	/**
	 * Method responsible for subtracting two numbers
	 * 
	 * @param number1
	 * @param number2
	 * @return the subtraction result
	 */
	Long subtract(Long number1, Long number2);

}