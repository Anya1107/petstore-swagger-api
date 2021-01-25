package by.sample.petstore.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Pet {
    private int id;

    @NotBlank
    @Length(min = 2, max = 16)
    private String name;

    @NotNull
    private Tag tag;

    @NotNull
    private Category category;

    @NotNull
    private PetStatus petStatus;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PetStatus getStatus() {
        return petStatus;
    }

    public void setStatus(PetStatus petStatus) {
        this.petStatus = petStatus;
    }
}
