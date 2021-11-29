/*
* LLBag.java
*
* Computer Science 112, Boston University
*
* Sharon Mizrahi - smizrahi@bu.edu
*/

import java.util.*;

// A class that implements the Bag interface.
public class LLBag implements Bag {

    // Inner class for a node.  We use an inner class so that the LLList
    // methods can access the instance variables of the nodes.
    private class Node {
        private Object item;
        private Node next;
        
        private Node(Object i, Node n) {
            item = i;
            next = n;
        }
    }

    // fields of the LLBag object
    private Node head;     // dummy head node
    private int length;    // # of items in the list
    private Node tail;     // last item -> for add method
    

    
    // no args constructor initiatins as an empty bag
    public LLBag(){

        head = new Node(null, null);
        length = 0;
        tail = head;

    }

    /*
     * toString - converts this LLBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";
        Node trav = head.next; //skip over dummy node

        while(trav.next != null){
            str += trav.item;
            str += ", ";
            trav = trav.next;
        }
        str += trav.item + "}";
        return str;
    }


     /*
     * add - adds the specified item to this LLBag. Always return true since 
     * thre is no limit
     */
    public boolean add(Object item){
        if (item == null){
            throw new IllegalArgumentException();
        }

        Node newNode = new Node(item, null); //new node for new item
        tail.next = newNode; //assigning next in tail to newNode
        tail = newNode; //adding as last elements of the LLBag
        length += 1; // incremeting size

        return true;

    }

     /* 
     * remove - removes one occurrence of the specified item (if any)
     * from this LLBag.  Returns true on success and false if the
     * specified item is not in this LLBag.
     */
    public boolean remove(Object item) {
        if (item == null){
            throw new IllegalArgumentException();
        }

        Node trav = head.next;

        while (trav.next != null){
            if(trav.next.item.equals(item)){
                trav.next = trav.next.next; //changing prev.nect to node after node we eant to remove
                length--; // decrement length
                return true;
            }

            trav = trav.next;
        }

        return false;


    }

    /*
     * contains - returns true if the specified item is in the LLBag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        if (item == null){
            throw new IllegalArgumentException();
        }

        Node node = head.next;
        while(node != null){
            if(node.item.equals(item)){ //chequing items for equality
                return true;
            }

            node = node.next; //next element 
        }
        
        return false; 
    }

    /*
     * grab - returns a reference to a randomly chosen item in this LLBag.
     */
    public Object grab() {
        if (length == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        
        int count = 0;
        int whichOne = (int)(Math.random() * length);
        Node trav = head.next;

        while(trav != null){ //traversing list
            if (count == whichOne){ // count is equal to random element number
                break; // end loop
            }else{
                count++; //increments count
                trav = trav.next;  //iterate to next item
            }
            
        }

        return trav.item;
    }

    /*
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        
        Object[] copy = new Object[length];
        Node trav = head.next;
        int index = 0;

        while(trav != null){
            copy[index] = trav.item;
            index ++;
            trav = trav.next;
        }

        
        return copy;
    }

    public int numItems(){
        return length;
    }


    /* Test the LLBag implementation. */
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // Create an ArrayBag named bag1.
        System.out.print("number of items in bag 1: ");
        int numItems = scan.nextInt();
        Bag bag1 = new LLBag();
        scan.nextLine();    // consume the rest of the line
        
        // Read in strings, add them to bag1, and print out bag1.
        String itemStr;        
        for (int i = 0; i < numItems; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
        
        // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();
        
        // Iterate over the objects in bag1, printing them one per line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
        
        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
    }

    
}

