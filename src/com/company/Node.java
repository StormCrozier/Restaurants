package com.company;
/*
Storm Crozier
8/24/2020
This is the Node class which defines what a node is and its members.  Protected members include a Restaurant object and two node pointers
one for the left and one for the right.  Functions include constructor, add, display, compare, copy, and more.
 */

import java.io.IOException;

public class Node {
    protected Restaurant restaurant;
    protected Node left;
    protected Node right;

    public Node(){ //Constructor to initialize members to null;
        restaurant = new Restaurant();
        left = null;
        right = null;
    }

    public void add(String name, String toAdd) throws IOException {  //Adds a Restaurant to object
        restaurant.addFromFile(name, toAdd);
    }

    public void display(){  //Displays a nodes Restaurant
        restaurant.display();
    }

    public int compare(String name){  //Compares two node
        int x = restaurant.compare(name);
        return x;
    }

    public void copy(Restaurant copyFrom){  //Copies from another node
        restaurant.copy(copyFrom);
    }

    public Node returnLeft(){ return left; }  //Returns left pointer

    public Node returnRight(){ return right; }  //Returns right pointer

    public void setLeft(Node toSet){ left = toSet; }  //Sets left pointer to a node passed by argument


    public void setRight(Node toSet){ right = toSet; }  //Sets right pointer to a node passed by argument


}
