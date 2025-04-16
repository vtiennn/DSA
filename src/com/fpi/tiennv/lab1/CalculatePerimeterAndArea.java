/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpi.tiennv.lab1;
import java.util.Scanner;
public class CalculatePerimeterAndArea {
    public static void main(String[]agrs){
    Scanner scanner = new Scanner(System.in);
        System.out.println("Input the lenght og the rectangle: ");
        double lenght = scanner.nextDouble();
        System.out.println("Input the width of the rectangle: ");
        double width = scanner.nextDouble();
        double perimeter = 2 * (lenght + width);
        double area = lenght * width;
        System.out.println("\nRectangle Properties: ");
        System.out.println("Lenght: "+ lenght);
        System.out.println("Width: "+ width);
        System.out.println("Perimeter: "+ perimeter);
        System.out.println("Area: "+ area);
        scanner.close();
    }
}
