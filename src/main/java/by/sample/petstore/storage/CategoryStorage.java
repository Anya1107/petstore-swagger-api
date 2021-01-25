package by.sample.petstore.storage;

import by.sample.petstore.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryStorage {
    private List<Category> categories = new ArrayList<>();
    private static int incId = 1;

    public void add(Category category){
        category.setId(incId++);
        categories.add(category);
    }
}
