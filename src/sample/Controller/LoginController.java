package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Helper.Constant;
import sample.Helper.DatabaseHandler;
import sample.Model.Employee;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField pinField;

    @FXML
    private JFXButton loginButton;

    private DatabaseHandler databaseHandler = new DatabaseHandler();
    private int employeePin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(event -> {
            int loginPin = Integer.parseInt(pinField.getText().trim());
            Employee employeeLogin = new Employee();
            employeeLogin.setEmpPin(loginPin);
            ResultSet employeeVerify = databaseHandler.verifyPin(employeeLogin);
            int counter = 0;
            try {
                while(employeeVerify.next()){
                    counter++;
                    employeePin = employeeVerify.getInt(Constant.EMPLOYEE_EMPPIN);
                }
                if (counter == 1){
                    showAppScreen();
                }else {
                    System.out.println("Error");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void showAppScreen(){
        loginButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/View/App.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        AppController appController = loader.getController();
        appController.setEmployeePin(employeePin);

        stage.show();
    }
}
