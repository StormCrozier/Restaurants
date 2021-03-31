package com.company;
/*
Storm Crozier
8/16/2020
This is the first derived class.  This is the Boba class to represent Boba tea.  Since this is a derived class it still has a size and
price aspect.  The extra fields for this class include an array of strings to represent toppings, and granola to represent the type
of granola.
 */

public class Acai extends Food {
    protected String toppings[];
    protected String granola;

    public Acai() {  //Constructor for Acai sets all values to null and calls base class constructor
        super();
        toppings = new String[3];
        for (int i = 0; i < 3; ++i) {
            toppings[i] = null;
        }
        this.granola = null;
    }

    public void display() { //Displays the name of the class, base class fields, and its own fields.
        System.out.println("Acai Bowl");
        super.display();
        if (toppings[1] != null) {
            for (int i = 0; i < 3; ++i) {
                int x = i + 1;
                System.out.print("Topping " + x + ": ");
                System.out.println(toppings[i]);
            }
        }
        if (granola != null) System.out.print("Granola: "); System.out.println(granola);
    }

    public int add(String toAdd) {  //Adds a string to its own fields and calls base class add
        int x = super.add(toAdd);
        if (x != 1) {
            for (int i = 0; i < 3; ++i) {
                if (toppings[i] != null) continue;
                toppings[i] = toAdd;
                break;
            }
            granola = toAdd;
        }
        return x;
    }

    public Food copy(Food toCopy){  //Passes a Acai object by argument to be copied from.  Also calls base class copy
        toCopy = new Acai();
        super.copy(toCopy);
        for(int i = 0; i < 3; ++i){
            ((Acai) toCopy).toppings[i] = toppings[i];
        }
        ((Acai) toCopy).granola = granola;
        return toCopy;
    }
}
