package com.github.hadesfranklyn.project.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.hadesfranklyn.project.converters.NumberConverted;
import com.github.hadesfranklyn.project.exceptions.UnsupportedMathOperationException;
import com.github.hadesfranklyn.project.math.SimpleMath;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();

	private SimpleMath math = new SimpleMath();

	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverted.isNumeric(numberOne) || !NumberConverted.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}

		return math.sum(NumberConverted.convertToDouble(numberOne), NumberConverted.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverted.isNumeric(numberOne) || !NumberConverted.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}

		return math.subtraction(NumberConverted.convertToDouble(numberOne), NumberConverted.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverted.isNumeric(numberOne) || !NumberConverted.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}

		return math.multiplication(NumberConverted.convertToDouble(numberOne),
				NumberConverted.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverted.isNumeric(numberOne) || !NumberConverted.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}

		return math.division(NumberConverted.convertToDouble(numberOne), NumberConverted.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverted.isNumeric(numberOne) || !NumberConverted.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}

		return math.mean(NumberConverted.convertToDouble(numberOne), NumberConverted.convertToDouble(numberTwo));
	}

	@GetMapping(value = "/squareRoot/{number}")
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {

		if (!NumberConverted.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}

		return math.squareRoot(NumberConverted.convertToDouble(number));
	}
}
