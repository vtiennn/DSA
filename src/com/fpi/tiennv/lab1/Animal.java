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
 class Animal {
    
    private String name;
    private String species;
    public Animal(String name, String species){
        this.name = name;
        this.species = species;
    }
    public String getName(){
        return name;
    }
    public String getSpecies(){
        return species;
    }
    public static void main(String[]agrs){
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");
        System.out.println(dog.getName()+" the " + dog.getSpecies());
        dog.makeSound();
         System.out.println(cat.getName()+" the " + cat.getSpecies());
        cat.makeSound();
    }
}
 class Dog extends Animal {
    public Dog(String name){
    super(name, "Dog");
    }
    public void makeSound(){
        System.out.println("Woof!");
    }
}
class Cat extends Animal {
    public Cat(String name){
        super(name, "Cat");
    }
    public void makeSound(){
        System.out.println("Meow!");
    }
}

