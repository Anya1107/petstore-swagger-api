package by.sample.petstore.resource;

import by.sample.petstore.model.Pet;
import by.sample.petstore.model.PetStatus;
import by.sample.petstore.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetResource {
    private PetService petService;

    public PetResource(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Pet> add(@Valid @RequestBody Pet pet){
        petService.add(pet);
        return new ResponseEntity<Pet>(pet, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{petId}")
    public ResponseEntity<?> delete(@PathVariable int petId){
        petService.deleteById(petId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/getById/{petId}")
    public ResponseEntity<Pet> getById(@PathVariable int petId){
        if(petService.getById(petId) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Pet byId = petService.getById(petId);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping(path = "/getByStatus")
    public ResponseEntity<Pet> getByStatus(@RequestParam PetStatus petStatus){
        if(petService.getByStatus(petStatus) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Pet byStatus = petService.getByStatus(petStatus);
        return new ResponseEntity<>(byStatus, HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Pet>> getAll(){
        List<Pet> all = petService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Pet pet){
        petService.update(pet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
