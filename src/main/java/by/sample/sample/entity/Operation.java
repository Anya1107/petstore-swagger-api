package by.sample.sample.entity;

public class Operation {
    private double num1;
    private double num2;
    private double result;
    private String operation;
    private User user;

    public Operation(double num1, double num2, double result, String operation, User user) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
        this.user = user;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
