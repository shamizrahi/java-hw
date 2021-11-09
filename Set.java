/*
 * Student First Name: Sharon
 * Student Last Name: Mizrahi
 * Student BU Number: U54271588
 * Purpose: 
 */

public class Set  {
    private static final int SIZE = 10; // default size of initial set
                                
    private int[] set;      // array referece to the set
    private int size;       // current size of the set
    private int next;       // index to next available slot in the set array
    
    
    public Set() {
        this.set = new int[SIZE];
        this.size = SIZE;
        this.next = 0;
        
    }
 

    public Set(int[] arr) {
       if (arr == null){
       throw new IllegalArgumentException();
       }
       this.next = 0;
       this.size = SIZE;
       this.set = new int[SIZE]; 
       for(int i = 0; i < arr.length; i++){ // iterating array
           this.insert(arr[i]); //inserting array elements to make a set
       }     

    }

    public void insert(int k) {

        if(this.member(k)){ // eliminating duplicates
            return; // if its memeber do nothing
        }else{
            if(next == size){ // if next is equal to size then we need more space
                this.resize(); // adding more space
            }
        this.set[next] = k; // inserting elemets in next available space
        next++; // incrementing next since we resize array 
        }
        
    }

    private void resize() {
        size *= 2;

	// Create a new array double the size
        int[] temp = new int[size];

	// Copy all the elements from the current set
	// to the new set
        for(int i = 0; i < set.length; ++i) {
            temp[i] = set[i];
        }

	// Assign to the set reference the newly
	// resized array that represents the set.
        set = temp;
    }
   
    public Set clone() {

        Set clone = new Set();
        clone.size = this.size; // same size
        clone.next = this.next; // same elements

        for (int i = 0; i< this.next; i++){ //iterating throw each element to clone
        clone.set[i] = this.set[i]; // setting clone elements equal to set elements
        }
        return clone;
    }

    public  String toString()  {
        StringBuilder set = new StringBuilder(); //creating string

        if(next == 0){
            set.append("[]"); //[] reference empty set
        }else{
            set.append("["); // adding initial bracket
        for (int i = 0; i < next; i++){ //iterate set
            set.append(this.set[i]); //appending element
            set.append(","); // adding comas
        }
    
        set.deleteCharAt(set.length()-1); // deleting last element to eliminate extra coma
        set.append("]"); // closing brackets
    }
    
    return set.toString();

    } 

    public int cardinality() {
    
        return next; // next counst the number of elements in set
    }

    public  boolean isEmpty() {

        boolean isEmpty = false;

        if (next == 0){ //next is 0 means the array is empty
            isEmpty = true;
        }

        return isEmpty;
        
    }

    public boolean member(int k) {
        
        boolean isMember = false;

        for (int i = 0; i < this.next; i++){ //checking every element
            if(this.set[i] == k){ // if index is equal to k then true
                isMember = true;
                
            }
        
        } return isMember;
    }  

    public  boolean subset(Set S) {
        
        boolean isSubset = false;

        if(this.isEmpty()){
            isSubset = true;
    
        }else{
            for (int i = 0; i < this.next; i++){ //having this.next has to be equal the member parameter

                if(S.member(this.set[i])){ 
                    isSubset = true; //checkin for members. If only one elemenets is true the is a subset
                }else{
                    isSubset = false; // no elements then false
                    break;
                }
            } 
        }
        return isSubset;

    }

    public  boolean equal(Set S) {
        boolean equals = false;

        if(this.isEmpty() && S.isEmpty()){
            equals = true; //if both are empty they are equal
        }

        for (int i = 0; i < S.next; i++){
            if(this.member(S.set[i]) && this.next == S.next){
                equals = true; //if they have the name elements and are the same size the they are equals
            }
        }

        return equals;

    }

    public void delete(int k) {

        if(this.member(k)){
            for (int i = 0; i < this.next; i++) { //checking every element of set
                if(this.set[i] == k){
                this.set[i] = this.set[i + 1]; //shifting left when finding element
                }else{
                this.set[i] = this.set[i + 1]; //shifting rest of array
                }
            }
            next--; //decrementing next since there is one less element
        
        }
          
    } 

    public Set intersection(Set S) {
        
        Set inter = new Set();

        for(int i = 0; i < this.next; i++){
        int k = set[i]; //finding elements of set
        if(S.member(k)){ //checking if elements is shared between S and this
            inter.insert(k); // insert if they share members
            
            }
        }

        return inter;
    }

    public Set union(Set S) {
        
        Set union = new Set();

        for(int i = 0; i < this.next; i++){
            int z = this.set[i]; 
        
        union.insert(z); // passing elements of this set
        }
        for(int i = 0; i < S.next; i++){
            int k = S.set[i];
        union.insert(k); // passing elements of S.set. Insert eliminates duplicates
        }

        return union;
        
    }

    public Set setdifference(Set S) {

        Set diff = new Set();

        for(int i = 0; i < this.next; i++){
            int k = set[i]; //finding elements of set
            if(!S.member(k)){ //checking if they are members
                diff.insert(k); //inserting if k is not a memeber
                }
            }

        return diff;    
    
    }
    

}
