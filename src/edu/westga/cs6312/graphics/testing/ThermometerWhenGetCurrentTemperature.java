package edu.westga.cs6312.graphics.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.graphics.model.Thermometer;

/**
 * This will serve to test the getCurrentTemperature method of the Thermometer
 * class
 * 
 * @author J. Allen Burton
 * @version Apr 5, 2020
 *
 */
public class ThermometerWhenGetCurrentTemperature {

	/**
	 * Test getCurrentTemperature method from the Temperature class
	 * 
	 * Expect: 50
	 */
	@Test
	public void testGetCurrentTemperatureExpect50() {
		Thermometer theThermometer = new Thermometer(32, 212, 50);
		int report = theThermometer.getCurrentTemperature();
		assertEquals(50, report);
	}
	
	/**
	 * Test getCurrentTemperature method from the Temperature class when zero
	 * 
	 * Expect: 0
	 */
	@Test
	public void testGetCurrentTemperatureExpect0() {
		Thermometer theThermometer = new Thermometer(-273, 100, 0);
		int report = theThermometer.getCurrentTemperature();
		assertEquals(0, report);
	}

	/**
	 * Test getCurrentTemperature method from the Temperature class with a negative
	 * current temperature 
	 * 
	 * Expect: -100
	 */
	@Test
	public void testGetCurrentTemperatureExpectNeg100() {
		Thermometer theThermometer = new Thermometer(-273, 0, -100);
		int report = theThermometer.getCurrentTemperature();
		assertEquals(-100, report);
	}

}

