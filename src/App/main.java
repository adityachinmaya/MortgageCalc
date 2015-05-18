package App;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Mortgage Estimator");
		try {
			FXMLLoader loader = new FXMLLoader(
					main.class.getResource("Estimator.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			primaryStage.show();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			System.err.println("error");
			e.printStackTrace();
		}
	}
	public static void main(String[] args ) {
		launch(args);
	}
}


