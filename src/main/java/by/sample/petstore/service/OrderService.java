package by.sample.petstore.service;

import by.sample.petstore.model.Order;
import by.sample.petstore.model.PetStatus;
import by.sample.petstore.storage.OrderStorage;
import by.sample.petstore.storage.PetStorage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private OrderStorage orderStorage;
    private PetStorage petStorage;

    public OrderService(OrderStorage orderStorage, PetStorage petStorage) {
        this.orderStorage = orderStorage;
        this.petStorage = petStorage;
    }

    public void add(Order order){
        orderStorage.add(order);
    }

    public void delete(int id){
        orderStorage.delete(id);
    }

    public Order getById(int id){
        return orderStorage.getById(id);
    }

    public List<Order> getAll(){
        return orderStorage.getAll();
    }

    public Map<PetStatus, Integer> getPetsByStatus(){
        Map<PetStatus, Integer> pets = new HashMap<>();
        pets.put(PetStatus.AVAILABLE, petStorage.getAllByStatus(PetStatus.AVAILABLE).size());
        pets.put(PetStatus.PENDING, petStorage.getAllByStatus(PetStatus.PENDING).size());
        pets.put(PetStatus.SOLD, petStorage.getAllByStatus(PetStatus.SOLD).size());
        return pets;
    }
}
