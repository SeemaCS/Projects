package project.scu.edu.chew.models;

/**
 * Created by lakshitha on 3/9/16.
 */
public class CartItem {

    private String name;
    private double price;
    private int quantity;

    public CartItem() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
