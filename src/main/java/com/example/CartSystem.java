package com.example;

import java.util.HashMap;
import java.util.Map;

public class CartSystem extends TheSystem {
//    HashMap<String, Item> itemCollection = getItemCollection();

    CartSystem() {
    }

//    @Override
//    public Item remove(String item_name) {
////        Item removedItem = this.itemCollection.get(item_name);
////        if(this.itemCollection.containsKey(item_name)) {
////            this.itemCollection.remove(item_name);
////        }//if statement
////        return removedItem;
//    }

    @Override
    public void display() {
        // Your code here
        //This is bullet point 3: All the items in the cart are displayed,
        //the system then calculates the sub-total by calculating the total sum of the products of the
        //orice and quantity of each item in the cart.
//        for (Map.Entry<String, Item> entry : itemCollection.entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());

        //***Question: Why doesn't this Lambda work???
//        shoppingCart.forEach(k,v) -> {
//            System.out.println(k + v);
//        }//Lambda

        //Monday night attempt.
        if() {
        itemCollection.forEach((k,v) -> System.out.printf("k: %-10s v: %-10s %-10s" +
                " %-10d\n", k, v.getItemDesc(), v.getItemPrice(), v.getAvailableQuantity()));
        }
    }//display()


}//CartSystem
