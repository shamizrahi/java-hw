import java.util.*;

public class PairFinder {

    /*
    Method that finds pairs of elements and return the sum if it is 
    equal to an int k
    Time complexity = O(n^2)
    */
    public static void findPairSums(int k, int[] arr){
        for(int i = 0; i < arr.length; i++){
            for (int j = 1; j < i; j++){
                if(arr[i] + arr[j] == k){
                    System.out.println(arr[i] + " + " + arr[j] + " = " + k);

                }
            }
        }
    }
    /*
    More efficient find pais methos. Does not repeat numbers.
    Time coplexity = O(nlogn) + O(1) = O(nlogn)
    */
    public static void findPairSumsFaster(int k, int[] arr){
        
        Sort.mergeSort(arr);

        int left = 0;
        int right = arr.length-1;

        do{ 
            if(arr[left] + arr[right] == k){ // if left + right = k then print
                System.out.println(arr[left] + " + " + arr[right] + " = " + k);
                left++;
            
            }else if(arr[left] + arr[right] > k){ // if right element produces sum > k
                right--; // compare next right element with left element

            }else if(arr[left] + arr[right] < k){ // if left element produces sum < k
                left++; // compare next left element with right element
            }

        }while(left < right); //once the indexes meet eachother the loop should stop

    }


    public static void main(String []args){

        int arr[] =  {10, 4, 7, 7, 8, 5, 15};
        System.out.println("FP 1: ");
        findPairSums(12, arr);
        System.out.println("FP 2: ");
        int arr2[] = SortCount.randomArray(8);
        System.out.println(Arrays.toString(arr2));
        findPairSums(357483, arr2);
        System.out.println("Faster: ");
        findPairSumsFaster(12,arr);

    
    }
}
