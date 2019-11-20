package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class M2_fxml extends Application{
	@Override
    public void start(Stage primaryStage) throws Exception {
        try {
             //这里的root从FXML文件中加载进行初始化，这里FXMLLoader类用于加载FXML文件
        	Application.setUserAgentStylesheet(getClass().getResource("application2.css")
        	        .toExternalForm());
            TabPane tabPane = (TabPane)FXMLLoader.load(getClass().getResource("/application/M2.fxml"));
            
            Scene scene = new Scene(tabPane, 900, 900);
            
            primaryStage.setScene(scene);
            
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}