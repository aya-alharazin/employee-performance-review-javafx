/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package week6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aya
 */
public class TestController implements Initializable {

    @FXML
    private ToggleGroup fontSizeGroup;
    @FXML
    private ToggleGroup fontFamilyGroup;
    @FXML
    private MenuItem exit;
    @FXML
    private ImageView imageView;
    @FXML
    private Label nameLabel;
    @FXML
    private Label departmentLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea commentTextArea;
    @FXML
    private Button uploadCommentbtn;
    @FXML
    private Button savebtn;
    @FXML
    private MenuBar menubar;
    @FXML
    private Slider slider;
    @FXML
    private MenuItem about;
    PrintWriter pr;
    /**
     * Initializes the controller class.
     */
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Image img =new Image(new FileInputStream("src/week6/aya.png"));
            imageView.setImage(img);
        } catch (FileNotFoundException ex) {
            System.getLogger(TestController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        try {
            pr=new PrintWriter(new FileWriter("src/week6/emps.txt"));
        } catch (IOException ex) {
            System.getLogger(TestController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }    

    @FXML
    private void exitHandle(ActionEvent event) {
        ((Stage) menubar.getScene().getWindow()).close();
    }

    @FXML
    private void uploadCommentHandle(ActionEvent event) throws FileNotFoundException {
        FileChooser fc=new FileChooser();
        File f = fc.showOpenDialog(uploadCommentbtn.getScene().getWindow());
        if(f != null){
            Scanner s= new Scanner(f);
            commentTextArea.setText("");
            while(s.hasNextLine()){
            commentTextArea.appendText(s.nextLine()+"\n");
            
        }
        }else{
            showWarning("Warning","No File Chosen", "Make Sure to select valid file");
        }
        
        
        
    }

    @FXML
    private void saveHandle(ActionEvent event) throws FileNotFoundException, IOException {
        if(validate()){
            pr.write(datePicker.getValue().toString()+" - "+commentTextArea.getText()+"\n");
            pr.flush();
            showInfo("Successful", "Data Saved Successfully", "Data Saved to file");

        }
        else{
            showWarning("warning","Missing Date or comment","Please make sure to enter the date and comment");
        }
            
    }

    @FXML
    private void sliderhandle(MouseEvent event) {
        commentTextArea.setStyle("-fx-font-size:"+(int)slider.getValue()+"px");
    }

    @FXML
    private void abouthandle(ActionEvent event) {
        showInfo("About", "Employee Performance Dashboard","Version: 1.0\nDeveloper: Aya\nThis application is used for HR employee reviews." );
        
    }

    public boolean validate(){
        if (datePicker.getValue() == null || commentTextArea.getText().isBlank()){
            return false;
        }
        return true;
    }
    
    public void showWarning(String title,String header,String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    
        public void showInfo(String title , String header,String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
