package by.sample.sample.resource;

import by.sample.sample.entity.Operation;
import by.sample.sample.entity.User;
import by.sample.sample.service.CalcService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(path = "/calc")
public class CalcResource {
    private CalcService calcService;

    public CalcResource(CalcService calcService) {
        this.calcService = calcService;
    }

    @PostMapping(path = "/sum")
    public ResponseEntity<Operation> sum(@RequestBody Operation operation, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        double sum = calcService.sum(operation.getNum1(), operation.getNum2(), user);
        operation.setResult(sum);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping(path = "/razn")
    public Operation razn(@RequestBody Operation operation, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        double razn = calcService.razn(operation.getNum1(), operation.getNum2(), user);
        operation.setResult(razn);
        return operation;
    }


    @PostMapping(path = "/multi")
    public Operation multi(@RequestBody Operation operation, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        double multi = calcService.multi(operation.getNum1(), operation.getNum2(), user);
        operation.setResult(multi);
        return operation;
    }

    @PostMapping(path = "/dif")
    public Operation dif(@RequestBody Operation operation, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        double dif = calcService.dif(operation.getNum1(), operation.getNum2(), user);
        operation.setResult(dif);
        return operation;
    }


}
