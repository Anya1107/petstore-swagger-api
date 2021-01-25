package by.sample.petstore.storage;

import by.sample.petstore.model.Category;
import by.sample.petstore.model.Pet;
import by.sample.petstore.model.PetStatus;
import by.sample.petstore.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetStorage {
    private List<Pet> pets = new ArrayList<>();
    private static int incId = 1;

    public void add(Pet pet){
        pet.setId(incId++);
        pets.add(pet);
    }

    public void deleteById(int id){
        for (Pet pet : pets) {
            if(pet.getId() == id){
                pets.remove(pet);
                break;
            }
        }
    }

    public Pet getById(int id){
        for (Pet pet : pets) {
            if(pet.getId() == id){
                return pet;
            }
        }
        return null;
    }

    public Pet getByStatus(PetStatus petStatus){
        for (Pet pet : pets) {
            if(pet.getStatus().equals(petStatus)){
                return pet;
            }
        }
        return null;
    }

    public List<Pet> getAllByStatus(PetStatus petStatus){
        List<Pet> pets1 = new ArrayList<>();
        for (Pet pet : pets) {
            if(pet.getStatus().equals(petStatus)){
                pets1.add(pet);
            }
        }
        return pets1;
    }

    public List<Pet> getAll(){
        return pets;
    }

    public void updateName(int id, String name){
        for (Pet pet : pets) {
            if(pet.getId() == id){
                pet.setName(name);
            }
        }
    }

    public void updateTag(int id, Tag tag){
        for (Pet pet : pets) {
            if(pet.getId() == id){
                pet.setTag(tag);
            }
        }
    }

    public void updateCategory(int id, Category category){
        for (Pet pet : pets) {
            if(pet.getId() == id){
                pet.setCategory(category);
            }
        }
    }

    public void updateStatus(int id, PetStatus petStatus){
        for (Pet pet : pets) {
            if(pet.getId() == id){
                pet.setStatus(petStatus);
            }
        }
    }
}
