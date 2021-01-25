package by.sample.petstore.storage;

import by.sample.petstore.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TagStorage {
    private List<Tag> tags = new ArrayList<>();
    private static int incId = 1;

    public void add(Tag tag){
        tag.setId(incId++);
        tags.add(tag);
    }
}
