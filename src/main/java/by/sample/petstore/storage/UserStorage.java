package by.sample.petstore.storage;

import by.sample.petstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserStorage {
    private List<User> users = new ArrayList<>();
    private static int incId = 1;

    public void add(User user){
        user.setId(incId++);
        users.add(user);
    }

    public void delete(String username){
        for (User user : users) {
            if(user.getUsername().equals(username)){
                users.remove(user);
                break;
            }
        }
    }

    public User getByName(String username){
        for (User user : users) {
            if(user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public User getByEmail(String email){
        for (User user : users) {
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public List<User> getAll(){
        return users;
    }

    public void updateFirstName(String username, String firstName){
        User user = getByName(username);
        user.setFirstName(firstName);
    }

    public void updateLastName(String username, String lastName){
        User user = getByName(username);
        user.setLastName(lastName);
    }

    public void updateEmail(String username, String email){
        User user = getByName(username);
        user.setEmail(email);
    }

    public void updatePassword(String username, String password){
        User user = getByName(username);
        user.setPassword(password);
    }

    public void updatePhone(String username, String phone){
        User user = getByName(username);
        user.setPhone(phone);
    }
}
