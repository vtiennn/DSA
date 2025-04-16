/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpi.tiennv.lab1;
import java.util.Scanner;
public class Demo {
    public static void main(String[]agrs){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int number  = scanner.nextInt();
        scanner.close();
        
        if (number <= 1){
            System.out.println(number +" is not a prime number.");
        }else{
            boolean isPrime = true;
            for (int i = 2;  i <= Math.sqrt(number);i++){
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.println(number+" is a prime number.");
            }else{
                System.out.println(number+" is not a prime number.");
            }
        }
    }
}
