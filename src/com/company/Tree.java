package com.company;
/*
Storm Crozier
8/24/2020
This is the tree class used to create an tree object.  The members included in the tree class are a Node root pointer and a
Util can to read in from a file.  Methods include add, display, retrieve, remove, remove all, copy, and more
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tree {
    protected Node root;
    protected Util Scan;

    public Tree(){  //Default constructor initializing values to null
        root = null;
        Scan = new Util();
    }

    public Tree(Tree copyFrom){  //Constructor to initialize a tree to an existing tree
        copy(copyFrom);
    }

    public void add() throws IOException { //Adds restaurants from a file to its tree also calls recursive function
        File file = new File("src/com/company/Restaurant");
        Scan.setFile(file);
        String name;
        String toAdd;
        while(Scan.read.hasNextLine()){
            name = Scan.read.nextLine();
            Scan.read.useDelimiter("New Line");
            toAdd = Scan.read.next();
            if (root == null)
                setRoot(add(root, name, toAdd));
            else add(root, name, toAdd);
            if(Scan.read.hasNextLine()) Scan.read.nextLine();
        }
    }

    protected Node add(Node root, String name, String toAdd) throws IOException {  //Recursive add to add restaurants to tree
        if(root == null){
            root = new Node();
            root.add(name, toAdd);
            return root;
        }
        int i = root.compare(name);
        if(i > 0 || i == 0){ root.setRight(add(root.returnRight(), name, toAdd)); }
        else{root.setLeft(add(root.returnLeft(), name, toAdd)); }
        return root;
    }

    public void display(){  //Displays tree calling recursive display
        if(root == null) {
            System.out.println("No tree to display");
            return;
        }
        display(root);
    }

    protected void display(Node root){  //Recursively goes through tree and calls node display
        if(root == null) return;
        display(root.returnLeft());
        root.display();
        display(root.returnRight());
    }

    public void retrieve(Restaurant copyTo){  //Retrieve which takes a restaurant object to copy too also calls recursive function
        System.out.println("Enter Restaurant name: ");
        String name = Scan.input.nextLine();
        retrieve(root, name, copyTo);
        if(copyTo == null) System.out.println("Restaurant could not be found");
    }

    protected void retrieve(Node root, String name, Restaurant copyTo){  //Recursive retrieve which calls node copy when it finds the right node
        if(root == null) return;
        int i = root.compare(name);
        if(i == 0){
           copyTo.copy(root.restaurant);
           return;
        }
        if(i > 0) retrieve(root.returnRight(), name, copyTo);
        else retrieve(root.returnLeft(), name, copyTo);
    }

    public void remove(){  //Remove which prompt the user to what restaurant to remove and calls recursive remove
        System.out.println("Enter Restaurant to be removed");
        String name = Scan.input.nextLine();
        setRoot(remove(root, name));
    }

    public Node remove(Node root, String toRemove){  //Recursive remove which finds the right node and removes it
        if(root == null) return root;
        int i = root.compare(toRemove);
        if(i == 0){
           if(root.left == null && root.right == null){
               root = null;
               return root;
           }
           else if(root.left != null && root.right == null){
               root = root.returnLeft();
               return root;
           }
           else if(root.left == null && root.right != null){
               root = root.returnRight();
               return root;
           }
           else{
               Restaurant Ios = null;
               int count = 0;
               Ios = findIos(root.returnRight(), Ios);
               deleteIos(root.returnRight(), count);
               root.copy(Ios);
               return root;
           }

        }
        if (i > 0) root.setRight(remove(root.returnRight(), toRemove));
        else root.setLeft(remove(root.returnLeft(), toRemove));
        return root;
    }

    public void removeAll(){  //Remove all which calls recursive remove all
        if(root == null) return;
        setRoot(removeAll(root));
    }

    public Node removeAll(Node root){  //Recursive remove all to remove all nodes from tree
        if(root == null) return root;
        root.setLeft(removeAll(root.returnLeft()));
        root.setRight(removeAll(root.returnRight()));
        root = null;
        return root;
    }

    protected Restaurant findIos(Node root, Restaurant Ios){  //Finds the ios of a node
        if(root == null) return Ios;
        Ios = findIos(root.returnLeft(), Ios);
        if(Ios == null){
            Ios = root.restaurant;
        }
        return Ios;
    }

    protected Node deleteIos(Node root, int count){  //Deletes the ios of a node
        if(root == null) return root;
        root.setLeft(deleteIos(root.returnLeft(), count));
        if(count < 1){
            if(root.right != null){
                root = root.returnRight();
            }
            else root = null;
            count += 1;
            return root;
        }
        return root;
    }

    public void copy(Tree copyFrom){  //Copy tree to copy from another tree
        if(copyFrom == null) return;
        Node sourceRoot = copyFrom.root;
        setRoot(copy(root, sourceRoot));
    }

    protected Node copy(Node root, Node copyFrom){ //Recursive copy which calls node copy
       if(copyFrom == null) return root;
       root = new Node();
       root.copy(copyFrom.restaurant);
       root.setLeft(copy(root.returnLeft(), copyFrom.returnLeft()));
       root.setRight(copy(root.returnRight(), copyFrom.returnRight()));
       return root;
    }

    protected void setRoot(Node toSet){ root = toSet; } //Sets the roots node equal to a node passed by argument
}
