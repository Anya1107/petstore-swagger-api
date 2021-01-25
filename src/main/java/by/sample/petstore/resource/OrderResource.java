package by.sample.petstore.resource;

import by.sample.petstore.model.Order;
import by.sample.petstore.model.PetStatus;
import by.sample.petstore.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/order")
public class OrderResource {
    private OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Order order){
        orderService.add(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Order> getById(@PathVariable int id){
        Order byId = orderService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> all = orderService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping(path = "/getByStatus")
    public ResponseEntity<Map<PetStatus, Integer>> getByStatus(){
        Map<PetStatus, Integer> petsByStatus = orderService.getPetsByStatus();
        return new ResponseEntity<>(petsByStatus, HttpStatus.OK);
    }
}
