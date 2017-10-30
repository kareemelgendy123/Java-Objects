package CardGame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem
 */

public class Human {

    // Define instance variables
    // Instance variables must be private
    private String name;
    private int age;
    private char gender;
    
    // Constructor;
    // Used to create undividual humans
    // 'Setup' a human to use
    // this.variable will use the specific variable in the class
    public Human(String name, int age, char gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    // Method that returns the name
    public String getName(){ 
        return name;
    }
    
    // Method that returns the age
    public int getAge(){ 
        return age;
    }
    
    // Method that celebrates the person's birthday 
    public void celebrateBirthday(){
        // Increase human age
        age ++;
        // Wish them a happy birthday
        System.out.println();
        System.out.println("Happy Birthday " + this.name + "!");
    }
      
    // Method that returns the gender
    public char getGender(){ 
        return gender;
    }
    public static void main(String[] args) {

        // Human named bob - print personal information
        Human bob  = new Human("Bob", 20, 'M');
        System.out.println("Name: " + bob.getName());
        System.out.println("Age: " + bob.getAge());
        System.out.println("Gender: " +bob.getGender());
        
        // Human named alice - print personal information
        Human alice = new Human("Alice", 51, 'F');
        System.out.println();
        System.out.println("Name: " + alice.getName());
        System.out.println("Age: " + alice.getAge());
        System.out.println("Gender: " +alice.getGender());
        
        // Its alices birthday - print ages
        alice.celebrateBirthday();
        System.out.println("Alice's new age: " + alice.getAge());
        System.out.println("Bob's new age: " + bob.getAge());

    }
    
}
