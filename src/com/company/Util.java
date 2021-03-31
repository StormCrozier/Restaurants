package com.company;
/*
Storm Crozier
8/24/2020
This is the util class which has two scanner objects one used for getting user input and one for reading in from a file.  Function are
limited to a constructor and set file.
 */
import java.io.*;
import java.util.Scanner;

public class Util {  //Constructor which initialize members to null
    protected Scanner input=null;
    protected Scanner read=null;
    public Util(){
        input = new Scanner(System.in);
    }

    public void setFile(File source) throws FileNotFoundException {  //Sets file passed by argument
        read = new Scanner(source);
    }

    public void setFile() throws IOException{  //Sets file to file path typed by user
        System.out.println("Enter name of file to read in from.");
        String file = input.nextLine();
        read = new Scanner(new File(file));
    }
}
