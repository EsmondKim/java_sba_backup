package com.example;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class AppSystem extends TheSystem {
    DecimalFormat df = new DecimalFormat("0.00");
    HashMap<String, Item> itemCollection = getItemCollection();

    AppSystem() {
    }//AppSystem

    @Override
    public void display() {
        // Your code here
        System.out.println("App System Inventory:");
        System.out.printf("%-20s %-20s %-20s %-10s \n", "Name:", "Description:", "Price:", "Available Quantity:");
        itemCollection.forEach((k,v) -> System.out.printf("%-20s %-20s %-20s" +
                " %-10d\n", k, v.getItemDesc(), df.format(v.getItemPrice()), v.getAvailableQuantity()));
        //Lambda
    }//display()

    @Override      // this overwrites the parents class add method
    public Boolean add(Item item) {
        // Your code here
        if (item == null) {
            return false;
        }//if item == null
        if (this.itemCollection.containsKey(item.getItemName())) {
            System.out.printf("%s is already in the  App System.", item.getItemName());
            return false;
        }//if contains (item)
        if (!this.itemCollection.containsKey(item.getItemName()))
            setItemCollection(item.getItemName(), item);
        return true;
    }//add(Item item)

    public Item reduceAvailableQuantity(String item_name) {
        // Your code here
        if (itemCollection.containsKey(item_name)) {
            itemCollection.get(item_name).setAvailableQuantity(itemCollection.get(item_name).getAvailableQuantity() - 1);
                if ( itemCollection.get(item_name).getAvailableQuantity() == 0) {
                        remove(item_name);
                }//nested if
                return itemCollection.get(item_name);
        }//if containsKey


        else {
            return null;
        }//else
    }//reduceAvailableQuantity()

}//TheSystem Class