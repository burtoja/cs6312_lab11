package edu.westga.cs6312.graphics.model;

/**
 * This class will model a thermometer using a user-defined minimum and maximum
 * temperatures for the scale. Thus the thermometer could be representing
 * temperature in any unit system desired by the user.
 * 
 * @author J. Allen Burton
 * @version Apr 2, 2020
 *
 */
public class Thermometer {
	private int minimumTemperature;
	private int maximumTemperature;
	private int currentTemperature;

	/**
	 * Constructor for Thermometer objects
	 *
	 * @param minimumTemperature the minimum temperature that can be read by the
	 *                           thermometer
	 * @param maximumTemperature the maximum temperature that can be read by the
	 *                           thermometer
	 * @param currentTemperature the current temperature measured by the thermometer
	 *
	 * @precondition maximumTemperature > minimumTemperature
	 * @precondition currentTemperature >= minimumTemperature && currentTemperature
	 *               <=maximumTemperature
	 *
	 * @postcondition new object created with provided maximum, minimum, and current
	 *                temperature values
	 */
	public Thermometer(int minimumTemperature, int maximumTemperature, int currentTemperature) {
		if (maximumTemperature <= minimumTemperature) {
			throw new IllegalArgumentException("Maximum temperature must be greater than minimum temperature");
		}
		if (currentTemperature < minimumTemperature || currentTemperature > maximumTemperature) {
			throw new IllegalArgumentException(
					"Current temperature must fall between (inclusive) minimum and maximum temperatures");
		}
		this.minimumTemperature = minimumTemperature;
		this.maximumTemperature = maximumTemperature;
		this.currentTemperature = currentTemperature;
	}

	/**
	 * Method to get the value of the minimum temperature for the thermometer
	 *
	 * @return the minimum temperature
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public int getMinimumTemperature() {
		return this.minimumTemperature;
	}

	/**
	 * Method to get the value of the maximum temperature for the thermometer
	 *
	 * @return the maximum temperature
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public int getMaximumTemperature() {
		return this.maximumTemperature;
	}

	/**
	 * Method to get the value of the current temperature measured by the
	 * thermometer
	 *
	 * @return the current temperature
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public int getCurrentTemperature() {
		return this.currentTemperature;
	}
	
	/**
	 * This method will provide a string representation of the object data
	 * 
	 * @return	string representation of minimum, maximum, and current temperatures
	 *
	 * @precondition	none
	 *
	 * @postcondition	no change to object
	 */
	@Override
	public String toString() {
		return "Minimum Temperature: " + this.minimumTemperature + "\nMaximum Temperature: " + this.maximumTemperature
				+ "\nCurrent Temperature: " + this.currentTemperature;
	}

}
