/*
Name: Sharon Mizrahi
Email: smizrahi@bu.edu
Problem 9 - MergeIntersect

This class  takes two arrays of integers as parameters and uses 
an approach based on merging to find and return the intersection 
of the two arrays
*/

import java.util.*;

public class MergeIntersect {

    //This method takes two arrays, sorts them and returns
    // the intersection for both arrays
    public static int[] intersect(int[] arr1, int[] arr2){

        //sorting arrays
        Sort.mergeSort(arr1);
        Sort.mergeSort(arr2);

        //creating return array
        int[] intersect;
        int smallest;
         

        if(arr1.length < arr2.length){ //defining size of return array
            smallest = arr1.length;

        }else{
            smallest = arr2.length;

        }
        //setting smallest length to return array
        intersect = new int[smallest];


        int index_1 = 0; //arr1 element
        int index_2 = 0; // arr 2 element
        int next = 0; //index to place next element in return array
        int prev = -1; //index to compare for doubles

        if(arr1[index_1] <= 1 && arr2[index_2] <= 1){ //taking care of negative elements

            if(arr1[index_1] == arr2[index_2]){ // when index 1 is diff than previous index
                intersect[next] = arr1[index_1]; //intersect next will be equal to index 1
                prev = intersect[next]; // prev new index
                next++;
            }

        }

        while((index_1 < arr1.length) && (index_2 < arr2.length)){

            if(arr1[index_1] == arr2[index_2]){
                if(arr1[index_1] != prev){ // when index 1 is diff than previous index
                    intersect[next] = arr1[index_1]; //intersect next will be equal to index 1
                    prev = intersect[next]; // prev new index
                    next++;
               
                }else if(arr1[index_1] == prev){ //skip duplicates arr1
                    index_1++;
                
                }else if(arr2[index_2] == prev){ //skip duplicates arr2
                    index_2++;
                }

            }else if (arr2[index_2] < arr1[index_1]){ //increment if one element less than other
                index_2++;
            
            }else if(arr2[index_2] > arr1[index_1]){
                index_1++;

            }

        }

        return intersect; // return intersect 
    }


    public static void main(String[] args){

        int[] a1 = {-1, 10, 3, 5, 7 ,-9};
        int[] a2 = {-1, -9, 6, 5, 4, -3, 2, 3};

        int[] res = MergeIntersect.intersect(a1, a2);
        System.out.println(Arrays.toString(res));
        
    }



}
