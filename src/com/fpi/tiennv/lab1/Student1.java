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
public class Student1 {
    private int id;
    private String fullName;
    
    public Student1(){
    }
    public Student1(int id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
}

