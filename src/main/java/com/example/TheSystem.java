package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class TheSystem {
    Item item = new Item();

    private HashMap<String, Item> itemCollection = new HashMap<String, Item>();

    TheSystem() {
        // Your code here
        if(this.getClass().getSimpleName().equals("AppSystem")) {
            String path = "/resources";
            String filename = "/sample.txt";
            String curDir = System.getProperty("user.dir");
            try {
                File file = new File(curDir + path, filename);
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
        }//if Statement
    }//The System

    public HashMap<String, Item> getItemCollection() {
        // Your code here
        return itemCollection;
    }//HashMap-getItemCollection method

    public void setItemCollection(String itemName, Item item) {
        // Your code here
        this.itemCollection.put(itemName, item);
    }//HashMap-setItemCollection method

    public Boolean checkAvailability(Item item) {
        if (item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.printf("System is unable to add %s to the cart. System only has %d %s \n",
                    item.getItemName(), item.getAvailableQuantity(), item.getItemName()
                     + "[s].\n");
            return false; }//if
            else
         {   return true; }//else
    }//checkAvailability method

    public Boolean add(Item item) {
        if (item == null) {
            return false;
        }//if
        else if (itemCollection.containsKey(item.getItemName()) && itemCollection.get(item.getItemName()).getQuantity() >= 1)
        {
            itemCollection.get(item.getItemName()).setQuantity(item.getQuantity() + 1);
            return true;
        }//else if contains
        else if(!itemCollection.containsKey(item.getItemName())) {
//            if(itemCollection.get(item_name).getQuantity() == 1) {
//                this.itemCollection.get(item_name).setQuantity(itemCollection.get(item_name).getQuantity() + 1);
//            }//nested if for quantity, to add subsequent identical items to the cart.
            setItemCollection(item.getItemName(), item);
            return true;
        }//else if doesn't contain
        else {
            return false;
        }//default else
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


