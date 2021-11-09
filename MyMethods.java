/* 
 * Problem Set 2 Problem 5
 *
 * File: MyMethos.java
 *
 * Author: Sharon Mizrahi
 * Coutse: CS112, Boston University
 *
 * Purpose: Create methods using operators, for loops and conditional statements
 */


public class MyMethods {

    public static void printDecreasing(String str){

        int i; // int to measure the str length for slicing in the loop. 
        for(i = 0; i < str.length(); i++) {
            System.out.println(str.substring( 0, str.length() - i )); // using slicing operator
            // the for loop will keep slicing the str until the length is less than 0
        }

    }

    public static String firstAndLast(String str){

        if (str.length() > 1)
            return str.substring(0, 1) + str.charAt(str.length() - 1); //Using slicing and idenxing
            //Slicing first letter and idexing last letter
        else
            return str; // else condition goes for chars 
        
    }

    public static int lastIndexOf(String str, char ch){

        int index = -1; // setting index to -1 so if ch == not valid then it will return -1
        
        for(int i = 0; i < str.length(); i++){ //Evaluating every possible char value in the str
           
        if(str.charAt(i) == ch){  // if index(i) is equal to the ch 
            index = i;   // make index = 1 which is a int value that lead to ch location
        }
    }
        return index;
    }

    public static String repeat(String str, int n){
        
        String result = " "; // initial value

        for (int i = 1; i <= n; i++){
        result += str; // adding str to result n times
        }
        return result; // final value
    }


    public static void main( String[] args ) {
        
        ///Method printDecreasing
        printDecreasing("method");


        /// Method firstAndLast
        System.out.println(firstAndLast("Boston"));
        System.out.println(firstAndLast("University"));
        System.out.println(firstAndLast("a"));

        /// Method lastIndexOf
        System.out.println(lastIndexOf("Boston", 'o'));
        System.out.println(lastIndexOf("banana", 'a'));
        System.out.println(lastIndexOf("banana", 'b'));
        System.out.println(lastIndexOf("banana", 'x'));

        /// Method repeat
        System.out.println(repeat("Java", 3));
        System.out.println(repeat("oh!", 7));

    }
    
}
