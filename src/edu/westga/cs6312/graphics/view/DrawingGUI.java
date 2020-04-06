package edu.westga.cs6312.graphics.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.westga.cs6312.graphics.model.Thermometer;

/**
 * This class will manage the drawing GUI for the thermometer
 * 
 * @author J. Allen Burton
 * @version Apr 3, 2020
 *
 */
public class DrawingGUI {
	private Thermometer userThermometer;
	private ThermometerPane userThermometerPane;

	/**
	 * Constructor for DrawingGUI objects. This constructor creates and
	 * ThermometerPane object based off of data provided in temperatures.txt file
	 * which holds three (and only three) integer values representing the minimum
	 * scale, current, and maximum scale temperatures each on a separate line.
	 *
	 * @precondition temperature.txt file must be available and formatted correctly
	 *
	 * @postcondition new Thermometer and ThermometerPane objects created
	 */
	public DrawingGUI() {
		this.createThermometerPane(this.readData());
	}

	/**
	 * Returns the ThermometerPane object created when this object's constructor was
	 * called.
	 * 
	 * @return ThermometerPane object created when this object's constructor was
	 *         called
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public ThermometerPane getThermometerPane() {
		return this.userThermometerPane;
	}

	/**
	 * Helper method to open and read data from the temperatures.txt file. This
	 * method returns an ArrayList of Integer objects for each line of data in the
	 * file. The validity of the data values will be checked elsewhere when used.
	 * 
	 * @return ArrayList of data read from the temperatures.txt file
	 * 
	 * @precondition temperatures.txt must be available and properly formatted
	 * 
	 * @postcondition no change to object
	 */
	private ArrayList<Integer> readData() {
		File userFile = new File("temperatures.txt");
		Scanner inFile = null;
		ArrayList<Integer> thermometerValues = new ArrayList<Integer>();
		try {
			inFile = new Scanner(userFile);
			while (inFile.hasNext()) {
				thermometerValues.add(Integer.parseInt(inFile.nextLine()));
			}
			inFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Data file does not exist.");
		} catch (NumberFormatException nfe) {
			System.out.println("An entry in the file was not a valid integer.");
			thermometerValues.add(null);
		} catch (NoSuchElementException nsee) {
			System.out.println("Read past the end of the file.");
			thermometerValues.add(null);
			inFile.close();
		}
		return thermometerValues;
	}

	/**
	 * This helper method uses the data read from the temeratures.txt file to create
	 * a Thermometer and then use that thermometer to create and ThermometerPane
	 * object.
	 * 
	 * @param thermometerValues ArrayList holding integers representing minimum
	 *                          scale value, current temperature, and maximum scale
	 *                          value (in that order)
	 *
	 * @precondition thermometerValues must have three elements. Correct order
	 *               (minimum, current, maximum) is validated in Thermometer
	 *               constructor.
	 *
	 * @postcondition new Thermometer and ThermometerPane objects created
	 */
	private void createThermometerPane(ArrayList<Integer> thermometerValues) {
		if (thermometerValues.isEmpty()) {
			throw new IllegalArgumentException("No data found in file.");
		}
		if (thermometerValues.get(thermometerValues.size() - 1) == null) {
			throw new IllegalArgumentException("Invalid data in file.");
		}
		if (thermometerValues.size() < 3) {
			throw new IllegalArgumentException("Too few valid entries in data file.");
		}
		if (thermometerValues.size() > 3) {
			throw new IllegalArgumentException("Too many entries in data file.");
		}
		int minimumTemperature = thermometerValues.get(0);
		int currentTemperature = thermometerValues.get(1);
		int maximumTemperature = thermometerValues.get(2);
		this.userThermometer = new Thermometer(minimumTemperature, maximumTemperature, currentTemperature);
		this.userThermometerPane = new ThermometerPane(this.userThermometer);
	}

}
