package Customer;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.DatabaseConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
//extends Application
public class Customerroombooking  implements Initializable {

    @FXML
    private Label nameId;

    @FXML
    DatePicker custCheckedIn;

    @FXML
    private ComboBox<String> roomCombo;

    @FXML
    private TextField numberText;

    @FXML
    private TextField custName;

    @FXML
    private TextField custCountry;


    @FXML
    private TextField custDeposit;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private Button addBTN;

    @FXML
    private Button backBTN;

    @FXML
    private Label showlabel;

    @FXML
    private Label showlabel1;

    @FXML
    private TextField custEmail;


    PreparedStatement pst=null;



    ObservableList<String> roomList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            DatabaseConnection connectNow= new DatabaseConnection();
            Connection connectDB=connectNow.getConnection();
            String query = "SELECT `room_number` FROM `room` Where `availability`!='Occupied' ORDER BY `room_number` ASC";
            pst=connectDB.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                roomList.add(rs.getString("room_number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        roomCombo.setItems(roomList);

    }
    @FXML
    void RoomComboAction(ActionEvent event) {

    }

    @FXML
    void addAction(ActionEvent event) {
        bookingInfo();

    }

    @FXML
    void backAction(ActionEvent event) throws Exception {


        Parent root;
        root = FXMLLoader.load(getClass().getResource("customerdeshboard.fxml"));
        Stage RegStage = (Stage) backBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,730,480));
    }

    @FXML
    void methodAction(ActionEvent event) {

    }

    public void bookingInfo() {


        String name = custName.getText();
        String email = custEmail.getText();

        String room = roomCombo.getValue();
        String days = custCheckedIn.getValue().toString();

        String deposit = custDeposit.getText();

        System.out.println( name + " " +  days + " " + deposit + " " );

        /*Database part*/
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        if (name.isEmpty() == false && email.isEmpty() == false && room.isEmpty() == false && days.isEmpty() == false && deposit.isEmpty() == false ) {
            String p="accept";
            String insertFields = "INSERT INTO `booking`(`name` ,`email`,`room`,`deposit`,`days`,`status`) VALUES('";
            String insertValues = name + "','" + email + "','" + room + "','" + deposit + "','" +days+ "','" +"pending"+"')";
            String insertToRegister = insertFields + insertValues;

            // String query= "SELECT status FROM booking where email='"email"'";
           // String verifyLogin= "Select count(1) From booking WHERE status= '" + p+ "'AND email ='"+email + "'";



            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);
                showlabel.setText("User has been applied!");
                // addBTN.setDisable(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showlabel1.setText("Fill all the label properly");
        }
    }
}
