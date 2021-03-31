package com.company;
/*
Storm Crozier
8/16/2020
This is the dList class file.  This class uses a dNode for a head and a tail pointer since this is a doubly linked list.
This file also include a Util Scan object so I can scan from a file.  Functions included in this class are add, copy, display,
remove, and retrive.
 */
import java.io.File;
import java.io.IOException;

public class dList {
    protected dNode head;
    protected dNode tail;
    protected int numItems;
    protected Util Scan;

    public dList(){ //dList constructor to initialize fields
        head = null;
        tail = null;
        Scan = new Util();
    }

    public dList(dList copyFrom){
        copyList(copyFrom);
    }

    public void retrieve(dNode copyTo){
        System.out.println("Enter item number to be retrieved: ");
        int x = Scan.input.nextInt();
        Scan.input.nextLine();
        int count = 1;
        retrieve(head, copyTo, count, x);
    }

    protected void retrieve(dNode head, dNode copyTo, int count, int num){
        if(head == null) return;
        if(count == num){
            head.copy(copyTo);
            return;
        }
        count += 1;
        retrieve(head.returnNext(), copyTo, count, num);
    }

    public void copyList(dList toCopy){  //Public copy list called by main which calls a recursive copy list function taking a list as an argument
        dNode sourceHead = toCopy.head;
        if(sourceHead == null) return;
        setHead(copyList(head, sourceHead));
    }

    protected dNode copyList(dNode head, dNode sourceHead){ //Recursive copy list which calles dNode copy to copy from seperate list
        if(sourceHead == null) return head;
        head = new dNode();
        sourceHead.copy(head);
        head.setNext(copyList(head.returnNext(), sourceHead.returnNext()));
        head.setPrev(head);
        return head;
    }

    public void addFromFile() throws IOException{   //Add from file function which takes a file path and calls a recursive add
        File file = new File("src/com/company/Foods");
        Scan.setFile(file);
        Scan.read.useDelimiter("\\|");
        String toAdd = Scan.read.next();
        setHead(addFromFile(head, toAdd, Scan));
        }

    protected dNode addFromFile(dNode head, String toAdd, Util Scan){  //Recursive add which calls dNode add takes a scan object, string and head
        if(!Scan.read.hasNextLine()) return head;
        head = new dNode();
        tail = head;
        head.add(toAdd, Scan);
        numItems += 1;
        Scan.read.nextLine();
        toAdd = Scan.read.next();

        head.setNext(addFromFile(head.returnNext(), toAdd, Scan));
        head.setPrev(head);
        return head;
    }

    public void displayList(){  //Public display list which display size information and the users list of foods also calls recursive function
        if(head == null) return;
        int num = 1;
        System.out.println("Sizes: Small, Medium, Large");
        System.out.println("------------------------");
        System.out.println("Acai Bowl:");
        System.out.println("Small: 8oz bowl");
        System.out.println("Medium: 12oz bowl");
        System.out.println("Large: 14oz bowl");
        System.out.println("------------------------");
        System.out.println("Boba Tea:");
        System.out.println("Small: 8oz cup");
        System.out.println("Medium: 12oz cup");
        System.out.println("Large: 16oz cup");
        System.out.println("------------------------");
        System.out.println("Mochicko Chicken:");
        System.out.println("Small: 8 pieces");
        System.out.println("Medium: 12 pieces");
        System.out.println("Large: 16 pieces");
        System.out.println("------------------------");

        System.out.println("Your List:");
        System.out.println("------------------------");

        displayList(head, num);
    }

    protected void displayList(dNode head, int num){  //Recursive display which calls node display to display list
       if(head == null) return;
       head.display();
       System.out.println("Item Number: " + num);
       num += 1;
       System.out.println("<><><><><><><><><><><><><><><><><>");
       displayList(head.returnNext(), num);
    }

    public void removeItem(){   //Public remove function, gets item number to be removed and calls recursive remove function
        System.out.println("Enter item number to be removed: ");
        int x = Scan.input.nextInt();
        Scan.input.nextLine();
        x -= 1;
        if(x == 0){
            head = head.returnNext();
            head.setPrev(null);
            return;
        }
        int num = 1;
        Scan.input.nextLine();
        removeItem(head, x, num);
    }

    protected dNode removeItem(dNode head, int itemNum, int num){  //Recursive remove which remove a node from the list
        if(head == null) return head;
        if(num == itemNum){
            dNode temp = head;
            head = head.returnNext();
            if(head != tail){
                temp.setNext(head.returnNext());
                head = head.returnNext();
                head.setPrev(temp);
                return temp;
            }
            else {
                tail = temp;
                tail.setNext(null);
                return tail;
            }
        }
        num += 1;
        head.setNext(removeItem(head.returnNext(), itemNum, num));
        return head;
    }

    public void setHead(dNode toSet){   //Sets head to a value passes in by argument
        head = toSet;
    }
}
