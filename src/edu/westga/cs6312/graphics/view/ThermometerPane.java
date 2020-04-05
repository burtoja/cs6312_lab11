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

	/**
	 * Constructor for the ThermometerPane. This constructor will draw the shapes
	 * and text on the canvas which will make up the visual representation of the
	 * Thermometer.
	 *
	 * @param userThermometer the Thermometer object set up using data from the data
	 *                        file
	 *
	 * @precondition userThermometer != null
	 *
	 * @postcondition pane created with visual representation of thermometer
	 */
	public ThermometerPane(Thermometer userThermometer) {
		if (userThermometer == null) {
			throw new IllegalArgumentException("Invalid Thermometer object");
		}
		this.userThermometer = userThermometer;
		double blackHeightProportion = (double) (this.userThermometer.getMaximumTemperature()
				- this.userThermometer.getCurrentTemperature())
				/ (this.userThermometer.getMaximumTemperature() - this.userThermometer.getMinimumTemperature());
		int radius = 40;

		this.drawBulb(radius);
		this.drawRedRectangle(radius);
		this.drawBlackRectangle(radius, blackHeightProportion);
		this.drawBottomLine(radius);
		this.drawCurrentLine(radius, blackHeightProportion);
		this.drawTopLine(radius);
		this.drawBottomLineLabel(radius, blackHeightProportion);
		this.drawCurrentLineLabel(radius, blackHeightProportion);
		this.drawTopLineLabel(radius);
	}

	/**
	 * Helper method to draw the bulb of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * 
	 * @precondition radius != null (no check required)
	 */
	private void drawBulb(int radius) {
		Circle bulb = new Circle();
		bulb.centerXProperty().bind(this.widthProperty().divide(2));
		bulb.centerYProperty().bind(this.heightProperty().multiply(0.75));
		bulb.setRadius(radius);
		bulb.setFill(Color.RED);
		this.getChildren().add(bulb);
	}

	/**
	 * Helper method to draw the red rectangle of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * 
	 * @precondition radius != null (no check required)
	 */
	private void drawRedRectangle(int radius) {
		Rectangle redRectangle = new Rectangle();
		redRectangle.layoutXProperty().bind(this.widthProperty().divide(2).subtract(radius / 2));
		redRectangle.layoutYProperty().bind(this.heightProperty().multiply(0.125));
		redRectangle.setWidth(radius);
		redRectangle.heightProperty().bind(this.heightProperty().multiply(0.625));
		redRectangle.setFill(Color.RED);
		this.getChildren().add(redRectangle);
	}

	/**
	 * Helper method to draw the black rectangle of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * @param blackHeightProportion	proportion of black to total length of actual thermometer
	 * 
	 * @precondition radius != null && blackHeightProportion != null (no check required)
	 */
	private void drawBlackRectangle(int radius, double blackHeightProportion) {
		Rectangle blackRectangle = new Rectangle();
		blackRectangle.layoutXProperty().bind(this.widthProperty().divide(2).subtract(radius / 2));
		blackRectangle.layoutYProperty().bind(this.heightProperty().multiply(0.125));
		blackRectangle.setWidth(radius);
		blackRectangle.heightProperty().bind(
				this.heightProperty().multiply(0.625 * blackHeightProportion).subtract(radius * blackHeightProportion));
		blackRectangle.setFill(Color.BLACK);
		this.getChildren().add(blackRectangle);
	}

	/**
	 * Helper method to draw the bottom line of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * 
	 * @precondition radius != null 
	 */
	private void drawBottomLine(int radius) {
		Line bottomLine = new Line();
		bottomLine.startXProperty().bind(this.widthProperty().divide(2).subtract(radius / 2));
		bottomLine.startYProperty().bind(this.heightProperty().multiply(0.75).subtract(radius));
		bottomLine.endXProperty().bind(this.widthProperty().divide(2).add(radius / 2));
		bottomLine.endYProperty().bind(this.heightProperty().multiply(0.75).subtract(radius));
		bottomLine.setStroke(Color.BLUE);
		this.getChildren().add(bottomLine);
	}

	/**
	 * Helper method to draw the current line of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * 
	 * @precondition radius != null 
	 */
	private void drawCurrentLine(int radius, double blackHeightProportion) {
		Line currentLine = new Line();
		currentLine.startXProperty().bind(this.widthProperty().divide(2).subtract(radius / 2));
		currentLine.startYProperty().bind(this.heightProperty().multiply(0.625 * blackHeightProportion + 0.125)
				.subtract(radius * blackHeightProportion));
		currentLine.endXProperty().bind(this.widthProperty().divide(2).add(radius / 2));
		currentLine.endYProperty().bind(this.heightProperty().multiply(0.625 * blackHeightProportion + 0.125)
				.subtract(radius * blackHeightProportion));
		currentLine.setStroke(Color.BLUE);
		this.getChildren().add(currentLine);
	}

	/**
	 * Helper method to draw the top line of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * 
	 * @precondition radius != null 
	 */
	private void drawTopLine(int radius) {
		Line topLine = new Line();
		topLine.startXProperty().bind(this.widthProperty().divide(2).subtract(radius / 2));
		topLine.startYProperty().bind(this.heightProperty().multiply(0.125));
		topLine.endXProperty().bind(this.widthProperty().divide(2).add(radius / 2));
		topLine.endYProperty().bind(this.heightProperty().multiply(0.125));
		topLine.setStroke(Color.BLUE);
		this.getChildren().add(topLine);
	}

	/**
	 * Helper method to draw the bottom line label rectangle of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * @param blackHeightProportion	proportion of black to total length of actual thermometer
	 * 
	 * @precondition radius != null && blackHeightProportion != null (no check required)
	 */
	private void drawBottomLineLabel(int radius, double blackHeightProportion) {
		Text bottomLineLabel = new Text();
		bottomLineLabel.xProperty().bind(this.widthProperty().divide(2).subtract(radius + 10));
		bottomLineLabel.yProperty().bind(this.heightProperty().multiply(0.75).subtract(radius - 7));
		bottomLineLabel.setText(Integer.toString(this.userThermometer.getMinimumTemperature()));
		bottomLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(bottomLineLabel);
	}

	/**
	 * Helper method to draw the current line label rectangle of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * @param blackHeightProportion	proportion of black to total length of actual thermometer
	 * 
	 * @precondition radius != null && blackHeightProportion != null (no check required)
	 */
	private void drawCurrentLineLabel(int radius, double blackHeightProportion) {
		Text currentLineLabel = new Text();
		currentLineLabel.xProperty().bind(this.widthProperty().divide(2).add(radius - 10));
		currentLineLabel.yProperty().bind(this.heightProperty().multiply(0.625 * blackHeightProportion + 0.125)
				.subtract(radius * blackHeightProportion - 7));
		currentLineLabel.setText(Integer.toString(this.userThermometer.getCurrentTemperature()));
		currentLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(currentLineLabel);
	}

	/**
	 * Helper method to draw the top line label rectangle of the thermometer
	 * 
	 * @param radius the radius of the bulb (and width of the thermometer)
	 * @param blackHeightProportion	proportion of black to total length of actual thermometer
	 * 
	 * @precondition radius != null && blackHeightProportion != null (no check required)
	 */
	private void drawTopLineLabel(int radius) {
		Text topLineLabel = new Text();
		topLineLabel.xProperty().bind(this.widthProperty().divide(2).subtract(radius + 10));
		topLineLabel.yProperty().bind(this.heightProperty().multiply(0.125).add(7));
		topLineLabel.setText(Integer.toString(this.userThermometer.getMaximumTemperature()));
		topLineLabel.setFont(Font.font("Courier", 15));
		this.getChildren().add(topLineLabel);
	}
}
