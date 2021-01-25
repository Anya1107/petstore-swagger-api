package by.sample.petstore.storage;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class TokenStorage {
    private List<UUID> uuids = new ArrayList<>();

    public void add(UUID uuid){
        uuids.add(uuid);
    }

    public boolean validate(UUID uuid){
        return uuids.contains(uuid);
    }

    public void delete(UUID uuid){
        uuids.remove(uuid);
    }
}
