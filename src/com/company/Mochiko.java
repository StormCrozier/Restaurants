package com.company;
/*
Storm Crozier
8/24/2020
This is the Mochicko class used to represent Mochiko chiken(basically a form of fried chicken).  This is the last class to be derived from
the food class.  Fields specific to thi class and a yes/no or a true/false for is the user wants sauce and or furikake.
 */
public class Mochiko extends Food {
    protected String sauce;
    protected String furikake;

    public Mochiko(){  //Constructor for Mochiko class which calls base class constructor
        super();
        this.sauce = null;
        this.furikake = null;
    }

    public void display() { //Displays classes fields and calls base class display
        System.out.println("Mochiko Chicken");
        super.display();
        if(sauce != null) System.out.print("Sauce: "); System.out.println(sauce);
        if(furikake != null) System.out.print("Furikake: "); System.out.println(furikake);
    }

    public int add(String toAdd) {  //Adds a string to its own fields and calls base class add
        int x = super.add(toAdd);
        if(x != 1){
            if(sauce == null){
                sauce = toAdd;
                x = 1;
            }
            if(furikake == null){
                furikake = toAdd;
                x = 1;
            }
        }
        return x;
    }

    public Food copy(Food toCopy){  //Takes a Mochiko object by argument and copies fields
        toCopy = new Mochiko();
        super.copy(toCopy);
        ((Mochiko) toCopy).sauce = sauce;
        ((Mochiko) toCopy).furikake = furikake;
        return toCopy;
    }
}
