package by.sample.sample.resource;

import by.sample.sample.entity.Operation;
import by.sample.sample.entity.User;
import by.sample.sample.service.CalcService;
import by.sample.sample.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/history")
public class HistoryResource {
    private CalcService calcService;
    private UserService userService;

    public HistoryResource(CalcService calcService, UserService userService) {
        this.calcService = calcService;
        this.userService = userService;
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Operation>> getAll(){
        List<Operation> all = calcService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping(path = "/getAllByFilter/{operation}")
    public ResponseEntity<List<Operation>> getAll(@PathVariable String operation){
        switch (operation){
            case "sum":
                List<Operation> allBySum = calcService.getAllBySum();
                return new ResponseEntity<>(allBySum, HttpStatus.OK);
            case "razn":
                List<Operation> allByRazn = calcService.getAllByRazn();
                return new ResponseEntity<>(allByRazn, HttpStatus.OK);
            case "multi":
                List<Operation> allByMulti = calcService.getAllByMulti();
                return new ResponseEntity<>(allByMulti, HttpStatus.OK);
            case "dif":
                List<Operation> allByDif = calcService.getAllByDif();
                return new ResponseEntity<>(allByDif, HttpStatus.OK);
            default:
                return null;
        }
    }

    @GetMapping(path = "/getAllByUser/{id}")
    public ResponseEntity<List<Operation>> getAllByUser(@PathVariable int id){
        User byId = userService.getById(id);
        List<Operation> allByUser = calcService.getAllByUser(byId);
        return new ResponseEntity<>(allByUser, HttpStatus.OK);
    }
}
