package edu.westga.cs6312.graphics.controller;

import edu.westga.cs6312.graphics.view.DrawingGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *  This class will serve as the driver for the Thermometer application
 *  
 * @author J. Allen Burton
 * @version Apr 3, 2020
 *
 */
public class GraphicsDriver extends Application {
	
	/**
	 * This method create and display an appropriate GUI
	 * 
	 * @param primaryStage
	 *
	 * @precondition
	 *
	 * @postcondition
	 */
	@Override
	public void start(Stage primaryStage) {
			DrawingGUI userDrawingGUI = new DrawingGUI();
			Pane pane = userDrawingGUI.getThermometerPane();
		
			Scene scene = new Scene(pane, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	/**
	* This method is the entry point of the application
	*
	* @param args Command-line arguments, not used
	*/
	public static void main(String [] args) {
		launch(args);
	}	

}
