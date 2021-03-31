package com.company;
/*
Storm Crozier
8/16/2020
This is the main/client program for program 5.  This is used to test the OOP and data structure of the assignment. The tree object
is read in from the restaurant file.  This file has a the restaurant name and a mock menu.  The only function defined in this file is
getUserResponse which prompts the user for input.
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        Tree tree = new Tree();
        Tree newTree = new Tree();
        Restaurant copy = new Restaurant();

        tree.add();

        int i = getUserResponseTree();
        while(i != 0){
            if(i ==1){
                tree.display();
            }
            if(i ==2){
                tree.retrieve(copy);
                System.out.println("Restaurant:");
                copy.display();
            }
            if(i == 3){
               tree.remove();
            }
            if(i ==4){
                tree.removeAll();
            }
            if(i == 5){
                newTree.copy(tree);
                System.out.println("New Tree: ");
                newTree.display();
            }
            if(i == 9){
                tree.add();
            }
            i = getUserResponseTree();
        }

    }



    public static int getUserResponseTree(){  //Get user response to get the users response
        int i = 0;
        Util Scan = new Util();
        System.out.println("Enter a 1 to display Restaurants");
        System.out.println("Enter a 2 to retrieve a Restaurant");
        System.out.println("Enter a 3 to remove a Restaurant");
        System.out.println("Enter a 4 to remove all Restaurants");
        System.out.println("Enter a 5 to copy to a new Tree");
        System.out.println("Enter a 9 to reload Restaurants (After deleting)");
        System.out.println("Enter a 0 quit");
        i = Scan.input.nextInt();
        Scan.input.nextLine();
        return i;
    }
}
