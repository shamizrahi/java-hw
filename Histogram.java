import java.util.Scanner;

public class Histogram { 
    
    private static final int SENTINAL = -999;          // sentinal value to signal endo of input
    private static final int MAX_NUMBERS = 20;         // maximum number of numbers to input
    private static final double UPPER_BOUND = 100.0;   // largest numbers accepted as data
    private static final double LOWER_BOUND = 0.0;     // smallest numbers accepted as adata
    private static final int NUM_BINS = 10;            // number of bins in range [0..100]
    private static final int BIN_SIZE = 100 / 10;           // size of each bin 
   
    /*
     * Method to show an example of using StringBuilder.
     *
     * You will also notice that this method is called from the 
     * main function. 
     *
     */

    // This method should create and return an array of integers
// that represents the resulting histogram from the numbers
// entered and passed to the method.
//
public static int [] calculateHistogram( double [] numbers ) {

   int[] histogram = new int[NUM_BINS];
   for (int i = 0; i < numbers.length; i++) {
       int bin = findBin(numbers[i]);
       histogram[bin]++;
       }
   return histogram;
}

public static int findBin(double num ) {
    // There are a few ways to do this, one is a series of conditional
    // statements to find the correct bin. But, if you know the range
    // of numbers that belong in a specific bin... think about it.
    //
    int bin = 0;
    int[] bin_num = new int[NUM_BINS]; // setting bin_num to 10 via NUM_BINS val
    for(int i = 0; i < NUM_BINS; i++){
            //int max_num  = compute the last val that you can place in this bin
            double max_num = UPPER_BOUND;
            double min_num = 90.0;

            if (num <= max_num && num >= min_num){
            //bin_num[bin] = i;
            bin = bin_num[i];
            break;
            }
            else {
            max_num -= 10;
            min_num -= 10;
            }   
    }
     return bin;
}

public static boolean validInput( double num ) {
    return (num >= LOWER_BOUND && num <= UPPER_BOUND);
}

public static String toString( int [] histogram ) {
    
    StringBuilder str = new StringBuilder(); 
    int cur_val = 0;
    str = ("[" + (BIN_SIZE - 10) + "..." + (BIN_SIZE) + "]");

    for( int i = 0; i < histogram.length; i++){

        cur_val += 10;
        if (i != histogram.length - 1){
            str.append("(" + cur_val + "..." + cur_val + 10 + "]");
        }

        for (int j = 0; j < histogram.length; j++){
            
            if (findBin == true){
                str.append("*");
            }   
        }
    }
    return str;
}

public static double[] inputNumbers( Scanner scan ) {
    double[] input = new double[MAX_NUMBERS];
    int index = 0;

    while(index < MAX_NUMBERS){
        System.out.println("Enter numbers!");
        int num = scan.nextInt();

        // if(num != SENTINAL){
        //     if(validInput(num) == true){
        //         input[index] = num;
        //         index++;
        //     }
            
        // }else{
        //     //System.out.println("test");
        //     break;
        // }
        if(num == SENTINAL){
            break; // user has entered -999 so end of program 
        }
        if(validInput(num)){
            input[index] = num;
            index++;
    }
}

    double [] input2= new double[index];
    for(int j = 0; j < input2.length; j++){
        input2[j] = input[j];
    }
    return input2;
}

    public static String getHeaderAsString( String me ) {

	// Create an instance of the StringBuilder class
	// which allows us to create an object of 
	// a series of strings that can then be converted 
	// into one large string via the toString method.
	//
    	StringBuilder sb=new StringBuilder();

        sb.append( System.getProperty("line.separator") );
        sb.append( "Welcome to the Histogram Program " + me + "!" );
	me = getFirstName(me);
        sb.append( System.getProperty("line.separator") );
        sb.append( System.getProperty("line.separator") );
        sb.append( "This program will print out a histogram of the numbers" );
        sb.append( System.getProperty("line.separator") );
        sb.append( "input by you " + getFirstName(me) + "." );
        sb.append( System.getProperty("line.separator") );
        sb.append( System.getProperty("line.separator") );
        sb.append( "Please enter up to " + MAX_NUMBERS + " doubles or " + SENTINAL + " to stop input!" );
        sb.append( System.getProperty("line.separator") );

        return sb.toString();
    }

    /* 
     * Method to return the first name of the user in case
     * the full name was entered. 
     */
    public static String getFirstName(String name ) {
        // Note that add the " " to string to be sure
        // there is something to split
	return (name+" ").split(" ")[0]; 
    }

    /* 
     * local main test driver
     *
     */
    public static void main(String[] args) {  

	// Connect to the keyboard as the input stream
        Scanner userInput = new Scanner( System.in );

        System.out.print( "And who am I working with today? " );
        String user = userInput.nextLine();

	String heading = getHeaderAsString( user );

        // Print out welcome message
        System.out.println( heading ); 
        // double[] numbers2 = { 10, 11, 12, 20, 22, 30, 35, 40, 45, 56,66, 77, 99, 50, 60, 70, 80, 90, 100, 11.3}; // new creates the array 
        
        // Call the method which prompts the user
        // to input the numbers that will be used
        // to build the histogram.
       double[] numbers = inputNumbers( userInput );

	// Call the method to reate the array histogram
	int[] histogram = calculateHistogram( numbers );

	// Print the historgram
	System.out.println( toString( histogram ) );
    }

    /*
     *
     * COMPLETE YOUR METHODS
     *
     */

} // end of class