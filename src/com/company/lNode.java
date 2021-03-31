package com.company;
/*
Storm Crozier
8/24/2020
This is the lNode class which defines what an lNode is.  Protected members include a food object, and a lNode next.  Functions include
add, copy, display, return next, and set next
 */
public class lNode {
    protected Food foodPtr;
    protected lNode next;

    public lNode(){  //Constructor for lNode object
        foodPtr = null;
        next = null;
    }

    public void add(String toAdd[], int num){ //Adds to food object from string passed in
        if(toAdd[num].equals("Acai Bowl")){
            foodPtr = new Acai();
            for(int i = 0; i < 6; ++i){
                num += 1;
                foodPtr.add(toAdd[num]);
            }
            return;
        }
        else if(toAdd[num].equals("Boba")) {
            foodPtr = new Boba();
            for (int i = 0; i < 4; ++i) {
                num += 1;
                foodPtr.add(toAdd[num]);
            }
            return;
        }        if(toAdd[num].equals("Mochiko Chicken")) {
            foodPtr = new Mochiko();
            for (int i = 0; i < 4; ++i) {
                num += 1;
                foodPtr.add(toAdd[num]);
            }
            return;
        }
    }

    public void copy(lNode toCopy){  //Copy function which calls food class copy function
        toCopy.foodPtr = foodPtr.copy(toCopy.foodPtr);
    }

    public void display(){
        foodPtr.display();
    }  //Display which calls food class display

    public lNode returnNext(){ return next; }  //Returns next

    public void setNext(lNode toSet){
        next = toSet;
    }  //Sets next to value passed by argument

}

