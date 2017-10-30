/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem
 */

public class ArrayStack {
    
    // Instance variables
    // Array that stores all the integers on the stack
    private int[] stack;
    
    // Keep track of how many items
    private int numItems;
    
    public ArrayStack(){
        stack = new int[10]; 
        numItems = 0;
    }

    // Methods that 
    public void push(int item){
        
        // If there is room on the stack
        if (numItems < stack.length){
            // Put item on the stack
            stack[numItems] = item;
            
            // Adding one to the variable numItems
            numItems ++;
            
        // If there is no room on the stack  
        }else{
            // Make more room
            int [] temp = new int[stack.length*2];
            
            // Copy items from array over 
            for (int i = 0; i < stack.length; i++){
                temp[i] = stack[i];
            }
            
            // Stack becomes new array
            stack = temp;
            
            // Add item to the stack array
            stack[numItems] = item;
            // Add one to the number of items
            numItems++;
        }
    }
        
    // Method that removes the top item in the stack
    public int pop(){
        // Get the top item from the stack
        int item = stack[numItems - 1];        
        // One less item
        numItems --;
        
        // Give back item
        return item;
    }
    
    // Method that returns the size of the array
    public int size(){
        return numItems;
    }
    
    // Method that returns the top item from a stack
    public int peek(){
        return stack[numItems - 1];
    }
    
    // Booelean method that returns if the stack is empty or not
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        // Object used to run methods
        ArrayStack stack = new ArrayStack();
        
        // Checking if the stack is empty
        System.out.println("Empty: " + stack.isEmpty());
        
        // Adding 12 to the stack
        stack.push(12);
        
        // Checking if the stack is empty
        System.out.println("Empty: " + stack.isEmpty());
        // Getting the top item of the stack
        System.out.println("Peek: " + stack.peek());
        // Getting the size of the stack
        System.out.println("Size: " + stack.size());
        
        // Getting the popped item (Taking out the top one)
        int item = stack.pop();
        
        // Outputting the popped item 
        System.out.println("Popped Item: " + item);
        // Outputting if the stack is empty or not
        System.out.println("Empty: " + stack.isEmpty());

        // For loop that adds items to the array
        for (int i = 0; i < 100; i++){
            // Adding the numbers to the stack
            stack.push(i);
        }
        
        // Outputting the size of the stack
        System.out.println("Size: " + stack.size());
        // Outputting the top item in the stack
        System.out.println("Peek: " + stack.peek());
        
        // Getting the popped item (Taking out the top one)
        stack.pop();
        
        // Outputting the top item in the stack
        System.out.println("Peek: " + stack.peek());

    }
    
}
