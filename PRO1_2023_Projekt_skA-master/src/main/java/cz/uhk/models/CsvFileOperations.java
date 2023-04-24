package cz.uhk.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileOperations implements FileOperations{
    private final static String FILE_NAME = "./shoppingList.csv";
    private final static char DELIMETER = ';';

    @Override
    public ShoppingList load() {
        //TODO load from file - 25.4.
        try{
            FileReader reader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            ShoppingList shoppingList = new ShoppingList();
            while((line = bufferedReader.readLine()) != null){
                String[] items = line.split(";");
                String name = items[0];
                double price = Double.parseDouble(items[1]);
                int pieces = Integer.parseInt(items[2]);
                ShoppingItem item = new ShoppingItem(name, price, pieces);
                shoppingList.addItem(item);
            }
            return shoppingList;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ShoppingList();
    }

    @Override
    public void write(ShoppingList model) {
        StringBuilder csvText = new StringBuilder();
        for (ShoppingItem item:
             model.getItems()) {
            csvText
                    .append(item.getName())
                    .append(DELIMETER)
                    .append(item.getPrice())
                    .append(DELIMETER)
                    .append(item.getPieces())
                    .append(DELIMETER)
                    .append(item.isBought())
                    .append("\n");
        }
        try{
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(csvText.toString());
            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
