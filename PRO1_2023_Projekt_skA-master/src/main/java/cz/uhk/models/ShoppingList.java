package cz.uhk.models;

import com.google.gson.annotations.Expose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    @Expose(serialize = true, deserialize = true)
    private String name;
    @Expose(serialize = true, deserialize = true)
    private List<ShoppingItem> items;
    @Expose(serialize = false, deserialize = false)
    private List<ActionListener> listeners = new ArrayList<>();

    public ShoppingList(){
        name = "Seznam";
        items = new ArrayList<>();
    }
    public List<ShoppingItem> getItems() {
        return items;
    }
    public void setItems(List<ShoppingItem> items){
        this.items = items;
        raiseEventItemsChanged();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addActionListener(ActionListener add){
        listeners.add(add);
    }
    public void addItem(ShoppingItem newItem){
        items.add(newItem);
        raiseEventItemsChanged();
    }
    private void raiseEventItemsChanged(){
        for (ActionListener al :
                listeners) {
            al.actionPerformed(new ActionEvent(this, 1, "itemsChanged"));
        }
    }
}
