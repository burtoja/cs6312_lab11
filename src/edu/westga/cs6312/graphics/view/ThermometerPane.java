package edu.westga.cs6312.graphics.view;

import edu.westga.cs6312.graphics.model.Thermometer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * THis class will create the thermometer pane
 * 
 * @author J. Allen Burton
 * @version Apr 3, 2020
 *
 */
public class ThermometerPane extends Pane{
	private Thermometer userThermometer;
	
	public ThermometerPane(Thermometer userThermometer) {
		this.userThermometer = userThermometer;
		//TODO: Use min/max/curr to make the two rectangles
		//TODO: Make circle a static radius
		//TODO: use binding to set up relative positioning as desired
		//TODO: display numbers and scale lines
		//TODO: test files for other classes
		//TODO: test what happens if data file has too much/little/bad data
		Circle bulb = new Circle(this.userThermometer.getMaximumTemperature(), this.userThermometer.getCurrentTemperature(), this.userThermometer.getMinimumTemperature());
		bulb.setFill(Color.RED);
		this.getChildren().add(bulb);
	}
	
}
