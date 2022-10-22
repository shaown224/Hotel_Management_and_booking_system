package Customer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;

public class Customersignup {

    @FXML
    private TextField firstnameTextFIeld;

    @FXML
    private TextField lastnameTextFIeld;

    @FXML
    private TextField usernameTextFIeld;

    @FXML
    private PasswordField setPasswordTextField;

    @FXML
    private PasswordField confirmpasswordTextField;

    @FXML
    private Button registerbtn;

    @FXML
    private Button closebtn;
    @FXML
    private Label RegMsg;

    @FXML
    void RegBTNAction(ActionEvent event) {
        if(setPasswordTextField.getText().equals(confirmpasswordTextField.getText())){
            registerUser();


        }else {
            RegMsg.setText("Password does not match");
        }


    }

    @FXML
    void closebtnAction(ActionEvent event)throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Customerlogin.fxml"));
        Stage RegStage=(Stage) closebtn.getScene().getWindow();
        RegStage.setScene(new Scene(root,730,480));
    }
    public void registerUser(){
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String firstname= firstnameTextFIeld.getText();
        String lastname=lastnameTextFIeld.getText();
        String username=usernameTextFIeld.getText();
        String password=setPasswordTextField.getText();
        if (firstname.isEmpty()==false && lastname.isEmpty()==false && username.isEmpty()==false && password.isEmpty()==false){
            String insertFields="INSERT INTO user_account(first_name, last_name,  username, password) VALUES('";
            String insertValues = firstname + "','"+ lastname +"','"+ username +"','"+ password + "')";
            String insertToRegister= insertFields + insertValues;

            try {
                Statement statement= connectDB.createStatement();
                statement.executeUpdate(insertToRegister);
                RegMsg.setText("User has been registered successfully!");
                Parent root;
                root = FXMLLoader.load(getClass().getResource("customerlogin.fxml"));
                Stage RegStage=(Stage) registerbtn.getScene().getWindow();
                RegStage.setScene(new Scene(root,730,480));

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            RegMsg.setText("Fill all the label properly");
        }



    }


}