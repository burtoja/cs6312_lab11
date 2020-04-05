package edu.westga.cs6312.graphics.view;

import java.io.File;
import java.io.FileNotFoundException;
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
	 * 
	 * Constructor for DrawingGUI
	 *
	 *
	 * @precondition
	 *
	 * @postcondition
	 */
	public DrawingGUI() {
		this.createThermometerPane(this.readData());
	}

	/**
	 * 
	 * @return
	 *
	 * @precondition
	 *
	 * @postcondition
	 */
	public ThermometerPane getThermometerPane() {
		return this.userThermometerPane;
	}

	/**
	 * Helper method to open and read data from the temperatures.txt file. This
	 * method returns an array with the following data element order:
	 * 
	 * [minimumTemperature, currentTemperature, maximumTemperature]
	 * 
	 * @return array of minimumTemperature, currentTemperature, and
	 *         maximumTemperature as read from the temperatures.txt file
	 * 
	 * @precondition
	 * 
	 * @postcondition
	 */
	private int[] readData() {
		File userFile = new File("temperatures.txt");
		Scanner inFile = null;
		int[] dataArray = new int[3];
		try {
			inFile = new Scanner(userFile);
			int dataLineNumber = 0;
			while (inFile.hasNext()) {
				dataArray[dataLineNumber] = Integer.parseInt(inFile.nextLine());
				dataLineNumber++;
			}
			if (dataLineNumber < 3) {
				System.out.println("Too few entries in data file.");
			}
			inFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Data file does not exist.");
		} catch (NoSuchElementException nsee) {
			System.out.println("Too few entries in data file. Read past the end of the file.");
			inFile.close();
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("Too many entries in data file.");
			inFile.close();
			dataArray = null;
		}		
		return dataArray;
	}

	private void createThermometerPane(int[] temperatureDataArray) {
		int minimumTemperature = temperatureDataArray[0];
		int currentTemperature = temperatureDataArray[1];
		int maximumTemperature = temperatureDataArray[2];
		this.userThermometer = new Thermometer(minimumTemperature, maximumTemperature, currentTemperature);
		this.userThermometerPane = new ThermometerPane(this.userThermometer);
	}

}
