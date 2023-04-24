package cz.uhk.models;

import java.io.FileNotFoundException;

public interface FileOperations {
    ShoppingList load();
    void write(ShoppingList model);
}
