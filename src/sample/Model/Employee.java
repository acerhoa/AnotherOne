package sample.Model;

public class Employee {
    private int empId;
    private int empPin;
    private String empName;
    private String empStatus;

    public Employee() {
    }

    public Employee(int empId, int empPin, String empName, String empStatus) {
        this.empId = empId;
        this.empPin = empPin;
        this.empName = empName;
        this.empStatus = empStatus;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpPin() {
        return empPin;
    }

    public void setEmpPin(int empPin) {
        this.empPin = empPin;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }
}
