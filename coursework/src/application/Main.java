package application;
	
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;



public class Main extends Application {
	double x=0;
	double hori=0;
	double verti=0;
	@Override
    public void start(Stage stage) {
        StackPane root = new StackPane();

        Text name = new Text("Dongxin Xiang");
        Rectangle rect = new Rectangle(250, 100, Color.LIGHTGRAY);
        root.getChildren().addAll(rect, name);
        
        Button btnL = new Button();
        btnL.setText("L");
        
        
        btnL.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                rect.setRotate(x-10);
                name.setRotate(x-10);
                x=x-10;
            }
        });
        root.getChildren().addAll(btnL);
        Button btnR = new Button();
        btnR.setText("R");
        
        
        btnR.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	rect.setRotate(x+10);
            	name.setRotate(x+10);
            	x=x+10;
            }
        });
        root.getChildren().addAll(btnR);
        Slider slider = new Slider();
        
        slider.setMin(0.5);
        slider.setMax(2);
        slider.setValue(1);
        slider.setShowTickLabels(true);
        TextField tf=new TextField(String.valueOf(slider.getValue()));
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    rect.setScaleX(new_val.doubleValue());
                    rect.setScaleY(new_val.doubleValue());
                    tf.setText(new_val.toString());
            }
        });
        ToggleGroup group = new ToggleGroup();
        
//        RadioButton button1 = new RadioButton("Grey");
//        button1.setToggleGroup(group);
//        button1.setUserData("Light Grey");
        
        ToggleButton button2 = new ToggleButton("Red");
        button2.setUserData("Red");
        button2.setToggleGroup(group);
        ToggleButton button3 = new ToggleButton("Blue");
        button3.setUserData("Blue");
        button3.setToggleGroup(group);
        ToggleButton button4 = new ToggleButton("Yellow");
        button4.setUserData("Yellow");
        button4.setToggleGroup(group);
        ToggleButton button5 = new ToggleButton("Pink");
        button5.setUserData("Pink");
        button5.setToggleGroup(group);
        ToggleButton button6 = new ToggleButton("Grey");
        button6.setUserData("Grey");
        button6.setToggleGroup(group);
        
        
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle old_toggle, Toggle new_toggle) {
              if (group.getSelectedToggle() != null) {
            	  //System.out.println(group.getSelectedToggle());
                if(group.getSelectedToggle().getUserData().toString().equals("Grey")) {
                	rect.setFill(Color.LIGHTGRAY);
                }
                else if(group.getSelectedToggle().getUserData().toString().equals("Red")) {
                	rect.setFill(Color.RED);
                }
                else if(group.getSelectedToggle().getUserData().toString().equals("Blue")) {
                	rect.setFill(Color.BLUE);
                }
                else if(group.getSelectedToggle().getUserData().toString().equals("Yellow")) {
                	rect.setFill(Color.YELLOW);
                }
                else if(group.getSelectedToggle().getUserData().toString().equals("Pink")) {
                	rect.setFill(Color.PINK);
                }
              }
            }
        });
        rect.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event)
            {
                if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1)
                {
                	FillTransition ft = new FillTransition(Duration.seconds(3), rect, (Color) rect.getFill(), Color.LIGHTGRAY);
                	ft.play();
                	RotateTransition rt1 = new RotateTransition(Duration.seconds(3),rect);
                	rt1.setToAngle(0);
                	RotateTransition rt2 = new RotateTransition(Duration.seconds(3),name);
                	rt2.setToAngle(0);
                	ParallelTransition parallelTransition1 = new ParallelTransition();
                    parallelTransition1.getChildren().addAll(rt1,rt2);
                    parallelTransition1.play();
                	ScaleTransition scale = new ScaleTransition(Duration.seconds(1),rect);
                    scale.setToX(1);
                    scale.setToY(1);
                    scale.play();
                    TranslateTransition transition1 = new TranslateTransition(Duration.seconds(3), rect);
                    transition1.setToX(0);                   
                    transition1.setToY(0); 
                    TranslateTransition transition2 = new TranslateTransition(Duration.seconds(3), name);
                    transition2.setToX(0);                   
                    transition2.setToY(0); 
                    ParallelTransition parallelTransition2 = new ParallelTransition();
                    parallelTransition2.getChildren().addAll(transition1,transition2);
                    parallelTransition2.play();
                    x=0;hori=0;verti=0;
                    slider.setValue(1);
                }               

            }
        });
        
        root.getChildren().addAll(button2,button3,button4,button5,button6);
        
        root.getChildren().addAll(slider);
        root.getChildren().addAll(tf);
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
 
            @Override
            public void handle(KeyEvent event) {
                
                if (event.getCode() == KeyCode.L) {
                	rect.setRotate(x-1);
                	name.setRotate(x-1);
                    x=x-1;
                }
                else if(event.getCode() == KeyCode.R) {
                	rect.setRotate(x+1);
                	name.setRotate(x+1);
                	x=x+1;
                }
                else if(event.getCode() == KeyCode.W) {
                	rect.setTranslateY(hori-1);
                	name.setTranslateY(hori-1);
                	hori=hori-1;
                }
                else if(event.getCode() == KeyCode.S) {
                	rect.setTranslateY(hori+1);
                	name.setTranslateY(hori+1);
                	hori=hori+1;
                }
                else if(event.getCode() == KeyCode.A) {
                	rect.setTranslateX(verti-1);
                	name.setTranslateX(verti-1);
                	verti=verti-1;
                }
                else if(event.getCode() == KeyCode.D) {
                	rect.setTranslateX(verti+1);
                	name.setTranslateX(verti+1);
                	verti=verti+1;
                }
                else if(event.getCode() == KeyCode.ENTER) {
                	try {
                		double sc=Double.valueOf(tf.getText());
                		if(sc>=0.5&&sc<=2.0) {
                			slider.setValue(sc);                           
                		}
                	}
                	catch(Exception e) {
                		
                	}
                }
            }
        });

        
        
        Scene scene = new Scene(root, 600, 300);
        StackPane.setMargin(btnL, new Insets(0,200,0,0));
        StackPane.setMargin(btnR, new Insets(0,0,0,200));
        StackPane.setMargin(slider, new Insets(0,100,-150,100));
        StackPane.setMargin(tf, new Insets(0,100,-180,100));
        StackPane.setMargin(button6, new Insets(-300,320,-130,100));
        StackPane.setMargin(button2, new Insets(-300,200,-130,100));
        StackPane.setMargin(button3, new Insets(-300,80,-130,100));
        StackPane.setMargin(button4, new Insets(-300,-40,-130,100));
        StackPane.setMargin(button5, new Insets(-300,-160,-130,100));
        stage.setScene(scene);
        stage.setTitle("Hello FX!");
        stage.show();

        //traverse(root, 0);
    }

//    public static void traverse(Node node, int level) {
//        for (int i = 0; i < level; i++) {
//            System.out.print(" ");
//        }
//        System.out.println(node.getClass());
//        if (node instanceof Parent) {
//            Parent parent = (Parent) node;
//            parent.getChildrenUnmodifiable().forEach(n -> traverse(n, level + 1));
//        }
//    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
