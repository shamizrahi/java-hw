

public class StringRecursion {

    public static void printReverse(String str){
        
        if(str != null && !str.equals("")){
            printReverse(str.substring(1));
            System.out.print(str.charAt(0));
            
        }

    }

    public static String trim(String str){

        if(str == null){
            throw new IllegalArgumentException("null");

        }else if(str.equals("")){
            return str;

        }else if(str.charAt(0) != ' ' && str.charAt(str.length()-1) != ' '){
            return str;

        }else{
            if (str.charAt(0) == ' '){
                str = trim(str.substring(1));
            }
            if(str.charAt(str.length()-1) == ' '){
                str = trim(str.substring(0, str.length()-1));
            }
            // System.out.println(str);
            
        }
        return str;
        
    }

    public static int find(char ch, String str){

        if(str == null || str.equals("")){
            return -1;
        }

    
        if(str.charAt(0) == ch){ 
            return 0;

        }else{
            
            int rest = find(ch, str.substring(1));
            if(rest == -1){
                return rest;
            }else{
                return 1 + rest;   
            }
        }

    } 

    public static String weave(String str1, String str2){


        if(str1 == null || str2 == null){
            throw new IllegalArgumentException("null");
        }

        if(str1.equals("")){ // comparing object not address.
            return str2; 
        }

        if(str2.equals("")){
            return str1;

        }

        String rest = weave(str1.substring(1),str2.substring(1));
        return str1.charAt(0) +""+ str2.charAt(0) + rest;
        
    }

    public static int indexOf(char ch, String str){
        
        return find(ch, str);

    } 

    public static void main(String [] args){


        // //test print Reverse
        printReverse("Terriers");

        // //test trim
        System.out.print(trim(" hello world    "));
        System.out.println(trim("recursion  "));
        System.out.println(trim("hello"));
        System.out.println(trim(""));

        //test find
        System.out.println(find('b', "Rabbit"));
        System.out.println(find('p', "Rabbit"));

        // test weave
        System.out.println( weave("", "bbbbb") );
        System.out.println( weave("aaaa", "bbbbb") );
        System.out.println( weave("hello", "world") );

        // test indexOf
        System.out.println( indexOf('b', "Rabbit") );
        System.out.println( indexOf('P', "Rabbit") ); 
        

    }
    
}


