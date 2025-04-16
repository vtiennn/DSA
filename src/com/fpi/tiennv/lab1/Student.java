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
public class Student {
    private String name;
    private int age;
    
    public Student(String name, int age){
         this.name = name;
         this.age = age;
    }
    public void displayInfo(){
        System.out.println("Name: "+ name);
        System.out.println("Age: "+ age);
    }
    public static void main(String[]agrs){
        Student ob = new Student("John",15);
        Student ob2 = new Student("Steve",16);
        ob.displayInfo();
        ob2.displayInfo();
    }
    
}
