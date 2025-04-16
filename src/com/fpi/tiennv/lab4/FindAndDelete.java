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
import java.util.Collections;
import java.util.Scanner;
public class FindAndDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> demo = new ArrayList<>();

        demo.add("Peter");
        demo.add("Lyly");
        demo.add("Maria");
        demo.add("Lisa");
        demo.add("Jisoo");
        demo.add("Rosé");
        demo.add("Jennie");

        System.out.println("Array before deleting: ");
        for (String i : demo) {
            System.out.println(i);
        }

        System.out.print("Name to delete: ");
        String name = sc.nextLine();

        for (String item : demo) {
            if (item.equals(name)) {
                demo.remove(name);
                break;
            }
        }

        System.out.println("Array after deleting: ");
        for (String i : demo) {
            System.out.println(i);
        }
    }
}
