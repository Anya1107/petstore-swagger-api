package by.sample.sample.resource;

import by.sample.sample.entity.User;
import by.sample.sample.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserResource {
    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<User> add(@RequestBody User user, HttpSession httpSession){
        User user1 = new User(user.getName(), user.getEmail(), user.getPassword());
        userService.add(user1);
        httpSession.setAttribute("user", user1);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable int id){
        User byId = userService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping(path = "/getByName/{name}")
    public ResponseEntity<User> getByName(@PathVariable String name){
        User byName = userService.getByName(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<User>> getAll(){
        List<User> all = userService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
