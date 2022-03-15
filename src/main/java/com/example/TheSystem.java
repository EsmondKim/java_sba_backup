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

    TheSystem() {
        // Your code here
        if(this.getClass().getSimpleName().equals("AppSystem")) {
            //variables below for HackerRank environment
            String path = "/resources";
            String filename = "/sample.txt";
            String curDir = System.getProperty("user.dir");
            try {
                    //Old absolute path variable for IntelliJ/local machine
//                File file = new File("C:\\Users\\ekele\\IdeaProjects\\SolutionCoreJavaSBA\\resources\\sample.txt");
                //File variable for HackerRank environment below.
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

//    IntelliJ's auto generated setItemCollection code
//    public void setItemCollection(HashMap<String, Item> itemCollection) {
//        this.itemCollection = itemCollection;
//    }

    public Boolean checkAvailability(Item item) {
//        if (this.item.getAvailableQuantity() == null) {
//            return false;
//        }//getAvailableQuantity null checker
        if (item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.printf("System is unable to add %s ", item.getItemName() + "to the cart.  System only has %d%s ", item.getAvailableQuantity(), item .getItemName()+ "[s].");
            return false; }//if quantities checker
            else
         {   return true; }//else
    }//checkAvailability method

    public Boolean add(Item item) {
        if (item == null) {
            return false;
        }//if
        else if (itemCollection.containsKey(item.getItemName()) && itemCollection.containsKey(item.getAvailableQuantity() > 1))
        {
            this.item.setQuantity(item.getQuantity() + 1);
            return true;
        }//else if contains
        else if(!itemCollection.containsKey(item.getItemName())) {
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


