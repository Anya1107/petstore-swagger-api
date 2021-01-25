package by.sample.sample.service;

import by.sample.sample.entity.Operation;
import by.sample.sample.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcService {
    private List<Operation> operationList = new ArrayList<>();

    public double sum(double num1, double num2, User user){
        double result = num1 + num2;
        Operation operation = new Operation(num1, num2, result, "sum", user);
        operationList.add(operation);
        return result;
    }

    public double razn(double num1, double num2, User user){
        double result = num1 -num2;
        Operation razn = new Operation(num1, num2, result, "razn", user);
        operationList.add(razn);
        return result;
    }

    public double multi(double num1, double num2, User user){
        double result = num1 * num2;
        Operation multi = new Operation(num1, num2, result, "multi", user);
        operationList.add(multi);
        return result;
    }

    public double dif(double num1, double num2, User user){
        double result = num1 / num2;
        Operation dif = new Operation(num1, num2, result, "dif", user);
        operationList.add(dif);
        return result;
    }

    public List<Operation> getAll(){
        return operationList;
    }

    public List<Operation> getAllBySum(){
        List<Operation> operations = new ArrayList<>();
        for (Operation operation : operationList) {
            if(operation.getOperation().equals("sum")){
                operations.add(operation);
            }
        }
        return operations;
    }


    public List<Operation> getAllByRazn(){
        List<Operation> operations = new ArrayList<>();
        for (Operation operation : operationList) {
            if(operation.getOperation().equals("razn")){
                operations.add(operation);
            }
        }
        return operations;
    }

    public List<Operation> getAllByMulti(){
        List<Operation> operations = new ArrayList<>();
        for (Operation operation : operationList) {
            if(operation.getOperation().equals("multi")){
                operations.add(operation);
            }
        }
        return operations;
    }

    public List<Operation> getAllByDif(){
        List<Operation> operations = new ArrayList<>();
        for (Operation operation : operationList) {
            if(operation.getOperation().equals("dif")){
                operations.add(operation);
            }
        }
        return operations;
    }

    public List<Operation> getAllByUser(User user){
        List<Operation> operations = new ArrayList<>();
        for (Operation operation : operationList) {
            if(operation.getUser().equals(user)){
                operations.add(operation);
            }
        }
        return operations;
    }
}
