package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Helper.DatabaseHandler;
import sample.Model.Employee;

import java.net.URL;
import java.util.ResourceBundle;


public class NewEmployeeController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField fullNameField;

    @FXML
    private JFXTextField newPinField;

    @FXML
    private JFXButton newEmployeeButton;

    @FXML
    private JFXComboBox<String> statusBox;

    private DatabaseHandler databaseHandler = new DatabaseHandler();

    private ObservableList<String> statusBoxChoices;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statusBoxChoices = FXCollections.observableArrayList("Active","Inactive");
        statusBox.setItems(statusBoxChoices);

        newEmployeeButton.setOnAction(event ->{
            Employee newEmployee = new Employee();
            String employeeName = fullNameField.getText().trim();
            String employeePin = newPinField.getText().trim();
            String employeeStatus;
            if(statusBox.getSelectionModel().getSelectedItem().equals("Active")){
                employeeStatus = "Active";
            }else {
                employeeStatus = "Inactive";
            }
            if(!fullNameField.equals("") || !newPinField.equals("")){
                newEmployee.setEmpPin(Integer.parseInt(employeePin));
                newEmployee.setEmpName(employeeName);
                newEmployee.setEmpStatus(employeeStatus);
                databaseHandler.addEmployee(newEmployee);
                fullNameField.setText("");
                newPinField.setText("");
                System.out.println("Success");
            }else {
                System.out.println("Failed");
            }
        });
    }
}
