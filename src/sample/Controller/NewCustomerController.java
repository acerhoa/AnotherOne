package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Helper.DatabaseHandler;
import sample.Model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class NewCustomerController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField newCustomerField;

    @FXML
    private JFXButton newCustomerButton;

    private DatabaseHandler databaseHandler = new DatabaseHandler();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newCustomerButton.setOnAction(event ->{
            Customer newCustomer = new Customer();
            String customerName = newCustomerField.getText().trim();
            newCustomer.setCusName(customerName);
            databaseHandler.addCustomer(newCustomer);
        });
    }
}
