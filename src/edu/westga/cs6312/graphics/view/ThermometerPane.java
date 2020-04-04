package edu.westga.cs6312.graphics.view;

import edu.westga.cs6312.graphics.model.Thermometer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * THis class will create the thermometer pane
 * 
 * @author J. Allen Burton
 * @version Apr 3, 2020
 *
 */
public class ThermometerPane extends Pane {
	private Thermometer userThermometer;

	public ThermometerPane(Thermometer userThermometer) {
		this.userThermometer = userThermometer;
		int thermometerHeight = this.userThermometer.getMaximumTemperature()
				- this.userThermometer.getMinimumTemperature();
		int redHeight = this.userThermometer.getCurrentTemperature() - this.userThermometer.getMinimumTemperature();
		int blackHeight = this.userThermometer.getMaximumTemperature() - this.userThermometer.getCurrentTemperature();
		int xPosition = 50;
		int yPosition = 50;
		int width = 50;
		int radius = width;
		int textOffset = 25;

		Rectangle blackRectangle = new Rectangle(xPosition, yPosition, width, blackHeight);
		blackRectangle.setFill(Color.BLACK);
		this.getChildren().add(blackRectangle);

		Rectangle redRectangle = new Rectangle(xPosition, (yPosition + blackHeight), width, (redHeight + radius));
		redRectangle.setFill(Color.RED);
		this.getChildren().add(redRectangle);

		Line bottomLine = new Line(xPosition, (yPosition + thermometerHeight), (xPosition + width),
				(yPosition + thermometerHeight));
		bottomLine.setStroke(Color.BLUE);
		this.getChildren().add(bottomLine);

		Line currentLine = new Line(xPosition, (yPosition + blackHeight), (xPosition + width),
				(yPosition + blackHeight));
		currentLine.setStroke(Color.BLUE);
		this.getChildren().add(currentLine);

		Line topLine = new Line(xPosition, yPosition, (xPosition + width), yPosition);
		topLine.setStroke(Color.BLUE);
		this.getChildren().add(topLine);

		Circle bulb = new Circle((xPosition + (width / 2)), (yPosition + thermometerHeight + radius), radius);
		bulb.setFill(Color.RED);
		this.getChildren().add(bulb);

		Text bottomLineLabel = new Text((xPosition - textOffset), (yPosition + thermometerHeight), Integer.toString(this.userThermometer.getMinimumTemperature()));
		bottomLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(bottomLineLabel);
		
		Text currentLineLabel = new Text((xPosition + width + textOffset), (yPosition + blackHeight), Integer.toString(this.userThermometer.getCurrentTemperature()));
		currentLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(currentLineLabel);
		
		Text topLineLabel = new Text((xPosition - textOffset), yPosition, Integer.toString(this.userThermometer.getMaximumTemperature()));
		topLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(topLineLabel);

		// TODO: Use min/max/curr to make the two rectangles
		// TODO: Make circle a static radius
		// TODO: use binding to set up relative positioning as desired
		// TODO: display numbers and scale lines
		// TODO: test files for other classes
		// TODO: test what happens if data file has too much/little/bad data

	}

}
