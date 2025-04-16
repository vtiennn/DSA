
package com.fpi.it.tiennv;


public class Car {
    String brand;
    String color;
    int year;
    public void start(){
        System.out.println("The car is starting");  
    }
    public void stop(){
        System.out.println("The car is stoping");
    }
    public void brake(){
        System.out.println("The car is braking");
    }
    public static void main(String[]agrs){
        Car c1 = new Car();
        c1.brand = "Honda";
        System.out.println("Brand: "+ c1.brand);
        c1.color = "Red";
        System.out.println("Color: "+ c1.color);
        c1.year = 2025;
        System.out.println("Year: "+ c1.year);
        c1.start();
        c1.stop();
        c1.brake();
    }
}
