package edu.westga.cs6312.graphics.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.graphics.model.Thermometer;

/**
 * This class will serve to test the Thermometer class constructor and toString
 * method
 * 
 * @author J. Allen Burton
 * @version Apr 2, 2020
 *
 */
public class ThermometerWhenCreateThermometer {

	/**
	 * Test normal temperatures in creating Thermometer
	 * 
	 * Minimum: 0 Maximum: 100 Current: 50
	 */
	@Test
	public void testCreateThermometerExpectMin0Max100Current50() {
		Thermometer theThermometer = new Thermometer(0, 100, 50);
		String report = theThermometer.toString();
		String expected = "Minimum Temperature: 0\nMaximum Temperature: 100\nCurrent Temperature: 50";
		assertEquals(expected, report);
	}

	/**
	 * Test negative temperatures in creating Thermometer
	 * 
	 * Minimum: -273 Maximum: 0 Current: -50
	 */
	@Test
	public void testCreateThermometerExpectMinNeg273Max0CurrentNeg50() {
		Thermometer theThermometer = new Thermometer(-273, 0, -50);
		String report = theThermometer.toString();
		String expected = "Minimum Temperature: -273\nMaximum Temperature: 0\nCurrent Temperature: -50";
		assertEquals(expected, report);
	}

	/**
	 * Test current temperature at minimum value temperatures in creating
	 * Thermometer
	 * 
	 * Minimum: 32 Maximum: 212 Current: 32
	 */
	@Test
	public void testCreateThermometerExpectMin32Max212Current32() {
		Thermometer theThermometer = new Thermometer(32, 212, 32);
		String report = theThermometer.toString();
		String expected = "Minimum Temperature: 32\nMaximum Temperature: 212\nCurrent Temperature: 32";
		assertEquals(expected, report);
	}

	/**
	 * Test current temperature at maximum value temperatures in creating
	 * Thermometer
	 * 
	 * Minimum: 32 Maximum: 212 Current: 212
	 */
	@Test
	public void testCreateThermometerExpectMin32Max212Current212() {
		Thermometer theThermometer = new Thermometer(32, 212, 212);
		String report = theThermometer.toString();
		String expected = "Minimum Temperature: 32\nMaximum Temperature: 212\nCurrent Temperature: 212";
		assertEquals(expected, report);
	}

}
