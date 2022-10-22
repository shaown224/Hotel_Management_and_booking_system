package Customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Customerdeshboard {
    public void start() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Customer/customerdeshboard.fxml"));
        primaryStage.setTitle("Customer Homepage");
        primaryStage.setScene(new Scene(root, 730, 480));

        primaryStage.resizableProperty().setValue(false);

        primaryStage.show();

    }
    @FXML
    private Button closeBtn;

    @FXML
    private Button ContactBtn;
    @FXML
    private Button roombooking;

    @FXML
    private Button view_room;

    @FXML
    void ClosebtnAction(ActionEvent event) {
        Stage stage=(Stage) closeBtn.getScene().getWindow();
        stage.close();
    }


    public void roombookingaction(ActionEvent actionEvent) throws Exception{

        Parent root;
        root = FXMLLoader.load(getClass().getResource("customerroombooking.fxml"));
        Stage RegStage = (Stage) roombooking.getScene().getWindow();
        RegStage.setScene(new Scene(root,750,450));

    }
    public void setView_roomgaction(ActionEvent actionEvent) throws Exception{

        Parent root;
        root = FXMLLoader.load(getClass().getResource("customer_room_view.fxml"));
        Stage RegStage = (Stage) roombooking.getScene().getWindow();
        RegStage.setScene(new Scene(root,750,450));

    }
    public void ContactBtnAction(ActionEvent actionEvent)throws Exception{

        Parent root;
        root = FXMLLoader.load(getClass().getResource("Customerlogin.fxml"));
        Stage RegStage=(Stage) ContactBtn.getScene().getWindow();
        RegStage.setScene(new Scene(root,730,480));

    }

}

