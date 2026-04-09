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
import java.time.LocalDate;
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
    private MenuItem exit;
    @FXML
    private ToggleGroup tg;
    @FXML
    private ToggleGroup tg2;
    @FXML
    private MenuItem about;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea textArea;
    @FXML
    private Slider slider;
    @FXML
    private Button upload;
    @FXML
    private Button save;
    @FXML
    private ImageView imgView;
    @FXML
    private Label nameLabel;
    @FXML
    private Label departmentLabel;
    @FXML
    private MenuBar menubar;
    PrintWriter pr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Image img=new Image(new FileInputStream("src/week6/sami.jpg"));
            imgView.setImage(img);
        } catch (FileNotFoundException ex) {
            System.getLogger(TestController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        try {
            pr = new PrintWriter(new FileWriter("src/week6/emps.txt",true));
        } catch (IOException ex) {
            System.getLogger(TestController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }    

    @FXML
    private void exitHandle(ActionEvent event) {
        ((Stage)menubar.getScene().getWindow()).close();
        pr.close();
    }

    @FXML
    private void aboutHandle(ActionEvent event) {
        showAlert("information", "About", "Employee Performance Dashboard",
                "Version : 1.0\nDeveloper: Aya Alharazin");
    }
    

    @FXML
    private void sliderHandle(MouseEvent event) {
        textArea.setStyle("-fx-font-size:"+(int)slider.getValue()+"px");
    }

    @FXML
    private void uploadHandle(ActionEvent event) {
        FileChooser fc =new FileChooser();
        File f = fc.showOpenDialog(upload.getScene().getWindow());
        if(f != null){
            textArea.setText("");
            try(Scanner s =new Scanner(f)){
            while(s.hasNext()){
                String line=s.nextLine();
                textArea.appendText(line);
            }
            }catch(FileNotFoundException e){
                System.out.println(e);
            }
        }else{
            showAlert("warning", "warning", "No File Chosen", "Make sure to select a valid file");
        }
        
        
    }

    @FXML
    private void saveHandle(ActionEvent event) throws IOException  {
        if(validate()){
            pr.write(datePicker.getValue().toString()+" - "+textArea.getText()+"\n");
            pr.flush();
            datePicker.setValue(LocalDate.MIN);
            textArea.setText("");
            showAlert("information", "successful", "Data saved successfully"
                    , "Date and comment saved successfully");
        }else{
            showAlert("warning", "warning", "Missing Date or comment"
                    , "please make sure to enter date and comment");
        }
    }
    
    
    public boolean validate(){
        if(datePicker.getValue() == null || textArea.getText().isBlank()){
            return false;
        }
        return true;
    }
    
    public void showAlert(String type,String title, String header,String content){
        Alert alert=null;
        if(type.equals("information")){
           alert = new Alert(Alert.AlertType.INFORMATION); 
        }else if(type.equals("warning")){
           alert = new Alert(Alert.AlertType.WARNING);
        }
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
