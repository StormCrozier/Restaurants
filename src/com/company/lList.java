package com.company;
/*
Storm Crozier
8/24/2020
This is the lList class which defines what an lList is.  Protected members include a Util object and a lNode head for the head of the list.
Functions include a constructor, add, display, copy, and more
 */
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class lList {
    protected lNode head;
    protected Util Scan;

    public lList(){  //Constructor to initialize values to null
        head = null;
        Scan = new Util();
    }

    public void add(String toAdd) throws IOException {  //Add which calls add to list function
        //=========================================
        String [] split = toAdd.split("\n");
        for(int i = 0; i < split.length; ++i){
            addToList(split[i]);
        }
        return;
       //addToList
    }

    public void addToList(String toAdd){  //Add to list which calls recursive add to list function
        String [] split = toAdd.split("\\|");
        int start = 0;
        setHead(addToList(head, split , start, split.length));
        return;
    }

    public lNode addToList(lNode head, String [] toAdd, int num, int len){  //Recursive function which calls node add
        if(head == null) {
            head = new lNode();
            head.add(toAdd, num);
            return head;
        }
        head.setNext(addToList(head.returnNext(), toAdd, num, len));
        return head;
    }

    public void displayList(){  //Display list which calls recursive display list
        if(head == null) return;
        int num = 1;

        displayList(head, num);
    }

    public void displayList(lNode head, int num){  //Recursive display list which calls node display
        if(head == null) return;
        head.display();
        System.out.println("Item Number: " + num);
        num += 1;
        System.out.println("<><><><><><><><><><><><><><><><><>");
        displayList(head.returnNext(), num);
    }
    public void copyList(lList toCopy){  //Public copy list called by main which calls a recursive copy list function taking a list as an argument
        lNode sourceHead = toCopy.head;
        if(sourceHead == null) return;
        setHead(copyList(head, sourceHead));
    }

    protected lNode copyList(lNode head, lNode sourceHead){ //Recursive copy list which calls dNode copy to copy from seperate list
        if(sourceHead == null) return head;
        head = new lNode();
        sourceHead.copy(head);
        head.setNext(copyList(head.returnNext(), sourceHead.returnNext()));
        return head;
    }


    public void setHead(lNode toSet){ head = toSet; }  //Sets head to a node passed by argument
}
