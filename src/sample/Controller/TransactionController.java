package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Helper.DatabaseHandler;
import sample.Model.EmpCusFilter;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView viewTable;

    @FXML
    private TableColumn<EmpCusFilter, Integer> orderIdColumn;

    @FXML
    private TableColumn<EmpCusFilter, String> customerColumn;

    @FXML
    private TableColumn<EmpCusFilter, String> employeeColumn;

    @FXML
    private TableColumn<EmpCusFilter, String> orderItemsColumn;

    @FXML
    private TableColumn<EmpCusFilter, BigDecimal> orderTotalColumn;

    @FXML
    private TableColumn<EmpCusFilter, String> paymTypeColumn;

    @FXML
    private TableColumn<EmpCusFilter, Timestamp> orderDateColumn;

    private ObservableList<EmpCusFilter> viewList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        viewList = FXCollections.observableArrayList();
        databaseHandler.getView(viewList);
        viewTable.setItems(viewList);
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("Customer"));
        employeeColumn.setCellValueFactory(new PropertyValueFactory<>("Employee"));
        orderItemsColumn.setCellValueFactory(new PropertyValueFactory<>("OrderItems"));
        orderTotalColumn.setCellValueFactory(new PropertyValueFactory<>("OrderTotal"));
        paymTypeColumn.setCellValueFactory(new PropertyValueFactory<>("PaymentType"));
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));

    }
}
