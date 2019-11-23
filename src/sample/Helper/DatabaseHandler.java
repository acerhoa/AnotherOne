package sample.Helper;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import sample.Model.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;


import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" + dbHost + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
//    Create
    public void addEmployee(Employee employee){
        String insert = "INSERT INTO " + Constant.EMPLOYEE_TABLE + "(" +
                Constant.EMPLOYEE_EMPPIN + "," +
                Constant.EMPLOYEE_EMPNAME + "," +
                Constant.EMPLOYEE_EMPSTATUS + ")" +
                "VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1,employee.getEmpPin());
            preparedStatement.setString(2,employee.getEmpName());
            preparedStatement.setString(3,employee.getEmpStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer){
        String insert = "INSERT INTO " + Constant.CUSTOMER_TABLE + "(" +
                Constant.CUSTOMER_CUSNAME + ")" +
                "VALUES(?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,customer.getCusName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(Order order) {
        String insertOrder = "INSERT INTO " + Constant.ORDER_TABLE + "(" +
                Constant.ORDER_CUSID + "," +
                Constant.ORDER_EMPPIN + "," +
                Constant.ORDER_ORDERITEMS + "," +
                Constant.ORDER_PAYMENTTYPE + "," +
                Constant.ORDER_ORDERTOTAL + ")" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insertOrder);
            preparedStatement.setInt(1, order.getCusId());
            preparedStatement.setInt(2, order.getEmpPin());
            preparedStatement.setString(3,order.getOrderItems());
            preparedStatement.setString(4, order.getPaymentType());
            preparedStatement.setBigDecimal(5, order.getOrderTotal());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addOrderLine(OrderLine orderLine){
        String insertOrderLine = "INSERT INTO " + Constant.ORDERLINE_TABLE + "(" +
                Constant.ORDERLINE_ORDERID + "," +
                Constant.ORDERLINE_MENUID  + ")" +
                "VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insertOrderLine);
            preparedStatement.setInt(1,orderLine.getOrderId());
            preparedStatement.setInt(2,orderLine.getMenuId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    Read
    public ResultSet getCustomers() {
        ResultSet resultCustomers = null;
        String query = "SELECT * FROM " + Constant.CUSTOMER_TABLE;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            resultCustomers = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultCustomers;
    }

    public ResultSet getMenuItem(int itemNum){
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + Constant.MENU_TABLE + " WHERE " + Constant.MENU_MENUITEMID + "=" + itemNum;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getIdByName(String customerName){
        ResultSet resultSet = null;
        String query = "SELECT " + Constant.CUSTOMER_CUSID + " FROM " + Constant.CUSTOMER_TABLE + " WHERE " +
                Constant.CUSTOMER_CUSNAME +"=\"" + customerName + "\"";
        System.out.println(query);
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet anotherJuan(String itemName){
        ResultSet resultSet = null;
        String query = "SELECT " + Constant.MENU_MENUITEMID + " From " + Constant.MENU_TABLE + " WHERE " + Constant.MENU_MENUITEMNAME + "=\"" + itemName + "\"";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getOrderId (){
        ResultSet resultSet = null;
        String query = "SELECT COUNT(*) FROM " + Constant.ORDER_TABLE;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet verifyPin(Employee employee){
        ResultSet resultSet = null;
        String query = " SELECT * FROM " + Constant.EMPLOYEE_TABLE + " WHERE " + Constant.EMPLOYEE_EMPPIN + "=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1,employee.getEmpPin());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

//    public void getView(ObservableList viewList, TableView viewTable){
//        ResultSet resultSet = null;
//        String query = "SELECT * FROM EmpCusFilter";
//        try {
//            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
//                    row.add(resultSet.getString(i));
//
//                }
//                viewList.add(row);
//            }
//            viewTable.setItems(viewList);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//    }
    public void getView(ObservableList viewList){
        ResultSet resultSet = null;
        String query = "SELECT * FROM EmpCusFilter";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                EmpCusFilter empCusFilter = new EmpCusFilter();
                empCusFilter.setOrderId(resultSet.getInt(Constant.EMPCUSFILTER_ORDERID));
                empCusFilter.setCustomer(resultSet.getString(Constant.EMPCUSFILTER_CUSTOMER));
                empCusFilter.setEmployee(resultSet.getString(Constant.EMPCUSFILTER_EMPLOYEE));
                empCusFilter.setOrderItems(resultSet.getString(Constant.EMPCUSFILTER_ORDERITEMS));
                empCusFilter.setOrderTotal(resultSet.getBigDecimal(Constant.EMPCUSFILTER_ORDERTOTAL));
                empCusFilter.setPaymentType(resultSet.getString(Constant.EMPCUSFILTER_PAYMENTTYPE));
                empCusFilter.setOrderDate(resultSet.getTimestamp(Constant.EMPCUSFILTER_ORDERDATE));
                viewList.add(empCusFilter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


//    Update

//    Delete



