package project.scu.edu.chew.models;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.database.User;

/**
 * Created by lakshitha on 3/9/16.
 */
public class UserSession {

    User user;
    List<CartItem> cartItems = new ArrayList<>();
    double totalValueInCart;
    int badgeCount;

    public UserSession() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalValueInCart() {
        return totalValueInCart;
    }

    public void setTotalValueInCart(double totalValueInCart) {
        this.totalValueInCart = totalValueInCart;
    }

    public int getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(int badgeCount) {
        this.badgeCount = badgeCount;
    }
}
