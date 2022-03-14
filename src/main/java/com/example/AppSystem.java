package com.example;

import java.util.HashMap;
import java.util.Map;

public class AppSystem extends TheSystem {
    HashMap<String, Item> itemCollection = getItemCollection();

    AppSystem() {
    }//AppSystem

    @Override
    public void display() {
        // Your code here
        //This is bullet point 2: TheSystem displays all of the available items in the app system
        //and asks the user to enter the name of an item to be added to the cart.
//        System();
        itemCollection.forEach((k,v) -> System.out.printf("k: %-10s v: %-10s %-10s" +
                " %-10d\n", k, v.getItemDesc(), v.getItemPrice(), v.getAvailableQuantity()));
        //Lambda
    }//display()

    @Override      // this overwrites the parents class add method
    //This is absolutely using the Item constructor with specific parameters
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
//            this.itemCollection.put(item.itemName(), item);
        return true;
    }//add(Item item)

    public Item reduceAvailableQuantity(String item_name) {
        // Your code here
        if (this.itemCollection.containsKey(item_name)) {
            this.item.setAvailableQuantity(this.item.getAvailableQuantity() - 1);
            return this.itemCollection.get(item_name);
        }//if containsKey
        else {
            return null;
        }//else
//        if (!this.itemCollection.containsKey(item_name))
//            return null;
        //else if !containsKey
    }//reduceAvailableQuantity()

}//TheSystem Class