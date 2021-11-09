/* 
* BigInt.java
*
* A class for objects that represent non-negative integers of 
* up to 20 digits.
*/
import java.util.*;
public class BigInt  {
    // the maximum number of digits in a BigInt -- and thus the length
    // of the digits array
    private static final int SIZE = 20;
 
    // the array of digits for this BigInt object
    private int[] digits;
 
    // the number of significant digits in this BigInt object
    private int numSigDigits;
 
    /*
     * Default, no-argument constructor -- creates a BigInt that 
     * represents the number 0.
     */
    public BigInt() {
 
        this.digits = new int[SIZE];
        this.numSigDigits = 1;  // 0 has one sig. digit--the rightmost 0!
    }
 
    // private BigInt(int[] arr){ private method to validate dig.
 
 
    public BigInt(int[] arr){
        if (arr == null || arr.length > SIZE){
            throw new IllegalArgumentException("Array is NULL or Greated than Size"); // illegal argument for null values
            }
 
        this.digits = new int[SIZE]; //the digits field refering to Size
        int trailingZeros = 0;  // initializing count for significant values
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] < 0 || arr[i] > 9){
                throw new IllegalArgumentException("Digit not valid");
                /// invalid values for digits
            }
 
            digits[SIZE - arr.length +i] = arr[i];
 
            if (arr[i] == 0) { //counting 0s
                trailingZeros++;
            } else {
                trailingZeros = 0;
            }
        }
 
        numSigDigits = arr.length - trailingZeros; // eliminating 0s
    }
 
 
    public int getNumSigDigits(){ /// accessor methods returns value of private variable
        return numSigDigits;
    }
 
    public String toString(){
 
        StringBuilder num_arr = new StringBuilder();
        int num_dig = getNumSigDigits();
        int dig_ind = digits.length - num_dig;
 
        if(num_dig == 0){ // if we do not fin significant digits sttatch 0 to string
            num_arr.append('0'); 
        }else{
        for(int i = dig_ind; i < digits.length; i++){
            num_arr.append(digits[i]); //appending significant digits
            if(num_arr.charAt(0) == '0'){ // deliting 0s
                num_arr.deleteCharAt(0);
            }
        }
    }
    return num_arr.toString();
 
 }
 
    public BigInt(int n){
 
        if(n < 0){
            throw new IllegalArgumentException("n cannot be negative");
        }
 
        digits = new int[SIZE];
        for(int i = digits.length-1; n > 0; i--){  ///determining just the units digit from end to 0s
            int d = n % 10; //n has to be a single digit
            digits[i] = d; 
            n = n / 10; 
        }
 
        int count = 0; 
        for(int i = 0; i < digits.length; i++){
            if (digits[i] == 0){ //finding 0s
                count++; //adding 0s to count
            }else{
                break;
            }
        }
        numSigDigits = digits.length - count; //eliminating 0s
 
    }


    public int compareTo(BigInt other) {
 
        if (other == null){
            throw new IllegalArgumentException("Null"); // illegal argument for null values
        }
 
        if (this.getNumSigDigits()> other.getNumSigDigits() ){ //this has more digits
            return 1; 
 
        } else if (this.getNumSigDigits() < other.getNumSigDigits()){ //other has more digits
            return -1;
 
        } else { // same length

            int compareInd = 0; //index to compare digits
            int retVar = 0; // return variable

            for(int i = 0; i < this.digits.length; i++) { //looping for how long are the digits

                if (this.digits[compareInd] == other.digits[compareInd]){
                    compareInd++; // if digits are equal add to counter and go to next digit
                                // this will keep the loop going with i and check each element for 
                                //equality or difference with counter
                
                }else if(this.digits[compareInd] < other.digits[compareInd]){
                    retVar = -1;  //if the elements have different values then
                                    // -1 or 1 
                    
                } else if(this.digits[compareInd] > other.digits[compareInd]){
                    retVar = 1;
                    
                } 

            }

            return retVar; // retVar returns
        }
    
    }

    public BigInt add(BigInt other){
        if (other == null){
            throw new IllegalArgumentException("Null"); // illegal argument for null values
        }else if (this.getNumSigDigits() >= SIZE || other.getNumSigDigits() >= SIZE){
            throw new ArithmeticException("Overflow");
        }

        int[] resSum = new int[SIZE];
        for (int i = this.digits.length - 1; i >= 1; i--){
            resSum[i] += this.digits[i] + other.digits[i];
            if(resSum[i] >= 10){
              resSum[i] %= 10;
              resSum[i - 1] = 1;
            }
        }

        BigInt sum = new BigInt(resSum); // adding results to BigInt

    return sum;
    }

    // another helper method
    // private void shiftLeft(BigInt n){

    //     for(int i = 0; i < n.digits.length - 1; i++) {
    //         n.digits[i] = n.digits[i + 1];
    //     }
        
    //     n.digits[n.digits.length - 1] = 0;
    // }

    public BigInt mul(BigInt other){
        if (other == null){
            throw new IllegalArgumentException("Null"); // illegal argument for null values
        }else if (this.getNumSigDigits() >= SIZE || other.getNumSigDigits() >= SIZE){
            throw new ArithmeticException("Overflow");
        }

        int [] result = new int[SIZE];
        BigInt mul = new BigInt();
        int large = this.getNumSigDigits();
        int small = other.getNumSigDigits();

        if(this.getNumSigDigits() < other.getNumSigDigits()){
            large = other.getNumSigDigits();
            small = this.getNumSigDigits();
        }

        if(small == 1){
            int carry = 0;
            for(int i = this.digits.length - 1; i >= large; i--){
                result[i] = this.digits[i] * other.digits[other.digits.length-1] + carry;
                if(result[i] > 9){
                    result[i] %= 10;
                    carry = result[i] / 10;
                }
            }
        }

        mul = new BigInt(result);
        return mul;
    }
    
    public static void main(String [] args) {
        System.out.println("Unit tests for the BigInt class.");
        System.out.println();

        /* 
         * You should uncomment and run each test--one at a time--
         * after you build the corresponding methods of the class.
         */
        
        System.out.println("Test 1: result should be 7");
        int[] a1 = { 1,2,3,4,5,6,7 };
        BigInt b1 = new BigInt(a1);
        System.out.println(b1.getNumSigDigits());
        System.out.println();
        
        System.out.println("Test 2: result should be 1234567");
        b1 = new BigInt(a1);
        System.out.println(b1);
        System.out.println();
        
        System.out.println("Test 3: result should be 0");
        int[] a2 = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
        BigInt b2 = new BigInt(a2);
        System.out.println(b2);
        System.out.println();
        
        System.out.println("Test 4: should throw an IllegalArgumentException");
        try {
            int[] a3 = { 0,0,0,0,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
            BigInt b3 = new BigInt(a3);
            System.out.println("Test failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed.");
        } catch (Exception e) {
            System.out.println("Test failed: threw wrong type of exception.");
        }
        System.out.println();

        System.out.println("Test 5: result should be 1234567");
        b1 = new BigInt(1234567);
        System.out.println(b1);
        System.out.println();

        System.out.println("Test 6: result should be 0");
        b2 = new BigInt(0);
        System.out.println(b2);
        System.out.println();

        System.out.println("Test 7: should throw an IllegalArgumentException");
        try {
            BigInt b3 = new BigInt(-4);
            System.out.println("Test failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed.");
        } catch (Exception e) {
            System.out.println("Test failed: threw wrong type of exception.");
        }
        System.out.println();

        System.out.println("Test 8: result should be 0");
        b1 = new BigInt(12375);
        b2 = new BigInt(12375);
        System.out.println(b1.compareTo(b2));
        System.out.println();

        System.out.println("Test 9: result should be -1");
        b2 = new BigInt(12378);
        System.out.println(b1.compareTo(b2));
        System.out.println();

        System.out.println("Test 10: result should be 1");
        System.out.println(b2.compareTo(b1));
        System.out.println();

        System.out.println("Test 11: result should be 0");
        b1 = new BigInt(0);
        b2 = new BigInt(0);
        System.out.println(b1.compareTo(b2));
        System.out.println();

        System.out.println("Test 12: result should be\n123456789123456789");
        int[] a4 = { 3,6,1,8,2,7,3,6,0,3,6,1,8,2,7,3,6 };
        int[] a5 = { 8,7,2,7,4,0,5,3,0,8,7,2,7,4,0,5,3 };
        BigInt b4 = new BigInt(a4);
        BigInt b5 = new BigInt(a5);
        BigInt sum = b4.add(b5);
        System.out.println(sum);
        System.out.println();

        System.out.println("Test 13: result should be\n123456789123456789");
        System.out.println(b5.add(b4));
        System.out.println();

        System.out.println("Test 14: result should be\n3141592653598");
        b1 = new BigInt(0);
        int[] a6 = { 3,1,4,1,5,9,2,6,5,3,5,9,8 };
        b2 = new BigInt(a6);
        System.out.println(b1.add(b2));
        System.out.println();

        System.out.println("Test 15: result should be\n10000000000000000000");
        int[] a19 = { 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 };    // 19 nines!
        b1 = new BigInt(a19);
        b2 = new BigInt(1);
        System.out.println(b1.add(b2));
        System.out.println();

        System.out.println("Test 16: should throw an ArithmeticException");
        int[] a20 = { 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 };  // 20 nines!
        try {
            b1 = new BigInt(a20);
            System.out.println(b1.add(b2));
        } catch (ArithmeticException e) {
            System.out.println("Test passed.");
        } catch (Exception e) {
            System.out.println("Test failed: threw wrong type of exception.");
        }
        System.out.println();

        System.out.println("Test 17: result should be 5670");
        b1 = new BigInt(135);
        b2 = new BigInt(42);
        BigInt product = b1.mul(b2);
        System.out.println(product);
        System.out.println();

        System.out.println("Test 18: result should be\n99999999999999999999");
        b1 = new BigInt(a20);   // 20 nines -- see above
        b2 = new BigInt(1);
        System.out.println(b1.mul(b2));
        System.out.println();

        System.out.println("Test 19: should throw an ArithmeticException");
        try {
            b1 = new BigInt(a20);
            b2 = new BigInt(2);
            System.out.println(b1.mul(b2));
        } catch (ArithmeticException e) {
            System.out.println("Test passed.");
        } catch (Exception e) {
            System.out.println("Test failed: threw wrong type of exception.");
        }
        System.out.println();
        
   }
}

        

