package by.sample.petstore.service;

import by.sample.petstore.model.User;
import by.sample.petstore.storage.TokenStorage;
import by.sample.petstore.storage.UserStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserStorage userStorage;
    private TokenStorage tokenStorage;

    public UserService(UserStorage userStorage, TokenStorage tokenStorage) {
        this.userStorage = userStorage;
        this.tokenStorage = tokenStorage;
    }

    public void add(User user){
        userStorage.add(user);
    }

    public void delete(String username){
        userStorage.delete(username);
    }

    public User getByName(String username){
       return userStorage.getByName(username);
    }

    public List<User> getAll(){
        return userStorage.getAll();
    }

    public void update(User user){
        if(user.getFirstName() != null){
            userStorage.updateFirstName(user.getUsername(), user.getFirstName());
        }
        if(user.getLastName() != null){
            userStorage.updateLastName(user.getUsername(), user.getLastName());
        }
        if(user.getEmail() != null){
            userStorage.updateEmail(user.getUsername(), user.getEmail());
        }
        if(user.getPassword() != null){
            userStorage.updatePassword(user.getUsername(), user.getPassword());
        }
        if(user.getPhone() != null){
            userStorage.updatePhone(user.getUsername(), user.getPhone());
        }
    }

    public UUID login(String email, String password){
        User user = userStorage.getByEmail(email);
        if(user != null && user.getPassword().equals(password)){
            UUID uuid = UUID.randomUUID();
            tokenStorage.add(uuid);
            return uuid;
        }
        return null;
    }

    public boolean validate(UUID uuid){
        return tokenStorage.validate(uuid);
    }

    public void logout(UUID uuid){
        tokenStorage.delete(uuid);
    }
}

