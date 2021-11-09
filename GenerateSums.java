public class GenerateSums{

    public static String generateSums(int n) {
        String genSum =  "1";
        System.out.println(genSum);
        int sum = 1; //sum starts at 1 since i is 1
        int save = 0; // saving the sum to add later


        for (int i = 1; i <= n; i++) { // starting i at 1 since 1 is the first element printed
            save = sum + i + 1; 
            if(i  < n - 1){ //controling loop to print 1 element less than n
            genSum += " + " + (i + 1);
            System.out.println(genSum + " = " + save);
            sum = save; // saving sum to add more elements when loop increments
            }

        }
        sum = sum + n;
        genSum += " + "+ n + " = " + sum;

        return genSum.toString();
    }

/// change string building to string cocatenation!!!

    public static void main(String[] args){

        System.out.println(generateSums(4));

        System.out.println(generateSums(6));

        // generateSums2(6);


    }

}