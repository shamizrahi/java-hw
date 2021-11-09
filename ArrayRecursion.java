public class ArrayRecursion{

    public static boolean search(Object item, Object[] arr, int start){
      
      boolean found = false;

      if (arr == null){
         throw new IllegalArgumentException();
      }

      if(start >= arr.length){ // Start position cannot be greated than arr size
         found = false;
      }else if(arr[start].equals(item)){ 
         found = true;
      } else {
         search(item, arr, start + 1);
      }


      return found;

   }


   public static String reverseArrayToString(Object[] arr, int index ){
      
      String str = "";
      
      if ( arr != null && index >= 0 ){
         
         if(index == arr.length -1){
            str += "[";
            str += arr[index];
            
         }else{ 
            str +=  reverseArrayToString(arr, index + 1) + ", " + arr[index];
         }

      }

      if(index == 0){
         str += "]";
      }
      
      return str;
   }


   public static void main(String [] args){

      String arr[] = {  "abc", "def", "ghi", "klm", "nop", "qrs" };

      System.out.println(search("di", arr, 0));

      String a[] = { "abc", "def", "ghi", "klm", "nop", "qrs" };

      System.out.println(reverseArrayToString(a, 0));


   }

}



