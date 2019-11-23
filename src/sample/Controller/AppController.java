package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab orderTab;

    @FXML
    private Tab transactionTab;

    @FXML
    private Tab overviewTab;

    @FXML
    private Tab newCustomerTab;

    @FXML
    private Tab newEmployeeTab;

    public static int employeePin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader();
        try {
            AnchorPane anch1 = loader.load(getClass().getResource("/sample/View/Order.fxml"));
            orderTab.setContent(anch1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not Found");
        }
        loader = new FXMLLoader();
        try {
            AnchorPane anch2 = loader.load(getClass().getResource("/sample/View/Transaction.fxml"));
            transactionTab.setContent(anch2);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not Found");
        }
        loader = new FXMLLoader();
        try {
            AnchorPane anch3 = loader.load(getClass().getResource("/sample/View/NewCustomer.fxml"));
            newCustomerTab.setContent(anch3);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not Found");
        }
        loader = new FXMLLoader();
        try {
            AnchorPane anch4 = loader.load(getClass().getResource("/sample/View/NewEmployee.fxml"));
            newEmployeeTab.setContent(anch4);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not Found");
        }
    }
        public void setEmployeePin(int employeePin){
        this.employeePin = employeePin;

        }
        public int getEmployeePin(){
            return employeePin;
        }
}
