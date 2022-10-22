package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Button cancel;
    public void Administration(ActionEvent actionEvent) {
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


    public void Customer(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../Customer/customerlogin.fxml"));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Cancel(ActionEvent actionEvent) {
        Stage stage=(Stage) cancel.getScene().getWindow();
        stage.close();


    }
}
