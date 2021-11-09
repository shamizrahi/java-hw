
/*
 * This method should take an integer x and return:
 *    2x when x is odd
 *    the unchanged value of x when x is even
 */
import java.util.Scanner;

public class ClassProgram1 {
    
    public static int double_if_odd(int x) {

        int retVart = x; //entry point - This is better than havin multiple return stmts

        if(!(x % 2 == 0)) {
            retVart = x*2; //return
        } 
        return retVart; // exit point
    }
    public static void main(String[] args) {
        
        Scanner stdin = new Scanner(System.in);

        int x;
        
        System.out.println("Enter an integer x: ");
        x = stdin.nextInt();

        System.out.println("double_if_odd(x) = " + double_if_odd(x));
        stdin.close(); // here is fine
            
    }
}

