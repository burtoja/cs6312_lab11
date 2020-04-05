package edu.westga.cs6312.graphics.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.graphics.model.Thermometer;

/**
 * This will serve to test the getMinimumTemperature method of the Thermometer
 * class
 * 
 * @author J. Allen Burton
 * @version Apr 5, 2020
 *
 */
public class ThermometerWhenGetMinimumTemperature {

	/**
	 * Test getMinimumTemperature method from the Temperature class
	 * 
	 * Expect: 32
	 */
	@Test
	public void testGetMinimumTemperatureExpect32() {
		Thermometer theThermometer = new Thermometer(32, 212, 50);
		int report = theThermometer.getMinimumTemperature();
		assertEquals(32, report);
	}

	/**
	 * Test getMinimumTemperature method from the Temperature class when zero
	 * 
	 * Expect: 0
	 */
	@Test
	public void testGetMinimumTemperatureExpect0() {
		Thermometer theThermometer = new Thermometer(0, 100, 50);
		int report = theThermometer.getMinimumTemperature();
		assertEquals(0, report);
	}

	/**
	 * Test getMinimumTemperature method from the Temperature class with a negative
	 * minimum temperature
	 * 
	 * Expect: -273
	 */
	@Test
	public void testGetMinimumTemperatureExpectNeg273() {
		Thermometer theThermometer = new Thermometer(-273, 100, 50);
		int report = theThermometer.getMinimumTemperature();
		assertEquals(-273, report);
	}

}
