/*
Name: Sharon Mizrahi
Email: smizrahi@bu.edu
Problem 7 - Duplicates

This class takes an array, deletes the duplicates and returns array and 
of significant elements
*/

import java.util.*;

public class Duplicates {

    /*
    Method that removes array duplicates efficiently
    */
    public static int removeDups(int[] arr){

        if(arr.length == 0 || arr.length == 1){
            return arr.length;
        }

        int count = 0; // counting doulicates in array
        int flag = 1;

        for(int i = 0; i < arr.length - 1; i++){

            if(arr[i] == arr[flag] && arr[i] != 0){
                arr[i] = 0; // replacing duplicates with zeros
                
                
            }else if (arr[i] != 0){
                flag++;
                arr[count] = arr[i]; //changing elements
                count++; // incremeting count 

            }

        }
        System.out.println(count);
        int final_count = count; //saving count

        while(count < arr.length){ // iterating the array
            arr[count] = 0; // subtituting 0s
            count++; // incremeting count 

        }
        
        return final_count;


    }


    public static void main(String []args){

        int[] arr = {2, 5, 5, 5, 10, 10, 10, 12, 12};
        int ret = removeDups(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ret);

    }
    
}

