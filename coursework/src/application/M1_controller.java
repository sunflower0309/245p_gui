package application;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class M1_controller {
	//<!--这里的Button对象有需要加@FXML注解，然后变量的名称为你刚才在FXML文件中声明的Button的id属性-->
	double x=0;
	double hori=0;
	double verti=0;
    @FXML
    private Button btnL;
    @FXML
    private StackPane root;
    @FXML
    private Button btnR;
    
    @FXML
    private Rectangle rect;
    
    @FXML
    private Slider slider;
    @FXML
    private Text name;
    @FXML
    private ToggleGroup myToggleGroup;
    @FXML
    private TextField scale;
    //<!--这里的handleButtonAction方法为我们在FXML文件中声明的onAction的处理函数-->
    @FXML
    protected void LRotate(ActionEvent event) {
    	rect.setRotate(x-10);
    	name.setRotate(x-10);
        x=x-10;
    }
    
    @FXML
    protected void RRotate(ActionEvent event) {
    	rect.setRotate(x+10);
    	name.setRotate(x+10);
        x=x+10;
    }
    
    @FXML
    protected void click(MouseEvent event) {
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
    
    @FXML
    private void initialize() {
    	myToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle old_toggle, Toggle new_toggle) {
              if (myToggleGroup.getSelectedToggle() != null) {
            	  //System.out.println(group.getSelectedToggle());
                if(myToggleGroup.getSelectedToggle().getUserData().toString().equals("Grey")) {
                	rect.setFill(Color.LIGHTGRAY);
                }
                else if(myToggleGroup.getSelectedToggle().getUserData().toString().equals("Red")) {
                	rect.setFill(Color.RED);
                }
                else if(myToggleGroup.getSelectedToggle().getUserData().toString().equals("Blue")) {
                	rect.setFill(Color.BLUE);
                }
                else if(myToggleGroup.getSelectedToggle().getUserData().toString().equals("Yellow")) {
                	rect.setFill(Color.YELLOW);
                }
                else if(myToggleGroup.getSelectedToggle().getUserData().toString().equals("Pink")) {
                	rect.setFill(Color.PINK);
                }
              }
            }
        });
    	
    	slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    rect.setScaleX(new_val.doubleValue());
                    rect.setScaleY(new_val.doubleValue());
                    scale.setText(new_val.toString());
            }
        });
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
                		double sc=Double.valueOf(scale.getText());
                		if(sc>=0.5&&sc<=2.0) {
                			slider.setValue(sc);                           
                		}
                	}
                	catch(Exception e) {
                		
                	}
                }
            }
        });
    }
    
    
    
    
    @FXML
    protected void Reset(ActionEvent event) {
        btnL.setText("Hello World, I am JavaFX!");
    }
    
    @FXML
    protected void Slide(ActionEvent event) {
        
    }
}
