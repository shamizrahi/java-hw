/* 
 * Problem Set 2 Problem 7
 *
 * File: MyMethos.java
 *
 * Author: Sharon Mizrahi
 * Coutse: CS112, Boston University
 *
 * Purpose: Implementing methods with arrays
 */


import java.util.*;

public class  ArrayMethods {

    public static final String[] DAYS =
       {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public static void swapAdjacent(int[] values){ // This method changes odd index values with even index values.

        if (values == null){
        throw new IllegalArgumentException(); // illegal argument for null values
        }

        for (int i = 0; i < (values.length - 1); i += 2){ // -1 to length for odd arrays
            int vals = values[i]; // array variable
            values[i] = values[i+1]; // swapping i with i+1
            values[i+1] = vals; // swapping i+1 with i 
        }

    }

    public static int[] copyReplace(int[] values, int oldVal, int newVal){ //this method replaces an index values with a new value
        
        if (values == null){
            throw new IllegalArgumentException(); // illegal argument for null values
            }

        int result[] = new int[values.length]; // new array same length as values[]
        for (int i = 0; i < values.length; i++){ 
            if (values[i] == oldVal){ //when the selected value is equal to oldVal
                result[i] = newVal;     // substite
            }else{
                result[i] = values[i];  //else keep same value
            }
        }
        return result;
    }

    public static int maxSorted(int[] values){ // this method returns the length of the longest sorted sequence of integers in the array. 
        
        if (values == null){
            throw new IllegalArgumentException(); // illegal argument for null values
        }else if(values.length == 0){
            return 0;
        }else if(values.length == 1){ // for arrays with one element
            return 1;
        }

        int maxSorted = 0; // initialize on 0
        int count = 1; // count starts at 1 since we start counting from 1 element

        for(int i = 0; i < values.length-1; i++){
            
            if(values[i] <= values[i + 1]){ // continue count if next element is i + 1 or = i
                count += 1;
            
            }else{  // else keep count as one
                count = 1;
            }

            if(maxSorted < count){ // this is always true since count starts at 1
                maxSorted = count; //count 1 + rest of element count will equal maxsorted
            }
        }
        return maxSorted;

    }

    public static int getIndexOfDay(String day){
        
        if (day == null){
            return -1;
        }
        
        int index = 0; // index 0 because we cannot start with a number since it will return a day

        for (int i = 0; i < DAYS.length; i++){

            if(DAYS[i].equals(day)){ // if day name of day is equal to location of DAYS in array
                index = i; // return location of day in array
                break;  //break because this is the only condition for the loop
            }
        }
        
        return index;
    }

    public static int[] reverseInterchange( int[] arr1, int [] arr2 ){
        if (arr1 == null || arr2 == null){
            throw new IllegalArgumentException(); // illegal argument for null values
        }

        int smallest = arr1.length; 

        if(arr2.length < smallest){
            smallest = arr2.length;
        } // only interchange as many elements as contained in the smalles array

        int[] newArr = new int[smallest * 2]; // set new array to *2 length

        for ( int i = 0, j = 0; i < smallest; i++ ){ // the loop uses two control variables
            newArr[j++] = arr1[i]; 
            newArr[j++] = arr2[(smallest-1-i)]; // reverse array
        }

         return newArr;

    }
        

    public static void main( String[] args ) { // using main to test methods

   // int[] a2 = {1, 2, 3, 4, 5, 6, 7};
   // ArrayMethods.swapAdjacent(a2);
   // System.out.println( Arrays.toString(a2) );

   // int[] a1 = {2, 5, 4, 2, 7, 4, 2};
  //  int[] a2 = ArrayMethods.copyReplace(a1, 4, 0);
    //System.out.println( Arrays.toString(a2) );

    //int[] a3 = ArrayMethods.copyReplace(a1, 2, -1);
    //System.out.println( Arrays.toString(a3) );

    //System.out.println( Arrays.toString(a1) );

    //int[] a1 = {1};
   // System.out.println( ArrayMethods.maxSorted(a1) );

    //int[] a2 = {17, 42, 3, 5, 5, 5, 8, 4, 6, 1, 19};
    //System.out.println( ArrayMethods.maxSorted(a2) );

    //System.out.println( ArrayMethods.getIndexOfDay("Monday") );
    //System.out.println( ArrayMethods.getIndexOfDay("Tuesday") );
    //System.out.println( ArrayMethods.getIndexOfDay("Friday") );

    int a1[] = {1,2,3,4,5,6};
    int a2[] = {10,11,12,13};
    System.out.println( Arrays.toString( ArrayMethods.reverseInterchange(a1, a2) ) );


    
    }
    
}
