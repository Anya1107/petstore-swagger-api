package by.sample.sample.service;

import by.sample.sample.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public void add(User user){
        users.add(user);
    }

    public void deleteById(int id){
        for (User user : users) {
            if(user.getId() == id){
                users.remove(user);
                break;
            }
        }
    }

    public User getById(int id){
        for (User user : users) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User getByName(String name){
        for (User user : users) {
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public List<User> getAll(){
        return users;
    }

}
