package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//import static jdk.internal.jshell.tool.Startup.readFile;

public abstract class TheSystem {
    Item item = new Item();
    private HashMap<String, Item> itemCollection = new HashMap<String, Item>();
    private HashMap<String, Item> shoppingCart = new HashMap<String, Item>();
    private File file = new File("C:\\Users\\ekele\\IdeaProjects\\SolutionCoreJavaSBA\\resources\\sample.txt");

    TheSystem() {
        // Your code here
        if(getClass().getSimpleName().equals("App System"))
            readFile();
    }//The System

    public void readFile() {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String itemInfo = sc.nextLine();
                String[] itemInfoSplit = itemInfo.split("\\s\\s");
                Item newItem = new Item(itemInfoSplit[0], itemInfoSplit[1], Double.valueOf(itemInfoSplit[2]), Integer.valueOf(itemInfoSplit[3]));
                itemCollection.put(itemInfoSplit[0], newItem);
            }//while input.hasNextLine()
        }//try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }//catch
    }//readFile method

//    public void System() {
//          readFile();
//    }

    public HashMap<String, Item> getItemCollection() {
        // Your code here
        return itemCollection;
    }//HashMap-getItemCollection method

    public void setItemCollection(String itemName, Item item) {
        // Your code here
        this.itemCollection.put(itemName, item);
    }//HashMap-setItemCollection method

     public HashMap<String, Item> getShoppingCart() {
        // Your code here
        return shoppingCart;
    }//HashMap-getItemCollection method

    public void setShoppingCart(String itemName, Item item) {
        // Your code here
        this.shoppingCart.put(itemName, item);
    }//HashMap-setItemCollection method

    public Boolean checkAvailability(Item item) {
        if (this.item.getAvailableQuantity() == null) {
            return true;
        }//getAvailableQuantity null checker
        if (this.item.getQuantity() >= this.item.getAvailableQuantity()) {
            System.out.printf("System is unable to add %s ", item.getItemName() + "to the cart.  System only has %d%s ", item.getAvailableQuantity(), item .getItemName()+ "[s].");
            return false; }//if quantities checker
            else
         {   return true; }//else
    }//checkAvailability method

    public Boolean add(Item item) {
        if (item == null) {
            return false;
        }//if
        else if (this.itemCollection.containsKey(item.getItemName()) && this.itemCollection.containsKey(item.getAvailableQuantity())) {
            this.item.setQuantity(this.item.getQuantity() + 1);
            return true;
        }//else if contains
        else if(!this.itemCollection.containsKey(item.getItemName())) {
            setItemCollection(item.getItemName(), item);
            return true;
        }//else if doesn't contain
        else {
            return false;
        }//else
    }// add Method

    public Item remove(String itemName) {
        Item removedItem = this.itemCollection.get(itemName);
        if(this.itemCollection.containsKey(itemName)) {
            this.itemCollection.remove(itemName);
        }//if statement
        return removedItem;
    }//remove()

    public abstract void display();

}//The System public, abstract, class


