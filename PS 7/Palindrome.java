/*
 * Palindrome.java
 */
import java.util.*;

public class Palindrome {
    // Add your definition of isPal here.

    public static boolean isPal(String str){
        if(str == null){
            throw new IllegalArgumentException("Null? really? you can do better");
        }

        String strlower = str.toLowerCase(); //making string lowercase
        int length = str.length(); // variable for length

        if(str.equals("") || str.length() == 1){ //length is 1 or empty = true
            return true;
        }else{
            LLStack<Character> primero = new LLStack<Character>(); //stack in order
            LLStack<Character> segundo = new LLStack<Character>(); // strack from end

            for(int i = 0; i < length; i++){

                if(strlower.charAt(i) >= 97 && strlower.charAt(i) <= 122){ //only letters for chars
                    primero.push(strlower.charAt(i)); // push to stack
                }

            }
            // System.out.println(primero.toString());
            
            for(int i = length-1; i >= 0; i--){

                if(strlower.charAt(i) >= 97 && strlower.charAt(i) <= 122){
                    segundo.push(strlower.charAt(i));
                }

            }

            // System.out.println(segundo.toString());

            while(!primero.isEmpty()){ 

                if(primero.pop().equals(segundo.pop())){ //compare stack elements
                    return true;
                }else{
                    break; //break if different
                }
                    
            }

        }

        return false; 
    }

    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * Add five more unit tests that test a variety of different
         * cases. Follow the same format that we have used above.
         */
        // Test 1
        System.out.println("(1) Testing on \"Caramelos y Viniles\"");
        try {
            boolean results = isPal("Caramelos y Viniles");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();  

        // Test 2
        System.out.println("(1) Testing on \"X\"");
        try {
            boolean results = isPal("X");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();  

        // Test 3
        System.out.println("(1) Testing on \"\"");
        try {
            boolean results = isPal("");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();  

        // Test 4
        System.out.println("(1) Testing on \"Si yo fuera rico! pararalalalalalalalalala!!!\"");
        try {
            boolean results = isPal("Si yo fuera rico! pararalalalalalalalalala!!!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();  

        // Test 5
        System.out.println("(5) Testing on \"Anita lava la tina\"");
        try {
            boolean results = isPal("Anita lava la tina");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();  

    }

    
}