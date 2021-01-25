package by.sample.petstore.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

public class Order {
    private int id;

    @NotNull
    @Positive
    private int petId;

    @NotNull
    private int quantity;

    private Date date;

    @NotBlank
    private orderStatus orderStatus;

    @NotBlank
    private boolean isComplete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public by.sample.petstore.model.orderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(by.sample.petstore.model.orderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
