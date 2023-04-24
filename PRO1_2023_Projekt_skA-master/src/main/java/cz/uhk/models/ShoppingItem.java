package cz.uhk.models;

import com.google.gson.annotations.Expose;

public class ShoppingItem {
    @Expose(serialize = true, deserialize = true)
    private String name;
    @Expose(serialize = true, deserialize = true)
    private double price;
    @Expose(serialize = true, deserialize = true)
    private int pieces;
    @Expose(serialize = true, deserialize = true)
    private boolean bought;

    public ShoppingItem(String name, double price, int pieces) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
        this.bought = false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
