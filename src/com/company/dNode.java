package com.company;
/*
Storm Crozier
8/16/2020
dNoe class file which houses all the information about a dNode.  Fields for this class include a base class food pointer to pointer
to a derived food object, as well as a dNode next and previous pointer.  Functions included in this file are add, copy, display, and more.

 */
public class dNode {
    protected Food foodPtr;
    protected dNode next;
    protected dNode prev;

    public dNode(){  //dNode constructor to initialize fields
        foodPtr = null;
        next = null;
        prev = null;
    }

    public void add(String toAdd, Util Scan){   //add function which determines the right object to be created and calls food add function
        if(toAdd.equals("Acai Bowl")){
            foodPtr = new Acai();
            for (int i = 0; i < 6; ++i){
                 toAdd = Scan.read.next();
                int x = foodPtr.add(toAdd);
            }
            return;
        }
        else if(toAdd.equals("Boba")){
            foodPtr = new Boba();
            for (int i = 0; i < 4; ++i){
                toAdd = Scan.read.next();
                int x = foodPtr.add(toAdd);
            }
            return;
        }
        else if(toAdd.equals("Mochiko Chicken")) {
            foodPtr = new Mochiko();
            for (int i = 0; i < 4; ++i) {
                toAdd = Scan.read.next();
                int x = foodPtr.add(toAdd);
            }
            return;
        }
    }

    public void copy(dNode toCopy){  //Copy function which calls food class copy function
        toCopy.foodPtr = foodPtr.copy(toCopy.foodPtr);
    }


    public void display(){  //Display function which calls food class display
        foodPtr.display();
    }

    public void setPrev(dNode toSet){  //Sets dNodes previous pointer to value passed by argument
        if(next != null)
            next.prev = toSet;
    }

    public void setNext(dNode toSet){  //Sets dNode next pointer to value passed by argument
        next = toSet;
    }

    public dNode returnNext(){  //Returns dNodes next pointer
        return next;
    }
}
