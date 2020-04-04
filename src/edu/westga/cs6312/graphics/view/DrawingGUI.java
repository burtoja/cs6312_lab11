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
	
	public DrawingGUI() {
		File userFile = new File("temperatures.txt");
		Scanner inFile = null;
		try {
			inFile = new Scanner(userFile);
			while (inFile.hasNext()) {
				String input = inFile.nextLine();
			}
			inFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Data file does not exist.");
		} catch (NoSuchElementException nsee) {
			System.out.println("Read past the end of the file.");
			inFile.close();
		}		
	}
	
}
