package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import application.stu_info;
public class Module2 extends Application{
	//private ObservableList<stu_info> info_list=new ObservableList<stu_info>();
	private File pic=null;
	private Image localImage=null;
	private String local_url="";
	private int index=0;
	private final TableView<stu_info> table = new TableView<>();
	final HBox hb_table = new HBox();
	private stu_info stu1=new stu_info("1201","Simon","Hyer","MSWE","A","LetterGrade","Sniper","Kuma","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
    private stu_info stu2=new stu_info("1202","Tomas","Edison","MCS","B","LetterGrade","Genius","Lion","file:/D:/001.png");
    private stu_info stu3=new stu_info("1203","Simon","Hyer","MSWE","C","LetterGrade","Sniper","Kuma","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
    private stu_info stu4=new stu_info("1204","Simon","Hyer","NETSYS","D","LetterGrade","Sniper","Kuma","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
    private stu_info stu5=new stu_info("1205","Simon","Hyer","MSWE","B","LetterGrade","Sniper","Kuma","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
    private stu_info stu6=new stu_info("1206","Simon","Hyer","MCS","F","LetterGrade","Sniper","Kuma","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
    private stu_info stu7=new stu_info("1207","Simon","Hyer","MSWE","C","LetterGrade","Sniper","Kuma","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
    private stu_info stu8=new stu_info("1208","Simon","Hyer","NETSYS","A","LetterGrade","Sniper","Kuma","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
    private stu_info stu9=new stu_info("1209","Simon","Hyer","MSWE","B","LetterGrade","Sniper","Kuma","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
    private ObservableList<stu_info> info_list = FXCollections.observableArrayList(stu1, stu2, stu3, stu4, stu5, stu6, stu7, stu8, stu9);
//	public ObservableList<stu_info> info_list() {
//
//        stu_info stu1=new stu_info(12,"a","a","MSWE","A","LetterGrade","a","a","file:/C:/Users/Administrator/Desktop/-7Q5-2xefZ15T3cSu0-1hc.jpg.medium.jpg");
//        stu_info stu2=new stu_info(12,"a","a","MCS","B","LetterGrade","a","a","file:/D:/001.png");
//
//        ObservableList<stu_info> stuLists = FXCollections.observableArrayList(stu1, stu2);
//        return stuLists;
//    }

	
	@Override
    public void start(Stage primaryStage) {
		//BorderPane root = new BorderPane();
		ScrollPane s=new ScrollPane();
        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.VERTICAL);
        TabPane tabPane = new TabPane();
        Tab roaster=new Tab();
        Tab chart=new Tab();
        tabPane.setSide(Side.TOP);
        VBox vbox_roaster = new VBox();
        HBox hbox_chart=new HBox();
        
        
        // generating "properties"
        MenuBar menuBar = new MenuBar();       
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        //root.setTop(menuBar);
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem saveAsMenuItem = new MenuItem("Save As");
        MenuItem closeMenuItem = new MenuItem("Close");
        MenuItem exitMenuItem = new MenuItem("Exit");   
        
        newMenuItem.setOnAction(actionEvent -> Platform.runLater(new Runnable() {
    	    public void run() {             
    	        new Module2().start(new Stage());
    	    }
        }));
        
        openMenuItem.setOnAction(actionEvent -> Platform.runLater(new Runnable() {
        	public void run() {
        		FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("View Pictures");
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))
                );                 
                fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("GIF", "*.gif"),
                    new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
                );
                File file = fileChooser.showOpenDialog(primaryStage);
                String filename=file.getName();
                Stage stage=new Stage();
                stage.setTitle(filename);
                new Module2().start(stage);
        	}
        }));
        
        saveMenuItem.setOnAction(actionEvent -> Platform.runLater(new Runnable() {
        	public void run() {
        		JFileChooser fileChooser =new JFileChooser();
        		fileChooser.showSaveDialog(null);
    			File fout =fileChooser.getSelectedFile();
    			try {
    				FileOutputStream fileout =new FileOutputStream(fout);
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}

        	}
        }));
        
        saveAsMenuItem.setOnAction(actionEvent -> Platform.runLater(new Runnable() {
        	public void run() {
        		JFileChooser fileChooser =new JFileChooser();
        		fileChooser.showSaveDialog(null);
    			File fout =fileChooser.getSelectedFile();
    			try {
    				FileOutputStream fileout =new FileOutputStream(fout);
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}

        	}
        }));
        
        closeMenuItem.setOnAction(actionEvent -> Platform.runLater(new Runnable() {
        	public void run() {
        		primaryStage.close();
        	}
        }));
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        fileMenu.getItems().addAll(newMenuItem ,openMenuItem,closeMenuItem,saveMenuItem, saveAsMenuItem,exitMenuItem);
        menuBar.getMenus().addAll(fileMenu);
        //root.getChildren().add(menuBar);
        //root.getChildren().add(menuBar);
        
        
        TableView<stu_info> table = new TableView<>();
        table.setEditable(true);
        table.setItems(info_list);
        
        
        TableColumn<stu_info, String> columnid = new TableColumn<>("Id");
        columnid.setCellFactory(TextFieldTableCell.forTableColumn());
        columnid.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_id(t.getNewValue());
        });
        columnid.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Id"));
        
        TableColumn<stu_info, String> columnLastname = new TableColumn<>("Lastname");
        columnLastname.setCellFactory(TextFieldTableCell.forTableColumn());
        columnLastname.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().setLastname(t.getNewValue());
        });
        columnLastname.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Lastname"));
        
        TableColumn<stu_info, String> columnFirstname = new TableColumn<>("Firstname");
        columnFirstname.setCellFactory(TextFieldTableCell.forTableColumn());
        columnFirstname.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Firstname(t.getNewValue());
        });
        columnFirstname.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Firstname"));
        
        TableColumn<stu_info, String> columnHonor = new TableColumn<>("Honor");
        columnHonor.setCellFactory(TextFieldTableCell.forTableColumn());
        columnHonor.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Honor(t.getNewValue());
        });
        columnHonor.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Honor"));
        
        TableColumn<stu_info, String> columnNotes = new TableColumn<>("Notes");
        columnNotes.setCellFactory(TextFieldTableCell.forTableColumn());
        columnNotes.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Notes(t.getNewValue());
        });
        columnNotes.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Notes"));
        
        
        //ObservableList<String> testlist = FXCollections.observableArrayList("A", "B", "C");      
        TableColumn<stu_info, String> columnMajor = new TableColumn<>("Major");
        columnMajor.setCellFactory(ChoiceBoxTableCell.forTableColumn(FXCollections.observableArrayList("MSWE", "MCS", "NETSYS")));
        columnMajor.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Major(t.getNewValue());
            hbox_chart.getChildren().clear();
    		hbox_chart.getChildren().addAll(load_piechart(info_list),load_barchart(info_list));                  
            chart.setContent(hbox_chart);
        });
        columnMajor.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Major"));
        
        TableColumn<stu_info, String> columnCurrentgrade = new TableColumn<>("Currentgrade");
        columnCurrentgrade.setCellFactory(ChoiceBoxTableCell.forTableColumn(FXCollections.observableArrayList("A", "B", "C","D","F")));
        columnCurrentgrade.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Currentgrade(t.getNewValue());
            hbox_chart.getChildren().clear();
    		hbox_chart.getChildren().addAll(load_piechart(info_list),load_barchart(info_list));                  
            chart.setContent(hbox_chart);
        });
        columnCurrentgrade.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Currentgrade"));
        
        TableColumn<stu_info, String> columnGradeoption = new TableColumn<>("Gradeoption");
        columnGradeoption.setCellFactory(ChoiceBoxTableCell.forTableColumn(FXCollections.observableArrayList("LetterGrade", "Pass/NotPass")));
        columnGradeoption.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Gradeoption(t.getNewValue());
        });
        columnGradeoption.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Gradeoption"));
        
        ImageView imv=new ImageView();
        TableColumn<stu_info, String> columnPhoto = new TableColumn<>("Photo");
        columnPhoto.setCellFactory((col) -> {
            TableCell<stu_info, String> cell = new TableCell<stu_info, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        ImageView edit = new ImageView(this.getItem());
                        edit.setFitWidth(50);
                        edit.setPreserveRatio(true);
                        Button editBtn = new Button("edit", edit);
                        this.setGraphic(editBtn);
                        editBtn.setOnMouseClicked((me) -> {
                        	FileChooser fileChooser = new FileChooser();
                            fileChooser.setTitle("View Pictures");
                            fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))
                            );                 
                            fileChooser.getExtensionFilters().addAll(
                                new FileChooser.ExtensionFilter("All Images", "*.*"),
                                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                                new FileChooser.ExtensionFilter("PNG", "*.png")
                            );
                            File picchange = fileChooser.showOpenDialog(primaryStage);
                            //System.out.println(file);
                            try {
                            	String pic_url = picchange.toURI().toURL().toString();
                            	local_url=pic_url;
                            	this.getTableView().getItems().get(this.getIndex()).set_Photo(pic_url);
                            	Image image=new Image(pic_url,false);
                            	edit.setImage(image);
                            	imv.setImage(image);
                            	System.out.println(pic_url);                           	
                            }
                            catch(Exception e) {
                            	e.printStackTrace();
                            }
                        });
                    }
                }

            };
            return cell;
        });
        columnPhoto.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Photo(t.getNewValue());
        });
        columnPhoto.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Photo"));
        
        
        table.getColumns().addAll(columnid,columnLastname,columnFirstname,columnHonor,columnNotes,
        		columnPhoto,columnMajor,columnCurrentgrade,columnGradeoption);
        
        VBox vv=new VBox();
        vv.getChildren().addAll(menuBar,table);
        //root.getChildren().add(vv);
        //root.getChildren().add(table);
        
        TextField ID = new TextField();
        HBox.setHgrow(ID, Priority.NEVER); // to make it look better
        HBox ID_BOX = new HBox(5, new Label("ID"), ID);
        ID_BOX.setPadding(new Insets(5));
        //root.getChildren().add(ID_BOX);
        
        TextField Lastname = new TextField();
        HBox.setHgrow(Lastname, Priority.NEVER); // to make it look better
        HBox Lastname_BOX = new HBox(5, new Label("Lastname"), Lastname);
        Lastname_BOX.setPadding(new Insets(5));
        //root.getChildren().add(Lastname_BOX);
        
        TextField Firstname = new TextField();
        HBox.setHgrow(Firstname, Priority.NEVER); // to make it look better
        HBox Firstname_BOX = new HBox(5, new Label("Firstname"), Firstname);
        Firstname_BOX.setPadding(new Insets(5));
        //root.getChildren().add(Firstname_BOX);
        
//        TextField Currentgrade = new TextField();
//        HBox.setHgrow(Currentgrade, Priority.NEVER); // to make it look better
//        HBox Currentgrade_BOX = new HBox(5, new Label("Currentgrade"), Currentgrade);
//        Currentgrade_BOX.setPadding(new Insets(5));
//        root.getChildren().add(Currentgrade_BOX);
        
        ChoiceBox Currentgrade = new ChoiceBox(FXCollections.observableArrayList("A", "B", "C","D","F"));
        HBox.setHgrow(Currentgrade, Priority.NEVER);
        HBox Currentgrade_box = new HBox(5, new Label("Currentgrade"), Currentgrade);
        Currentgrade_box.setPadding(new Insets(5));
        //root.getChildren().add(Currentgrade_box);
        
        TextField Honor = new TextField();
        HBox.setHgrow(Honor, Priority.NEVER); // to make it look better
        HBox Honor_BOX = new HBox(5, new Label("Honor"), Honor);
        Honor_BOX.setPadding(new Insets(5));
        //root.getChildren().add(Honor_BOX);
        
        TextField Notes = new TextField();
        HBox.setHgrow(Notes, Priority.NEVER); // to make it look better
        HBox Notes_BOX = new HBox(5, new Label("Notes"), Notes);
        Notes_BOX.setPadding(new Insets(5));
        //root.getChildren().add(Notes_BOX);
        
        ChoiceBox Major = new ChoiceBox(FXCollections.observableArrayList("MSWE", "MCS", "NETSYS"));
        HBox.setHgrow(Major, Priority.NEVER);
        HBox major_box = new HBox(5, new Label("Major"), Major);
        major_box.setPadding(new Insets(5));
        //root.getChildren().add(major_box);
        
        ChoiceBox Gradeoption = new ChoiceBox(FXCollections.observableArrayList("LetterGrade", "Pass/NotPass"));
        HBox.setHgrow(Gradeoption, Priority.NEVER);
        HBox Gradeoption_box = new HBox(5, new Label("Grade Option"), Gradeoption);
        Gradeoption_box.setPadding(new Insets(5));
        //root.getChildren().add(Gradeoption_box);
        
        
        Button buttonLoad = new Button("Load");
        //String pic_url="";
        buttonLoad.setOnAction(new EventHandler<ActionEvent>(){
            @Override
           public void handle(ActionEvent arg0) {
            	FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("View Pictures");
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))
                );                 
                fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("GIF", "*.gif"),
                    new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
                );
                pic = fileChooser.showOpenDialog(primaryStage);
                //System.out.println(file);
                try {
                	String pic_url = pic.toURI().toURL().toString();
                	local_url=pic_url;
                	localImage = new Image(pic_url, false);
                	Image image=new Image(pic_url,false);
                	System.out.println(localImage);
                	//imv.setFitWidth(100);
                	//imv.maxHeight(100);
                	imv.setImage(image);
                	//imv.setImage(localImage);
                }
                catch(Exception e) {
                	e.printStackTrace();
                }
           }
        });
        
        
        
        table.setRowFactory( tv -> {
        	TableRow<stu_info> row = new TableRow<stu_info>();
        	row.setOnMouseClicked(event -> {
        	if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
        		int rowindex=row.getIndex();
        		System.out.println(rowindex);
        		stu_info Info = info_list.get(rowindex);
        		index=rowindex;
        		ID.setText(String.valueOf(info_list.get(index).getId()));
        		Firstname.setText(info_list.get(index).getFirstname());
        		Lastname.setText(info_list.get(index).getLastname());
        		Major.setValue(info_list.get(index).getMajor());
        		Gradeoption.setValue(info_list.get(index).getGradeoption());
        		Honor.setText(info_list.get(index).getHonor());
        		Notes.setText(info_list.get(index).getNotes());
        		Currentgrade.setValue(info_list.get(index).getCurrentgrade());
        		String pic_url = info_list.get(index).getPhoto();
        		local_url=pic_url;
            	localImage = new Image(pic_url, false);
            	System.out.println(pic_url);
            	imv.setFitWidth(200);
            	imv.setPreserveRatio(true);
            	imv.setImage(localImage);
        	}
        	});
        	return row ;
        });
        
        
        HBox.setHgrow(buttonLoad, Priority.ALWAYS); // to make it look better
        HBox hBox_button_load = new HBox(5, new Label("load pic"), buttonLoad);
        hBox_button_load.setPadding(new Insets(5));
        //root.getChildren().add(hBox_button_load);
        
        HBox.setHgrow(imv, Priority.ALWAYS);
        HBox image_box=new HBox(5,new Label("pic"),imv);
        image_box.setPadding(new Insets(5));
        //root.getChildren().add(image_box);
        
        
        
        Button newstu=new Button("New Student");
        newstu.setOnAction(new EventHandler<ActionEvent>(){
            @Override
           public void handle(ActionEvent arg0) {
            	ID.setText("");
            	Lastname.setText("");
            	Firstname.setText("");
            	
            	Honor.setText("");
            	Notes.setText("");
            	imv.setImage(null);
           }
        });
        //root.getChildren().add(newstu);
        
        Button save=new Button("Save Change");
        save.setOnAction(new EventHandler<ActionEvent>(){
            @Override
           public void handle(ActionEvent arg0) {
            	stu_info info=new stu_info(null,null,null,null,null,null,null,null,null);
            	System.out.println(index);
            	try {
            		
            		int id=Integer.valueOf(ID.getText());
            		info.set_id(ID.getText());
            		info.set_Firstname(Firstname.getText());
            		info.setLastname(Lastname.getText());
            		info.set_Major(Major.getSelectionModel().getSelectedItem().toString());
            		info.set_Gradeoption(Gradeoption.getSelectionModel().getSelectedItem().toString());
            		info.set_Honor(Honor.getText());
            		info.set_Notes(Notes.getText());
            		info.set_Currentgrade(Currentgrade.getSelectionModel().getSelectedItem().toString());
            		info.set_Photo(local_url);
            		info_list.add(info);
            		index=info_list.size()-1;
            		System.out.println(Major.getSelectionModel().getSelectedItem().toString());
            		hbox_chart.getChildren().clear();
            		hbox_chart.getChildren().addAll(load_piechart(info_list),load_barchart(info_list));                  
                    chart.setContent(hbox_chart);
                    table.setItems(info_list);
            		Alert alert = new Alert(AlertType.INFORMATION);
            		
            		alert.setTitle("Info");            		
            		alert.setContentText("Saved");
            		alert.showAndWait();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            		Alert alert = new Alert(AlertType.ERROR);
            		alert.setTitle("Error Info");
            		
            		alert.setContentText("Message Incomplete/Unavilable");

            		alert.showAndWait();
            	}
           }
        });
        //root.getChildren().add(save);
        
        
        
        Button delete=new Button("Delete Student");
        delete.setOnAction(new EventHandler<ActionEvent>(){
            @Override
           public void handle(ActionEvent arg0) {
            	//stu_info info=new stu_info();
            	try {
            		info_list.remove(index);
            		index=0;
            		ID.setText(String.valueOf(info_list.get(index).getId()));
            		Firstname.setText(info_list.get(index).getFirstname());
            		Lastname.setText(info_list.get(index).getLastname());
            		Major.setValue(info_list.get(index).getMajor());
            		Gradeoption.setValue(info_list.get(index).getGradeoption());
            		Honor.setText(info_list.get(index).getHonor());
            		Notes.setText(info_list.get(index).getNotes());
            		Currentgrade.setValue(info_list.get(index).getCurrentgrade());
            		String pic_url = info_list.get(index).getPhoto();
            		local_url=pic_url;
                	localImage = new Image(pic_url, false);
                	System.out.println(pic_url);
                	imv.setFitWidth(200);
                	imv.setPreserveRatio(true);
                	imv.setImage(localImage);
                	hbox_chart.getChildren().clear();
            		hbox_chart.getChildren().addAll(load_piechart(info_list),load_barchart(info_list));                  
                    chart.setContent(hbox_chart);
                    table.setItems(info_list);
            	}
            	catch(Exception e) {
            		Alert alert = new Alert(AlertType.ERROR);
            		alert.setTitle("Error Info");
            		
            		alert.setContentText("Already Empty");

            		alert.showAndWait();
            	}
           }
        });
        //root.getChildren().add(delete);
        
        Button previous=new Button("Previous Student");
        previous.setOnAction(new EventHandler<ActionEvent>(){
            @Override
           public void handle(ActionEvent arg0) {
            	//stu_info info=new stu_info();
            	try {
            		index=index-1;
            		System.out.println(index);
            		ID.setText(String.valueOf(info_list.get(index).getId()));
            		Firstname.setText(info_list.get(index).getFirstname());
            		Lastname.setText(info_list.get(index).getLastname());
            		Major.setValue(info_list.get(index).getMajor());
            		Gradeoption.setValue(info_list.get(index).getGradeoption());
            		Honor.setText(info_list.get(index).getHonor());
            		Notes.setText(info_list.get(index).getNotes());
            		Currentgrade.setValue(info_list.get(index).getCurrentgrade());
            		String pic_url = info_list.get(index).getPhoto();
            		local_url=pic_url;
                	localImage = new Image(pic_url, false);
                	System.out.println(pic_url);
                	imv.setFitWidth(200);
                	imv.setPreserveRatio(true);
                	imv.setImage(localImage);
            	}
            	catch(Exception e) {
            		index=index+1;
            		e.printStackTrace();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("Info");
            		
            		alert.setContentText("The first one");

            		alert.showAndWait();
            	}
           }
        });
        //root.getChildren().add(previous);
        
        Button next=new Button("Next Student");
        next.setOnAction(new EventHandler<ActionEvent>(){
            @Override
           public void handle(ActionEvent arg0) {
            	//stu_info info=new stu_info();
            	try {
            		index=index+1;
            		System.out.println(index);
            		ID.setText(String.valueOf(info_list.get(index).getId()));
            		Firstname.setText(info_list.get(index).getFirstname());
            		Lastname.setText(info_list.get(index).getLastname());
            		Major.setValue(info_list.get(index).getMajor());
            		Gradeoption.setValue(info_list.get(index).getGradeoption());
            		Honor.setText(info_list.get(index).getHonor());
            		Notes.setText(info_list.get(index).getNotes());
            		Currentgrade.setValue(info_list.get(index).getCurrentgrade());
            		String pic_url = info_list.get(index).getPhoto();
            		local_url=pic_url;
                	localImage = new Image(pic_url, false);
                	System.out.println(pic_url);
                	imv.setFitWidth(200);
                	imv.setPreserveRatio(true);
                	imv.setImage(localImage);
            	}
            	catch(Exception e) {
            		index=index-1;
            		e.printStackTrace();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("Info");
            		
            		alert.setContentText("The last one");

            		alert.showAndWait();
            	}
           }
        });
        //root.getChildren().add(next);
        
        VBox b1=new VBox();
        b1.getChildren().addAll(ID_BOX,Lastname_BOX,Firstname_BOX,Currentgrade_box,Honor_BOX
        		,Notes_BOX,major_box,Gradeoption_box,hBox_button_load,newstu,save,delete,previous,next);
        
        HBox b2=new HBox();
        b2.getChildren().addAll(b1,image_box);
        
        
        VBox vvv=new VBox();
        vvv.getChildren().addAll(vv,b2);
        root.getChildren().add(vvv);
        s.setContent(root);
        roaster.setContent(s);
        
        roaster.setText("Roaster");
        roaster.setClosable(false);
        chart.setClosable(false);
        chart.setText("Chart");
        
//        final Label caption = new Label("ssdf");
//        caption.setTextFill(Color.BLACK);
//        caption.setMinWidth(100);
//        //caption.setStyle("-fx-font: 24 arial;");
//        PieChart pc=load_piechart(info_list);
//        pc.setTranslateZ(10);
//        for (final PieChart.Data datas : pc.getData()) {
//            datas.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
//                    new EventHandler<MouseEvent>() {
//                        @Override public void handle(MouseEvent e) {
//                            caption.setTranslateX(e.getSceneX());
//                            caption.setTranslateY(e.getSceneY());
//                            pc.setTranslateZ(10);
//                            caption.setTranslateZ(0);
//                            DecimalFormat df = new DecimalFormat("0.00");
//                            double x=datas.getPieValue()/info_list.size()*100;
//                            String val = df.format(x);
//                            caption.setText(val + "%");
//                        }
//                    });
//        }
//        
        

        hbox_chart.getChildren().addAll(load_piechart(info_list),load_barchart(info_list));
        ScrollPane sc=new ScrollPane();
        sc.setContent(hbox_chart);
        chart.setContent(sc);
        
        tabPane.getTabs().addAll(roaster,chart);
        
        
        //primaryStage.setTitle("Module2");
        primaryStage.setScene(new Scene(tabPane, 900, 900));
        primaryStage.show();
    }
	
	public PieChart load_piechart(ObservableList<stu_info> data) {
		int A=0,B=0,C=0;
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getMajor().equals("MCS")) {
				A++;
			}
			else if(data.get(i).getMajor().equals("MSWE")) {
				B++;
			}
			else if(data.get(i).getMajor().equals("NETSYS")) {
				C++;
			}
			
		}
		DecimalFormat df = new DecimalFormat("0.00");
        double x1=(double)A/data.size()*100;
        //System.out.print(x1);
        String val1 = df.format(x1);
        double x2=(double)B/data.size()*100;
        String val2 = df.format(x2);
        double x3=(double)C/data.size()*100;
        String val3 = df.format(x3);
		ObservableList<PieChart.Data> grade_data= FXCollections.observableArrayList(
                new PieChart.Data("MCS "+val1+"%", A),
                new PieChart.Data("MSWE "+val2+"%", B),
                new PieChart.Data("NETSYS "+val3+"%", C)
                );

		PieChart chart = new PieChart(grade_data);
		
		return chart;
	}
	
	
	
	public BarChart load_barchart(ObservableList<stu_info> data) {
		int A=0,B=0,C=0,D=0,F=0;
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getCurrentgrade().equals("A")) {
				A++;
			}
			else if(data.get(i).getCurrentgrade().equals("B")) {
				B++;
			}
			else if(data.get(i).getCurrentgrade().equals("C")) {
				C++;
			}
			else if(data.get(i).getCurrentgrade().equals("D")) {
				D++;
			}
			else if(data.get(i).getCurrentgrade().equals("F")) {
				F++;
			}
			
		}
		NumberAxis yAxis = new NumberAxis();
        CategoryAxis xAxis = new CategoryAxis();
        BarChart<Number, String> bc = new BarChart<Number, String>(yAxis, xAxis);
        bc.setTitle("Summary");
        yAxis.setLabel("Num");
        xAxis.setLabel("Grade");
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(A, "A"));
        series1.getData().add(new XYChart.Data(B, "B"));
        series1.getData().add(new XYChart.Data(C, "C"));
        series1.getData().add(new XYChart.Data(D, "D"));
        series1.getData().add(new XYChart.Data(F, "F"));
        bc.getData().add(series1);
        return bc;
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
