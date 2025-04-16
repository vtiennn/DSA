/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpi.tiennv.lab3;

/**
 *
 * @author ROG
 */
public class RecursionAlgorithms {
    
    // Recursive function to calculate factorial of n
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        // Best case: n = 0 or 1
        int bestCase = factorial(0);
        System.out.println("Best Case (n = 0): " + bestCase);
        
        // Average case: n = 10
        int averageCase = factorial(10);
        System.out.println("Average Case (n = 10): " + averageCase);
        
        // Worst case: n = 50
        int worstCase = factorial(50);
        System.out.println("Worst Case (n = 50): " + worstCase);
    }
}

