package com.example;

import java.util.HashMap;
import java.util.Map;

public class CartSystem extends TheSystem {
    HashMap<String, Item> shoppingCart = getShoppingCart();
    CartSystem() {
    }

    @Override // this overwrites the parents class add method
    public Boolean add(Item item) {
        // Your code here
        if (item == null) {
            return false;
        }//if item == null
        if (this.shoppingCart.containsKey(item.getItemName())) {
            System.out.printf("%s is already in the  Shopping Cart.", item.getItemName());
            return false;
        }//if contains (item)
        if (!this.shoppingCart.containsKey(item.getItemName()))
            setShoppingCart(item.getItemName(), item);
        return true;
    }//add(Item item)

    @Override
    public Item remove(String item_name) {
        Item removedItem = this.shoppingCart.get(item_name);
        if(this.shoppingCart.containsKey(item_name)) {
            this.shoppingCart.remove(item_name);
        }//if statement
        return removedItem;
    }

    @Override
    public void display() {
        // Your code here
        //This is bullet point 3: All the items in the cart are displayed,
        //the system then calculates the sub-total by calculating the total sum of the products of the
        //orice and quantity of each item in the cart.
        for (Map.Entry<String, Item> entry : shoppingCart.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        //***Question: Why doesn't this Lambda work???
//        shoppingCart.forEach(k,v) -> {
//            System.out.println(k + v);
//        }//Lambda
    }//display()


}//CartSystem
