package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class M1_fxml extends Application{
	@Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // �����root��FXML�ļ��м��ؽ��г�ʼ��������FXMLLoader�����ڼ���FXML�ļ�
        	Application.setUserAgentStylesheet(getClass().getResource("application.css")
        	        .toExternalForm());
            StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("M1.fxml"));
            
            //Rectangle rect=(Rectangle)FXMLLoader.load(getClass().getResource("M1.fxml"));
            
            Scene scene = new Scene(root, 600, 300);
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello World");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
