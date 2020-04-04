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
		double blackHeightMultiplier = 0.7 * blackHeight / thermometerHeight;
		double redHeightMultiplier = 0.7 * redHeight / thermometerHeight;
		double midpointMultiplier = 0.1 + blackHeightMultiplier;
		int xPosition = 50;
		int yPosition = 50;
		int width = 50;
		int radius = width;
		int textOffset = width + 10;

		Rectangle blackRectangle = new Rectangle();
		blackRectangle.layoutXProperty().bind(this.widthProperty().divide(2).subtract(width / 2));
		blackRectangle.layoutYProperty().bind(this.heightProperty().multiply(0.1));
		blackRectangle.setWidth(width);
		blackRectangle.heightProperty().bind(this.heightProperty().multiply(blackHeightMultiplier));
		blackRectangle.setFill(Color.BLACK);
		this.getChildren().add(blackRectangle);

		Rectangle redRectangle = new Rectangle();
		redRectangle.layoutXProperty().bind(this.widthProperty().divide(2).subtract(width / 2));
		redRectangle.layoutYProperty().bind(this.heightProperty().multiply(midpointMultiplier));
		redRectangle.setWidth(width);
		redRectangle.heightProperty().bind(this.heightProperty().multiply(redHeightMultiplier));
		redRectangle.setFill(Color.RED);
		this.getChildren().add(redRectangle);
		
		Circle bulb = new Circle();
		bulb.centerXProperty().bind(this.widthProperty().divide(2));
		bulb.centerYProperty().bind(this.heightProperty().multiply(0.8));
		bulb.setRadius(radius);
		bulb.setFill(Color.RED);
		this.getChildren().add(bulb);

		Line bottomLine = new Line();
		bottomLine.startXProperty().bind(this.widthProperty().divide(2).subtract(width / 2));
		bottomLine.startYProperty().bind(this.heightProperty().multiply(0.8).subtract(radius));        
		bottomLine.endXProperty().bind(this.widthProperty().divide(2).add(width / 2));
		bottomLine.endYProperty().bind(this.heightProperty().multiply(0.8).subtract(radius)); 
		bottomLine.setStroke(Color.BLUE);
		this.getChildren().add(bottomLine);

		Line currentLine = new Line(xPosition, (yPosition + blackHeight), (xPosition + width),
				(yPosition + blackHeight));
		currentLine.startXProperty().bind(this.widthProperty().divide(2).subtract(width / 2));
		currentLine.startYProperty().bind(this.heightProperty().multiply(midpointMultiplier));        
		currentLine.endXProperty().bind(this.widthProperty().divide(2).add(width / 2));
		currentLine.endYProperty().bind(this.heightProperty().multiply(midpointMultiplier)); 
		currentLine.setStroke(Color.BLUE);
		this.getChildren().add(currentLine);

		Line topLine = new Line();
		topLine.startXProperty().bind(this.widthProperty().divide(2).subtract(width / 2));
		topLine.startYProperty().bind(this.heightProperty().multiply(0.1));        
		topLine.endXProperty().bind(this.widthProperty().divide(2).add(width / 2));
		topLine.endYProperty().bind(this.heightProperty().multiply(0.1)); 
		topLine.setStroke(Color.BLUE);
		topLine.setStroke(Color.BLUE);
		this.getChildren().add(topLine);

		Text bottomLineLabel = new Text();
		bottomLineLabel.xProperty().bind(this.widthProperty().divide(2).subtract(textOffset));
		bottomLineLabel.yProperty().bind(this.heightProperty().multiply(0.8).subtract(radius)); 
		bottomLineLabel.setText(Integer.toString(this.userThermometer.getMinimumTemperature()));
		bottomLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(bottomLineLabel);
		
		Text currentLineLabel = new Text();
		currentLineLabel.xProperty().bind(this.widthProperty().divide(2).add(textOffset / 2));
		currentLineLabel.yProperty().bind(this.heightProperty().multiply(midpointMultiplier)); 
		currentLineLabel.setText(Integer.toString(this.userThermometer.getCurrentTemperature()));
		currentLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(currentLineLabel);
		
		Text topLineLabel = new Text();
		topLineLabel.xProperty().bind(this.widthProperty().divide(2).subtract(textOffset));
		topLineLabel.yProperty().bind(this.heightProperty().multiply(0.1)); 
		topLineLabel.setText(Integer.toString(this.userThermometer.getMaximumTemperature()));
		topLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(topLineLabel);


		// TODO: test files for other classes
		// TODO: test what happens if data file has too much/little/bad data

	}

}
