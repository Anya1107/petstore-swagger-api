package by.sample.petstore.resource;

import by.sample.petstore.model.User;
import by.sample.petstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserResource {
    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        userService.add(user);
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{username}")
    public ResponseEntity<?> delete(@PathVariable String username){
        userService.delete(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/getByName/{username}")
    public ResponseEntity<User> getByName(@PathVariable String username){
        if(userService.getByName(username) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        User user = userService.getByName(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<User>> getAll(){
        List<User> all = userService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody User user){
        userService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        UUID uuid = userService.login(email, password);
        if(uuid != null) {
            return new ResponseEntity<>(uuid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<?> logout(@RequestParam String email, @RequestParam String password){
        UUID uuid = userService.login(email, password);
        if(uuid != null) {
            userService.logout(uuid);
            return new ResponseEntity<>(uuid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
