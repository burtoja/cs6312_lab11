package edu.westga.cs6312.graphics.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.graphics.model.Thermometer;

/**
 * This will serve to test the getMaximumTemperature method of the Thermometer
 * class
 * 
 * @author J. Allen Burton
 * @version Apr 5, 2020
 *
 */
public class ThermometerWhenGetMaximumTemperature {

	/**
	 * Test getMaximumTemperature method from the Temperature class
	 * 
	 * Expect: 212
	 */
	@Test
	public void testGetMaximumTemperatureExpect212() {
		Thermometer theThermometer = new Thermometer(32, 212, 50);
		int report = theThermometer.getMaximumTemperature();
		assertEquals(212, report);
	}

	/**
	 * Test getMaximumTemperature method from the Temperature class when zero
	 * 
	 * Expect: 0
	 */
	@Test
	public void testGetMaximumTemperatureExpect0() {
		Thermometer theThermometer = new Thermometer(-273, 0, -50);
		int report = theThermometer.getMaximumTemperature();
		assertEquals(0, report);
	}

	/**
	 * Test getMaximumTemperature method from the Temperature class with a negative
	 * maximum temperature
	 * 
	 * Expect: -100
	 */
	@Test
	public void testGetMaximumTemperatureExpectNeg100() {
		Thermometer theThermometer = new Thermometer(-273, -100, -150);
		int report = theThermometer.getMaximumTemperature();
		assertEquals(-100, report);
	}

}
