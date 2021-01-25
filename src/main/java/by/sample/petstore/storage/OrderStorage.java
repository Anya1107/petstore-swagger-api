package by.sample.petstore.storage;

import by.sample.petstore.model.Order;
import by.sample.petstore.model.PetStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderStorage {
    private List<Order> orders = new ArrayList<>();
    private static int incId = 1;

    public void add(Order order){
        order.setId(incId++);
        orders.add(order);
    }

    public void delete(int id){
        for (Order order : orders) {
            if(order.getId() == id){
                orders.remove(order);
                break;
            }
        }
    }

    public Order getById(int id){
        for (Order order : orders) {
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }

    public List<Order> getAll(){
        return orders;
    }



//    public Map<PetStatus, Integer> getPetsByStatus(){
//        Map<PetStatus, Integer> pets = new HashMap<>();
//        for (Order order : orders) {
//
//        }
//    }

}
