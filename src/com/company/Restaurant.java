package com.company;
/*
Storm Croizer
8/24/2020
This is the restaurant class which defines what a restaurant is and what it can do.  Protected members include a string to represent
the restaurant name and a lList object to represent the restaurants menu.  Methods include constructor, add, display, copy, and compare.
 */
import java.io.IOException;

public class Restaurant {
    protected String name;
    protected lList menu;

    public Restaurant(){  //Constructor to initialize values to null
        name = null;
        menu = new lList();
    }

    public void addFromFile(String nameTo, String menuTo) throws IOException {  //Adds to menu from strings passed by argument
       name = nameTo;
       menu.add(menuTo);
    }

    public void display(){  //Displays a restaurant and its menu
        System.out.println("Restaurant Name: ");
        System.out.println(name);
        System.out.println("================");
        System.out.println("Menu: ");
        System.out.println("<><><><><><><><><><>");
        menu.displayList();
    }

    public void copy(Restaurant copyFrom){  //Copies from one restaurant into current object
        name = copyFrom.name;
        menu.copyList(copyFrom .menu);
    }

    public int compare(String compareTo){  //Compares a Restaurant by string passed by argument
        int i = compareTo.compareTo(name);
        return i;
    }
}
