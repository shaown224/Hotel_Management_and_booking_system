package Administration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdministrationHomepage {
    public void start() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Administration/AdministrationHomepage.fxml"));
        primaryStage.setTitle("Admin Homepage");
        primaryStage.setScene(new Scene(root, 730, 480));

        primaryStage.resizableProperty().setValue(false);

        primaryStage.show();

    }
    @FXML
    private Button closeBtn;

    @FXML
    private Button ContactBtn;

    @FXML
    private Button receptionBTN;

    @FXML
    private Button addRoomBTN;

    @FXML
    private Button addEmployeeBTN;

    @FXML
    private Button bookingBTN;
    @FXML
    void ContactBtnAction(ActionEvent a ){


    }

    @FXML
    void ClosebtnAction(ActionEvent event) {
        Stage stage=(Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void addEmployeeAction(ActionEvent event) throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("employee.fxml"));
        Stage RegStage = (Stage) addEmployeeBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,730,480));

    }

    @FXML
    void addRoomAction(ActionEvent event) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("addRoom.fxml"));
        Stage RegStage = (Stage) addRoomBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,505));
    }

    @FXML
    void receptionAction(ActionEvent event) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("reception.fxml"));
        Stage RegStage = (Stage) receptionBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));
    }

    @FXML
    void bookingAction(ActionEvent event)throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("requestInfo.fxml"));
        Stage RegStage = (Stage) bookingBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,750,450));
    }
}
