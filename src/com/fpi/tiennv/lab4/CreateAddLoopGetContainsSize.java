/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpi.tiennv.lab4;

/**
 *
 * @author ROG
 */
import java.util.ArrayList;

public class CreateAddLoopGetContainsSize {
   public static void main(String[] args) {
        // Declaring an ArrayList of String objects
        ArrayList<String> myList = new ArrayList<>();

        // Adding objects to the ArrayList at default index
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Orange");
        myList.add("Grapes");

        // Adding an object at a specific index
        myList.add(1, "Orange");
        myList.add(2, "Pineapple");

        System.out.println("Print all the objects:");
        for (String item : myList) {
            System.out.println(item);
        }

        System.out.println("Object at index 3: " + myList.get(3));
        System.out.println("Is 'Chicku' in the list? : " + myList.contains("Chicku"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Papaya");
        System.out.println("New size of ArrayList: " + myList.size());
    } 
}
