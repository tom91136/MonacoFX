package net.kurobako.monacofx.sample;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {


	public static final class JFXApp extends Application {

		@Override public void start(Stage primaryStage) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Sampler.fxml"));
			Parent parent = loader.load();
			try {
				loader.<SamplerController>getController().hostServices = getHostServices();
			} catch (Throwable ignored) { }
			primaryStage.setTitle("MoancoPane samples");
			primaryStage.setScene(new Scene(parent));
			primaryStage.show();
		}
	}

	public static void main(String[] args) { Application.launch(JFXApp.class, args); }


}
