package com.company;
/*
Storm Crozier
8/24/2020
This is the Boba class used to represent the boba drink.  This class is also derived from the food class and has its own fields, which
include a flavor and yes/no or a true/false for if they want sweet tapioca/boba
 */
public class Boba extends Food {
    protected String flavor;
    protected String sweetTapioca;

    public Boba(){  //This is the constructor which calls the base class constructor and sets its own fields to null
        super();
        flavor = null;
        sweetTapioca = null;
    }

    public void display() { //This is the display function displaying the name of the food item, base class fields, and its own fields
        System.out.println("Boba Tea");
        super.display();
        if(flavor!= null) System.out.print("Flavor: "); System.out.println(flavor);
        if(sweetTapioca != null) System.out.print("Sweet Tapioca: "); System.out.println(sweetTapioca);
    }

    public int add(String toAdd){  //Adds a string to its own fields and calls base class add
        int x = super.add(toAdd);
        if(x != 1) {
            if(flavor == null) {
                flavor = toAdd;
                x = 1;
            }
            if(sweetTapioca == null  && x != 1) {
                sweetTapioca = toAdd;
                x = 1;
            }
        }
        return x;
    }

    public Food copy(Food toCopy){   //Takes a boba object by argument and copies fields
        toCopy = new Boba();
        super.copy(toCopy);
        ((Boba) toCopy).flavor = flavor;
        ((Boba) toCopy).sweetTapioca = sweetTapioca;
        return toCopy;
    }
}
