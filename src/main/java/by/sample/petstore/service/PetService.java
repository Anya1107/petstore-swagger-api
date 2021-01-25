package by.sample.petstore.service;

import by.sample.petstore.model.Pet;
import by.sample.petstore.model.PetStatus;
import by.sample.petstore.storage.CategoryStorage;
import by.sample.petstore.storage.PetStorage;
import by.sample.petstore.storage.TagStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private PetStorage petStorage;
    private TagStorage tagStorage;
    private CategoryStorage categoryStorage;

    public PetService(PetStorage petStorage, TagStorage tagStorage, CategoryStorage categoryStorage) {
        this.petStorage = petStorage;
        this.tagStorage = tagStorage;
        this.categoryStorage = categoryStorage;
    }

    public void add(Pet pet){
        tagStorage.add(pet.getTag());
        categoryStorage.add(pet.getCategory());
        petStorage.add(pet);
    }

    public void deleteById(int id){
        petStorage.deleteById(id);
    }

    public Pet getById(int id){
        return petStorage.getById(id);
    }

    public Pet getByStatus(PetStatus petStatus){
        return petStorage.getByStatus(petStatus);
    }

    public List<Pet> getAllByStatus(PetStatus petStatus){
        return petStorage.getAllByStatus(petStatus);
    }

    public List<Pet> getAll(){
        return petStorage.getAll();
    }

    public void update(Pet pet){
        if(pet.getName() != null) {
           petStorage.updateName(pet.getId(), pet.getName());
        }
        if(pet.getTag() != null){
            petStorage.updateTag(pet.getId(), pet.getTag());
        }
        if(pet.getCategory() != null){
            petStorage.updateCategory(pet.getId(), pet.getCategory());
        }
        if(pet.getStatus() != null){
            petStorage.updateStatus(pet.getId(), pet.getStatus());
        }
    }
}
