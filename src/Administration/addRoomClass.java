package Administration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class addRoomClass implements Initializable {
    @FXML
    Label showlabel1,showlabel;
    @FXML
    private TextField availabilityTextField;

    @FXML
    private TextField RoomNumberTextField;

    @FXML
    private TextField PriceTextField;
    @FXML
    private Button BackToDashboardBtn;

    @FXML
    private ComboBox<String> cleaningComboBox;
    ObservableList<String>status= FXCollections.observableArrayList("Clean","Dirty");


    @FXML
    private ComboBox<String> bedTypeComboBox;
    ObservableList<String>bedType= FXCollections.observableArrayList("single","double");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            cleaningComboBox.setItems(status);
            bedTypeComboBox.setItems(bedType);
    }

    @FXML
    void BackToDeshboardAction(ActionEvent event) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("AdministrationHomepage.fxml"));
        Stage RegStage=(Stage) BackToDashboardBtn.getScene().getWindow();
        RegStage.setScene(new Scene(root,730,480));
    }

    @FXML
    void saveBtnAction(ActionEvent event) {
        String number=RoomNumberTextField.getText();
        String availability = "Available";
        String cleaning_status = cleaningComboBox.getValue();
        String price=PriceTextField.getText();
        String bed_type=bedTypeComboBox.getValue();
        //System.out.println(id+" "+number+" "+name + " " + country + " " + checkIn + " " + deposit + " "+ gender);

        /*Database part*/
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        if (number.isEmpty() == false && availability.isEmpty() == false && cleaning_status.isEmpty() == false && price.isEmpty() == false && bed_type.isEmpty() == false ) {
            String insertFields ="INSERT INTO `room`(`room_number` ,`availability`,`clean_status`,`price`,`bed_type`) VALUES('";
            String insertValues = number + "','" + availability+ "','" + cleaning_status + "','" + price + "','" +bed_type+"')";
            String insertToRegister = insertFields + insertValues;


            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);

                showlabel.setText("Room has been Added!");


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showlabel1.setText("Fill all the label properly");
        }

    }


    public void RNTextField(ActionEvent actionEvent) {
    }

    public void avTextField(ActionEvent actionEvent) {
    }
}
