/*
 * Problem Set 1
 * 
 * A simple interactive program that performs operations 
 * on a set of three integers.
 *
 * CS112
 *
 */

import java.util.*;

/*
 * Program Class Defintion
 */
public class SimpleStats {

    /*
     * printMenu()
     *
     * Method to display user options.
     */
    public static void printMenu() {
        System.out.println("(0) Enter new numbers");
        System.out.println("(1) Find the largest");
        System.out.println("(2) Compute the sum");
        System.out.println("(3) Compute the range (largest - smallest)");
        System.out.println("(4) Compute the average");
        System.out.println("(5) Print the numbers in ascending order");
        System.out.println("(6) Quit");
        System.out.println();
    }
    
    /*** PUT YOUR SEPARATE METHODS FOR OPTIONS 1-5 HERE ***/
    public static int largest(int x, int y, int z) { /// choice 1
        
        int retVart = 0;

        if (x >= y && x >= z){
            retVart = x;
        }

        else if (y >= x && y >= z){
            retVart = y;
        }

        else if (z >= x && z >= y){
            retVart = z;
        }

        return retVart;
    }

    public static int sum(int x, int y, int z) { /// choice 2
        
        return x + y + z;
        
    }

    public static int smallest(int x, int y, int z) { /// computing smallest method to create rage method base on smallest and largest 
        
        int retVart = 0;
        
        if (x <= y && x <= z){
            retVart = x;
        }

        else if (y <= x && y <= z){
            retVart = y;
        }

        else if (z <= x && z <= y){
            retVart = z;
        }
        return retVart;
    }

    public static int range(int x, int y, int z) { /// choice 3
        
        return largest(x, y, z) - smallest (x, y, z); /// subtracting smallest from largest to get range

    }


    public static double average(int x, int y, int z) { /// choice 4
        
        return ( x + y + z ) / 3.0;

    }

    public static void ascending(int x, int y, int z) { /// choice 5

        if (x >= y && x >= z) {
            if (y >= z){
                System.out.println("In order, the numbers are: " + z + " " + y + " " + x);
        } else if (z >= y){
                System.out.println("In order, the numbers are: " + y + " " + z + " " + x);
            }
        }

        else if (y >= x && y >= z) {
            if (x >= z){
                System.out.println("In order, the numbers are: " + z + " " + x + " " + y);
        } else if (z >= x){
                System.out.println("In order, the numbers are: " + x + " " + z + " " + y);
            }
        }

        else if (z >= x && z >= y) {
            if (x >= y){
                System.out.println("In order, the numbers are: " + y + " " + x + " " + z);
        } else if (y >= x){
                System.out.println("In order, the numbers are: " + x + " " + y + " " + z);
            }
        }
        
    }

    /*
     * main()
     *
     * Program execution begins with this method.
     */
    public static void main(String[] args) {
        /// Create an instance of a scanner object and
	// connect to the standard input device

        Scanner scan = new Scanner(System.in);

        // variable declarations and initializations as needed
        int x = 0;
        int y = 0;
        int z = 0;

        int choice = 0;

        boolean can_start = false;
        boolean more_input = true; /// boolean variable to use if 0 was entered. 
        
        
	/*
 	 * Control loop
 	 */

        do {
            
	    // If numbers have been entered (choice 0) has been selected, output the numbers
        if (can_start == true){ /// if 0 was entered we can continue the program and show entered numbers
            System.out.print("The current numbers are: ");
            System.out.println(x + " " + y + " " + z);
        }
	    // Call the method which displays the menu choices
        
            printMenu();
        
	    // Prompt to enter the choice of operation
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();
        
            /*
             * Expand this conditional statement to correctly process all choices.
             * Make sure to follow the guidelines in the assignment for
             * doing so.
             */

            if (choice != 0 && can_start == false && choice < 6) {
                /// if 0 was no entered yet, can_start is false and numbers are less than 6 then
                /// the rest of the whileloop cannot run. 
                System.out.print("Cannot compute, numbers have not been entered");
             }
            else if (choice == 0) { /// from here on can_start is true therefore the program can run
                can_start = true;
                System.out.print("Enter three new numbers: ");
		// Input the three numbers
                x = scan.nextInt();  /// scan next since the user can input number
                y = scan.nextInt();
                z = scan.nextInt();

            }
            else if (choice == 1) { 
                System.out.print("The largest of the numbers is " + largest(x , y, z));
            }
            else if (choice == 2) {
                System.out.print("The sum of the numbers is " + sum(x , y, z));
            }
            else if (choice == 3) {
                System.out.print("The range of the numbers is " + range(x , y, z));
            }
            else if (choice == 4) {
                System.out.print("The average of the numbers is " + average(x , y, z));
            }
            else if (choice == 5) {
                ascending(x , y, z);
            }
            else if (choice == 6) {
                more_input = false; 
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        } while (more_input) ; /// end while loop
        
        System.out.println("Have a nice day!");
        scan.close();
    }
}