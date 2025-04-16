/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpi.tiennv.lab1;

/**
 *
 * @author ROG
 */
public class MainStudent1 {
    public static void main(String[]args){
        Student1 st1 = new Student1(1,"An");
        Student1 st2 = new Student1(1,"Binh");
        Student1 st3 = new Student1(1,"Thanh");
        
        Student1 st4 = new Student1();
        
        int tamid1 = st1.getId();
        System.out.println("ID: " + tamid1);
        
        int tamid2 = st2.getId();
        System.out.println("ID: " + tamid2);
        
        int tamid3 = st3.getId();
        System.out.println("ID: " + tamid3);
        
        int tamid4 = st4.getId();
        System.out.println("ID: " + tamid4);
    }
}
