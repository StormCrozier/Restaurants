package com.company;
/*
Storm Crozier
8/24/2020
This is the base class that all other food classes are derived from.  Function included int this file include add, copy, and display.
All derived function share have the same function signature to implement dynamic binding.
 */
abstract public class Food extends Util {
    protected String size;
    protected String price;

    public Food(){ //Constructor to set values to null
        this.size = null;
        this.price = null;
    }

    public int add(String toAdd){ //Adds a string to either the size or price of the food item
        if(size == null) {
            this.size = toAdd;
            return 1;
        }
        else if(price == null) {
            this.price = toAdd;
            return 1;
        }
        return 0;
    }

    public Food copy(Food toCopy){  //Takes in a food object to be copied from and copies the values
        toCopy.size = size;
        toCopy.price = price;
        return toCopy;
    }

    public void display(){ //If there is something to be displayed then the function will display the size and pricegtgtgt
        if(!size.isEmpty()) System.out.print("Size/s: "); System.out.println(size);
        if(!price.isEmpty()) System.out.print("Price/s: " ); System.out.println(price);
    }
}
