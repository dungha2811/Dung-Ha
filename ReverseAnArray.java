import java.util.*;

public class ReverseAnArray {
    public static void main(String args[]){

        //create a test array
        int test[] =new int[10];

        //create Random object to get random 1000 number
        Random rand = new Random();

        for(int i =0; i<test.length;i++){

            //store element inside an array from 0 -999
            test[i] = rand.nextInt(9);
        }

        //print the original array
        System.out.println("The original array is:");
        printArray(test);

        System.out.println("METHOD 1 \n");

        //create start time for the method
        long startTime1 = System.nanoTime();
        int Reversed1[] = ReverseUsingStack(test);

        //create end time for the method
        long endTime1 = System.nanoTime();

        //calculate the total time
        long total1 = endTime1 - startTime1;

        //print out the array
        System.out.println("The array after reversed using the stack method is: ");
        //printArray(Reversed1);
        //printArray(test);
        System.out.println("The total time to reverse using stack is "+ total1 +" ns.");

        System.out.println("\nMETHOD 2 \n");

        //create start time for the method
        long startTime2 = System.nanoTime();

        int Reversed2[] = ReverseUsingCollections(test);

        //create end time for the method
        long endTime2 = System.nanoTime();

        //calculate the total time
        long total2 = endTime2 - startTime2;

        //print out the array
        System.out.println("The array after reversed using the mid point method is: ");
        printArray(Reversed2);
        //printArray(test);
        System.out.println("The total time to reverse using mid point is "+ total2 +" ns.");

        System.out.println("\nMETHOD 3 \n");
        //create start time for the method
        long startTime3 = System.nanoTime();

        int Reversed3[] = ReverseUsingFor(test);

        //create end time for the method
        long endTime3 = System.nanoTime();

        //calculate the total time
        long total3 = endTime3 - startTime3;

        //print the reversed array
        System.out.println("The array after reversed using the for loop method is: ");
        printArray(Reversed3);
        //printArray(test);
        System.out.println("The total time to reverse using a for loop is "+ total3 +" ns.");
    }

    /**
     * The ReverseUsingFor is a traditional way to reverse an array by creating a copy of an array and store it into another array
     * @param a the input array
     * @return the reverse array
     */
    public static int [] ReverseUsingFor(int a[]){
        //create new array to store data
        int reversedArray [] = new int [a.length];
        //for loop to add element to array
        for(int i =0 ; i<a.length;i++){
            reversedArray[i]= a[a.length-i-1];
        }
        //return the array
        return reversedArray;
    }

    /**
     * The ReverseUsingCollections method use collection library to reverse the array
     * @param a
     * @return
     */
    public static int [] ReverseUsingCollections(int a[]){
        //create a List
        List<Integer> list = new ArrayList<Integer>();

        //add all element in array to arrayList
        for(int i =0 ;i <a.length;i++){
            list.add(a[i]);
        }
        //reverse the array
        Collections.reverse(list);

        //add element back to the array
        for(int i =0 ;i<list.size();i++){
            a[i]= list.get(i);
        }
        return a;
    }

    public static int [] ReverseUsingStack(int a[]){

        //create stack to store data
        Stack<Integer> stack = new Stack<>();
        stack.setSize(a.length);

        //push data into stack
        for(int i =0; i< a.length;i++){
            stack.push(a[i]);
        }

        //store the data that stack pop (on the reverse way)
        for(int i =0;i<a.length;i++) {
            a[i] = stack.pop();
        }
        return a;
    }

    public static void printArray(int a[]){
        //create a StringBuilder object
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i =0; i< a.length;i++){

            //add element into the output String
            sb.append(a[i]);

            //not adding the column the last number
            if(i != a.length-1){
                sb.append(",");
            }

        }
        sb.append("]");

        //print the array
        System.out.println(sb.toString()+"\n");
    }
}
