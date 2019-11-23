package sample.Model;

public class Customer {
    private int cusId;
    public String cusName;

    public Customer() {
    }

    public Customer(int cusId, String cusName) {
        this.cusId = cusId;
        this.cusName = cusName;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String toString(){
        return cusName;
    }

}
