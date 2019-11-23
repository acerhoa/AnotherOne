package sample.Controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Helper.Constant;
import sample.Helper.DatabaseHandler;
import sample.Model.Customer;
import sample.Model.Menu;
import sample.Model.Order;

import javafx.scene.image.ImageView;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class OrderController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label totalLabel;

    @FXML
    private JFXComboBox selectCustomerBox;

    @FXML
    private JFXComboBox selectPaymentTypeBox;

    @FXML
    private TableView<Menu> txnsTable;

    @FXML
    private TableColumn<Menu, String> itemColumn;

    @FXML
    private TableColumn<Menu, BigDecimal> priceColumn;

    @FXML
    private JFXButton removeItemButton;

    @FXML
    private JFXButton itemOneButton;

    @FXML
    private JFXButton itemTwoButton;

    @FXML
    private JFXButton itemThreeButton;

    @FXML
    private JFXButton itemFourButton;

    @FXML
    private JFXButton itemFiveButton;

    @FXML
    private JFXButton itemSixButton;

    @FXML
    private JFXButton itemSevenButton;

    @FXML
    private JFXButton itemEightButton;

    @FXML
    private JFXButton itemNineButton;

    @FXML
    private JFXButton itemTenButton;

    @FXML
    private JFXButton itemElevenButton;

    @FXML
    private JFXButton addOrderButton;

    @FXML
    private JFXTextField itemCountField;

    @FXML
    private Label BANKIN;

    private int currentListCount = -1;
    private BigDecimal currentTotal = new BigDecimal(0);
    private ObservableList<Customer> cusList;
    private ObservableList paymentTypes;
    private ObservableList<Menu> txnsList;
    private ObservableList<Menu> itemIdList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paymentTypes = FXCollections.observableArrayList("Cash", "Credit");
        selectPaymentTypeBox.setItems(paymentTypes);
        cusList = FXCollections.observableArrayList();
        txnsList = FXCollections.observableArrayList();
        itemIdList = FXCollections.observableArrayList();
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemPrice"));
        try {
            CustomerBoxFiller(cusList);
            selectCustomerBox.setItems(cusList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        itemOneButton.setOnAction(event -> {
            itemButtons(1);
        });

        itemTwoButton.setOnAction(event -> {
            itemButtons(2);
        });

        itemThreeButton.setOnAction(event -> {
            itemButtons(3);
        });

        itemFourButton.setOnAction(event -> {
            itemButtons(4);
        });

        itemFiveButton.setOnAction(event ->{
            itemButtons(5);
        });

        itemSixButton.setOnAction(event ->{
            itemButtons(6);
        });

        itemSevenButton.setOnAction(event ->{
            itemButtons(7);
        });

        itemEightButton.setOnAction(event ->{
            itemButtons(8);
        });

        itemNineButton.setOnAction(event ->{
            itemButtons(9);
        });

        itemTenButton.setOnAction(event ->{
            itemButtons(10);
        });

        itemElevenButton.setOnAction(event ->{
            itemButtons(11);
        });

        addOrderButton.setOnAction(event -> {
            try {
                addOrderFunction(selectCustomerBox.getSelectionModel().selectedItemProperty().getValue().toString());
                txnsTable.getItems().clear();
                currentListCount = -1;
                currentTotal = new BigDecimal(0);
                totalLabel.setText("Total :");
                BANKIN.setText(""+currentTotal);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        removeItemButton.setOnAction(actionEvent -> {
            currentTotal = subToTotal(currentTotal, priceColumn.getCellObservableValue(txnsTable.getSelectionModel().getSelectedIndex()).getValue().toString());
            itemIdList.remove(txnsTable.getSelectionModel().getSelectedIndex());
            totalLabel.setText("Total :");
            BANKIN.setText(""+currentTotal);
            currentListCount--;
            removeItem();
        });
    }
    private static void CustomerBoxFiller(ObservableList<Customer> list) throws SQLException {
        DatabaseHandler handler = new DatabaseHandler();
        ResultSet resultSet;
        resultSet = handler.getCustomers();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCusId(resultSet.getInt(Constant.CUSTOMER_CUSID));
            customer.setCusName(resultSet.getString(Constant.CUSTOMER_CUSNAME));
            list.add(customer);
        }
    }

    private ObservableList TxnsListAdder(ObservableList<Menu> menuObservableList, int currentListCount, ObservableList itemIdList) throws SQLException {
        DatabaseHandler handler = new DatabaseHandler();
        ResultSet resultSet;
        resultSet = handler.getMenuItem(currentListCount);
        while (resultSet.next()) {
            Menu menu = new Menu();
            menu.setMenuItemId(resultSet.getInt(Constant.MENU_MENUITEMID));
            TxnsItemSetter(itemIdList,resultSet.getString(Constant.MENU_MENUITEMNAME));
            menu.setMenuItemName(resultSet.getString(Constant.MENU_MENUITEMNAME));
            menu.setMenuItemDescription(resultSet.getString(Constant.MENU_MENUITEMDESC));
            menu.setMenuItemPrice(resultSet.getBigDecimal(Constant.MENU_MENUITEMPRICE));
            menuObservableList.add(menu);
        }
        return menuObservableList;
    }

    private static void TxnsItemSetter(ObservableList itemIdList, String itemName){
        Menu anothergoddamnmenu = new Menu();
        anothergoddamnmenu.setMenuItemName(itemName);
        itemIdList.add(anothergoddamnmenu);
    }

    private static BigDecimal addToTotal(BigDecimal currentTotal, String itemPrice) {
        BigDecimal thisTotal = currentTotal;
        BigDecimal price = new BigDecimal(itemPrice);
        return thisTotal.add(price);
    }

    private static BigDecimal subToTotal(BigDecimal currentTotal, String itemPrice){
        BigDecimal thisTotal = currentTotal;
        BigDecimal price = new BigDecimal(itemPrice);
        return thisTotal.subtract(price);
    }

    private void addOrderFunction(String customerName) throws SQLException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getIdByName(customerName);
        while (resultSet.next()){
            Order newOrder = new Order();
            newOrder.setCusId(resultSet.getInt(Constant.CUSTOMER_CUSID));
            newOrder.setEmpPin(new AppController().getEmployeePin());
            newOrder.setOrderItems(itemIdList.toString());
            newOrder.setOrderTotal(currentTotal);
            newOrder.setPaymentType(selectPaymentTypeBox.getSelectionModel().selectedItemProperty().getValue().toString());
            databaseHandler.addOrder(newOrder);
        }
    }

    private void removeItem() {
        int ep = txnsTable.getSelectionModel().getSelectedIndex();
        if (ep>=0){
            txnsTable.getItems().remove(ep);
        }
    }

    private void itemButtons(int number){
        if (!itemCountField.getText().trim().equals("")) {
            String num = itemCountField.getText().trim();
            int itemAmount = Integer.parseInt(num);
            for (int i = 0; i < itemAmount; i++) {
                try {
                    txnsTable.setItems(TxnsListAdder(txnsList, number,itemIdList));
                    currentListCount++;
                    currentTotal = addToTotal(currentTotal, priceColumn.getCellObservableValue(currentListCount).getValue().toString());
                    totalLabel.setText("Total :");
                    BANKIN.setText(""+currentTotal);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                txnsTable.setItems(TxnsListAdder(txnsList, number,itemIdList));
                currentListCount++;
                currentTotal = addToTotal(currentTotal, priceColumn.getCellObservableValue(currentListCount).getValue().toString());
                totalLabel.setText("Total :");
                BANKIN.setText(""+currentTotal);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        itemCountField.setText("");
    }

}


