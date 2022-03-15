package com.example;

import javax.sound.midi.Soundbank;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartSystem extends TheSystem {
    HashMap<String, Item> itemCollection = getItemCollection();
    DecimalFormat df = new DecimalFormat("0.00");
    Double cartSubtotal = 0.0;
    Double salesTax = 0.05;

    CartSystem() {
    }

    @Override
    public void display() {
        // Your code here
        System.out.println("Cart: ");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s \n", "Name:", "Description:", "Price:", "Quantity:", "Subtotal: ");
        Iterator iCIterator = itemCollection.entrySet().iterator();
        while (iCIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)iCIterator.next();
            if (itemCollection.get(mapElement.getKey()).getQuantity() > 0) {
                Double itemSubtotal = itemCollection.get(mapElement.getKey()).getItemPrice() * itemCollection.get(mapElement.getKey()).getQuantity();
                System.out.printf( "%-20s %-20s %-10s %-10d %10s\n", itemCollection.get(mapElement.getKey()).getItemName(), itemCollection.get(mapElement.getKey()).getItemDesc(),  df.format(itemCollection.get(mapElement.getKey()).getItemPrice()), itemCollection.get(mapElement.getKey()).getQuantity(), df.format(itemSubtotal) );
                cartSubtotal += itemSubtotal;
            }//nested If
        }//while iCIterator
            //This Lambda forEach worked, but you probably don't need to use it.
//          itemCollection.forEach((k,v) -> System.out.printf("k: %-10s v: %-10s %-10s %-10d\n", k, v.getItemDesc(), v.getItemPrice(), v.getAvailableQuantity()));
        Double cartSalesTax = cartSubtotal * salesTax;
        Double total = cartSubtotal + cartSalesTax;
        System.out.printf( "%-20s %20s\n", "Pre-tax total", df.format(cartSubtotal) );
        System.out.printf( "%-20s %20s\n", "Tax", df.format(cartSalesTax) );
        System.out.printf( "%-20s %20s\n", "Total", df.format(total) );
        cartSubtotal = 0.0;
        cartSalesTax = 0.0;
        total = 0.0;
    }//display()

}//CartSystem
