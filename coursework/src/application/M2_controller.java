package application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
public class M2_controller {
	private File pic=null;
	private Image localImage=null;
	private int index=0;
	private String local_url="";
	//private final TableView<stu_info> table = new TableView<>();
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
    
    
    @FXML
    private HBox b2;
    @FXML
    private HBox ID_BOX;
    @FXML
    private HBox Lastname_BOX;
    @FXML
    private HBox Firstname_BOX;
    @FXML
    private HBox Currentgrade_BOX;
    @FXML
    private HBox Honor_BOX;
    @FXML
    private HBox Notes_BOX;
    @FXML
    private HBox Major_BOX;
    @FXML
    private HBox Gradeoption_BOX;
    @FXML
    private HBox hBox_button_load;
    @FXML
    private HBox hbox_chart;
    @FXML
    private VBox vbox_roaster;
    @FXML
    private VBox vv;
    @FXML
    private VBox b1;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab roaster;
    @FXML
    private Tab chart;
    @FXML
    private ScrollPane sc;
    @FXML
    private ScrollPane s;
    @FXML
    private FlowPane root;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fileMenu;
    @FXML
    private MenuItem newMenuItem;
    @FXML
    private MenuItem openMenuItem;
    @FXML
    private MenuItem saveMenuItem;
    @FXML
    private MenuItem saveAsMenuItem;
    @FXML
    private MenuItem closeMenuItem;
    @FXML
    private MenuItem exitMenuItem;
    @FXML
    private TableColumn<stu_info,String> columnid;
    @FXML
    private TableColumn<stu_info,String> columnLastname;
    @FXML
    private TableColumn<stu_info,String> columnFirstname;
    @FXML
    private TableColumn<stu_info,String> columnHonor;
    @FXML
    private TableColumn<stu_info,String> columnNotes;
    @FXML
    private TableColumn<stu_info,String> columnPhoto;
    @FXML
    private TableColumn<stu_info,String> columnMajor;
    @FXML
    private TableColumn<stu_info,String> columnCurrentgrade;
    @FXML
    private TableColumn<stu_info,String> columnGradeoption;
    @FXML
    private TextField ID;
    @FXML
    private TextField Lastname;
    @FXML
    private TextField Firstname;
    @FXML
    private TextField Honor;
    @FXML
    private TextField Notes;
    @FXML
    private ImageView imv;
    @FXML
    private ChoiceBox<String> Major;
    @FXML
    private ChoiceBox<String> Currentgrade;
    @FXML
    private ChoiceBox<String> Gradeoption;
    @FXML
    private Button load;
    @FXML
    private Button newstu;
    @FXML
    private Button delete;
    @FXML
    private Button save;
    @FXML
    private Button previous;
    @FXML
    private Button next;
    @FXML
    private PieChart pc;
    @FXML
    private BarChart<Number, String> bc;
    @FXML
    private TableView<stu_info> table;
    
    @FXML
    private void initialize() {
    	hbox_chart.getChildren().addAll(load_piechart(info_list),load_barchart(info_list));
    	Major.setItems(FXCollections.observableArrayList("MSWE", "MCS", "NETSYS"));
    	Currentgrade.setItems(FXCollections.observableArrayList("A", "B", "C","D","F"));
    	Gradeoption.setItems(FXCollections.observableArrayList("LetterGrade", "Pass/NotPass"));
    	table.setEditable(true);
        table.setItems(info_list);   
        columnid.setCellFactory(TextFieldTableCell.forTableColumn());
        columnid.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_id(t.getNewValue());
        });
        columnid.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Id"));
        
        columnLastname.setCellFactory(TextFieldTableCell.forTableColumn());
        columnLastname.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().setLastname(t.getNewValue());
        });
        columnLastname.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Lastname"));
                
        columnFirstname.setCellFactory(TextFieldTableCell.forTableColumn());
        columnFirstname.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Firstname(t.getNewValue());
        });
        columnFirstname.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Firstname"));
               
        columnHonor.setCellFactory(TextFieldTableCell.forTableColumn());
        columnHonor.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Honor(t.getNewValue());
        });
        columnHonor.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Honor"));
                
        columnNotes.setCellFactory(TextFieldTableCell.forTableColumn());
        columnNotes.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Notes(t.getNewValue());
        });
        columnNotes.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Notes"));
                
        columnMajor.setCellFactory(ChoiceBoxTableCell.forTableColumn(FXCollections.observableArrayList("MSWE", "MCS", "NETSYS")));
        columnMajor.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Major(t.getNewValue());
            hbox_chart.getChildren().clear();
    		hbox_chart.getChildren().addAll(load_piechart(info_list),load_barchart(info_list));                  
            chart.setContent(hbox_chart);
        });
        columnMajor.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Major"));
                
        columnCurrentgrade.setCellFactory(ChoiceBoxTableCell.forTableColumn(FXCollections.observableArrayList("A", "B", "C","D","F")));
        columnCurrentgrade.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Currentgrade(t.getNewValue());
            hbox_chart.getChildren().clear();
    		hbox_chart.getChildren().addAll(load_piechart(info_list),load_barchart(info_list));                  
            chart.setContent(hbox_chart);
        });
        columnCurrentgrade.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Currentgrade"));
                
        columnGradeoption.setCellFactory(ChoiceBoxTableCell.forTableColumn(FXCollections.observableArrayList("LetterGrade", "Pass/NotPass")));
        columnGradeoption.setOnEditCommit((CellEditEvent<stu_info, String> t) -> {
            t.getRowValue().set_Gradeoption(t.getNewValue());
        });
        columnGradeoption.setCellValueFactory(new PropertyValueFactory<stu_info,String>("Gradeoption"));
               
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
                            File picchange = fileChooser.showOpenDialog(table.getScene().getWindow());
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
        newMenuItem.setOnAction(actionEvent -> Platform.runLater(new Runnable() {
    	    public void run() {             
    	        try {
    	        	new M2_fxml().start(new Stage());
    	        }
    	        catch(Exception e) {
    	        	e.printStackTrace();
    	        }
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
                File file = fileChooser.showOpenDialog(table.getScene().getWindow());
                String filename=file.getName();
                Stage stage=new Stage();
                stage.setTitle(filename);
                try {
    	        	new M2_fxml().start(stage);
    	        }
    	        catch(Exception e) {
    	        	e.printStackTrace();
    	        }
    	    
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
        		Stage stage=(Stage)table.getScene().getWindow();
        		stage.close();
        	}
        }));
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
    }
    
    @FXML
    private void newstu(ActionEvent event) {
    	ID.setText("");
    	Lastname.setText("");
    	Firstname.setText("");
    	
    	Honor.setText("");
    	Notes.setText("");
    	imv.setImage(null);
    }
    @FXML
    private void load(ActionEvent event) {
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
        pic = fileChooser.showOpenDialog(table.getScene().getWindow());
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
    @FXML
    private void save(ActionEvent event) {
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
    @FXML
    private void delete(ActionEvent event) {
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
        	localImage = new Image(pic_url, false);
        	local_url=pic_url;
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
    @FXML
    private void previous(ActionEvent event) {
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
    @FXML
    private void next(ActionEvent event) {
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
    private PieChart load_piechart(ObservableList<stu_info> data) {
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
		int i=0;
		
		PieChart chart = new PieChart(grade_data);
		
		return chart;
	}
	
	
	
	private BarChart load_barchart(ObservableList<stu_info> data) {
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
}
