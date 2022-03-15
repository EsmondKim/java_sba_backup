package com.example;
 public class Item{
//Fields
private String itemName;
private String itemDesc;
private Double itemPrice;
private Integer quantity;
private Integer availableQuantity;
//Constructors
    public Item() {
        this.quantity = 1;
    }

    public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
            // Your code here
            this.itemName = itemName;
            this.itemDesc = itemDesc;
            this.itemPrice = itemPrice;
            this.availableQuantity = availableQuantity;
            this.quantity = 1;
        }//Constructor

//Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAvailableQuantity() {
         return availableQuantity;
     }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
    //Getters and setters
}//Item class
