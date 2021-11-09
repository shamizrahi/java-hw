/* 
 * Problem Set 2 Problem 6
 *
 * File: PalindromeTest
 *
 * Author: Sharon Mizrahi
 * Coutse: CS112, Boston University
 *
 * Purpose: This is a sample program performing basic input and
 * output in Java 
 */

import java.util.Scanner;

public class PalindromeTest {

    public static boolean isPalindrome( String s ) {
        
        s = s.toLowerCase(); // make str lower cases
        s = s.replaceAll("[^A-Za-z0-9]", ""); // replace all 
        s = s.replaceAll(" ","");

        boolean isPal = false;    
        int left = 0; //Variable for left side of str
        int right = s.length() - 1; // Variable for right side of str
        

            if (s.length() == 0 || s.length() == 1 ){ //single letter = true
                isPal = true;
            } 
            while (left <= right){ //while left side <= to right side enter this loop
                if(s.charAt(left) != s.charAt(right)){ //different letters = false
                isPal = false;
                break; // end loop

                }else{ 
                isPal = true; 
                }
            left++; //post increment and decrement will keep looping through each char.
            right--; 

            }
            return isPal;
        }


    public static int[] inputStringPalindrome() {

        // Array and inputs variables
        int[] result = new int[2]; // returned array with: times the isPalindrome method was called, and how many inputs were palindromes.
        int MethodCount = 0; //count of palidrome method calling
        int isPalCount = 0; //count of how many inputs are palindromes 
        result[0] = MethodCount;
        result[1] = isPalCount;

        //Scanner variable
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nType in a word or sentence or \"quit\" to end: ");


        while (userInput.hasNextLine()) {  //loop starts when a line is inputed
            String line = userInput.nextLine();
            if (line.equals("quit")){  //Quitting que user inputs quit
                System.out.println("\nThank you for participating");
            break;
            
            } else {
                result[0] += 1; // add one to Method count
                if (isPalindrome(line) == true){
                    result[1] += 1; // add one if input is a palidrome
                    System.out.println("Your input: " + line + " is a palindrome");
                    
                }else{
                    System.out.println("Your input: " + line + " is not palindrome");

                }

                System.out.println("\nType in a word or sentence or \"quit\" to end: "); 
                // if the while loop has not wuit yet, this print statement will keep loop going

            }
      
    } 
    userInput.close(); // closing loop
    return result; // returning array with update variable counts
    
  } 

    
    public static void main(String[] args) {

        System.out.println("\nWelcome to the Palindrome Test Program!");
        System.out.println("This demonstrates if your input is a Palindrome or not.");
        int result[] = inputStringPalindrome(); // calling the method
        
        
        System.out.println("\nYou called the method isPalindrome: " + result[0] + " times"); 
        System.out.println("\nYou entered: " + result[1] + " Palindrome(s)");
        System.out.println("\nGoodbye!");

   
     } 

}