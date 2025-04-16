package com.fpi.tiennv.lab5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ROG
 */
import java.util.Stack;
public class DeleteStackAndSeachElement {
    public static void main(String[]args){
        Stack<Integer> stk = new Stack<>();
        
System.out.println("Element is removed and removed from the stack: " + stk.pop());
//Retrieve and delete element 45
System.out.println("Element is removed and removed from the stack: " + stk.pop());
//Retrieve and delete element 11
System.out.println("Element is removed and removed from the stack: " + stk.pop());
//Stack after deleting 3 elements
System.out.println("Element Stack after deleting 3 elements: " + stk);

//Search element 90
int result = stk.search(90);
System.out.println("Element position 90: " + result);
//Search element 100 does not exist
int result2 = stk.search(100);
System.out.println("Element position 100: " + result2);

    }
}
