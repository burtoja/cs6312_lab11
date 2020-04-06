package edu.westga.cs6312.graphics.controller;

import edu.westga.cs6312.graphics.view.DrawingGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This class will serve as the driver for the Thermometer application
 * 
 * @author J. Allen Burton
 * @version Apr 3, 2020
 *
 */
public class GraphicsDriver extends Application {

	/**
	 * This method creates and displays an appropriate GUI
	 * 
	 * @param primaryStage
	 *
	 * @precondition primaryStage != null
	 *
	 * @postcondition DrawingGUI, Pane, Scene objects created
	 * 
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			DrawingGUI userDrawingGUI = new DrawingGUI();
			Pane pane = userDrawingGUI.getThermometerPane();
			Scene scene = new Scene(pane, 400, 400);
			primaryStage.setTitle("Thermometer");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("Unable to create thermometer diagram.");
		}
	}

	/**
	 * This method is the entry point of the application
	 *
	 * @param args Command-line arguments, not used
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
