package com.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartSystem extends TheSystem {
    HashMap<String, Item> itemCollection = getItemCollection();

    CartSystem() {
    }

    @Override
    public void display() {
        // Your code here
        System.out.printf("%-20s %-20s %-10s %-10s %-10s \n", "Name:", "Description:", "Price:", "Quantity:", "Subtotal: ");
        Iterator iCIterator = itemCollection.entrySet().iterator();
        while (iCIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)iCIterator.next();
            if (itemCollection.get(mapElement.getKey()).getQuantity() > 1) {
                System.out.printf( "%-20s %-20s %-10s %-10d\n", itemCollection.get(mapElement.getKey()).getItemName(), itemCollection.get(mapElement.getKey()).getItemDesc(), itemCollection.get(mapElement.getKey()).getItemPrice(), itemCollection.get(mapElement.getKey()).getQuantity() );
            }//nested If
        }//while iCIterator
            //This Lambda forEach worked, but you probably don't need to use it.
//          itemCollection.forEach((k,v) -> System.out.printf("k: %-10s v: %-10s %-10s %-10d\n", k, v.getItemDesc(), v.getItemPrice(), v.getAvailableQuantity()));
    }//display()

}//CartSystem
