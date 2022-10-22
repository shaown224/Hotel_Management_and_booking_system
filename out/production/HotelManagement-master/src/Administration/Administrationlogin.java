package Administration;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Administrationlogin {
    @FXML
    Button loginbutton;
    @FXML
    TextField usertextfield;
    @FXML
    PasswordField passwordtextfield;
    private Stage stage;
    private Scene scene;
    private Parent root;




    public void Usertextfield(ActionEvent actionEvent) {
    }

    public void Passwordtextfield(ActionEvent actionEvent) {
    }

    public void Loginbutton(ActionEvent actionEvent) {
        String s = "admin";
        String a = "1234";
        if(s.contains(usertextfield.getText()) && a.contains(passwordtextfield.getText()) ){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../Administration/AdministrationHomepage.fxml"));
                stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../Administration/administrationlogin.fxml"));
                stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

