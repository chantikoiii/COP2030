import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Final {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        
        while(true){ //runs until user terminates

            int alphaSize = arrayGenerate(input,
            "\nSize for alpha:<To quit: ctrl d on UNIX/ctrl z on Windows> ");

            int betaSize = arrayGenerate(input,
            "\nSize for beta:<To quit: ctrl d on UNIX/ctrl z on Windows> ");

            if(alphaSize < 0 || betaSize < 0){ //restart if either are negative
                System.out.println("\nArray size cannot be negative - try again!");
                continue;

            } else if(alphaSize == betaSize){

                System.out.println("\nSame size arrays - we shall proceed!\n");

                if(alphaSize == 0 && betaSize == 0){ //restart if both are zero
                    System.out.println("\nZero length Integer arrays are vaccuously permutations of each other!");
                    continue;
                }

            } else { //restart if arrays are not equal
                System.out.println("\nUnequal length arrays, cannot be permutations of each other");
                continue;
            }

            //populate alpha
            System.out.println("Accept Integers for alpha:");
            int[] alpha = getArray(input, alphaSize, "alpha[");

            System.out.println();

            //populate beta
            System.out.println("Accept Integers for beta:");
            int[] beta = getArray(input, betaSize, "beta[");

            System.out.println("\nThe two arrays are:\n"); //print arrays

            System.out.println(Arrays.toString(alpha));
            System.out.println(Arrays.toString(beta));

            System.out.println();

            //determine if permutations
            permutationAnalysis(alpha, beta);
        }
    }

    private static void permutationAnalysis(int[] master, int[] sub){

        //convert alpha into hashmap
        Map <Integer, Integer> masterCount = new HashMap<>();
        for(int value : master){
            masterCount.put(value, masterCount.getOrDefault(value, 0) + 1);
        }

        //convert beta into hashmap
        Map <Integer, Integer> subCount = new HashMap<>();
        for (int value : sub){
            subCount.put(value, subCount.getOrDefault(value, 0) + 1);
        }

        //check for permutations
        for(Map.Entry<Integer, Integer> masterEntry : masterCount.entrySet()){

            int masterKey = masterEntry.getKey();
            int masterValue = masterEntry.getValue();

            System.out.println("\n" + masterKey + " occurs in array alpah " + masterValue + " times");

            if(subCount.containsKey(masterKey)){

                int subValue = subCount.get(masterKey);

                if(subValue == masterValue){
                    System.out.println("\n" + masterKey + " occurs in array beta " + masterValue + " times, as well!");
                } else {
                    System.out.println("\n" + "Unequal frequency for " + masterKey + " in beta!");
                }
            } else {
                System.out.println("\n" + masterKey + " does not occur in beta at all!");
            }
        }

        if(masterCount.equals(subCount)){ //hashmaps do not factor in order
            System.out.println("\nInteger arrays are permutations of each other!");
        } else {
            System.out.println("\nInteger arrays are not permutations of each other!");
        }
    }

    private static int arrayGenerate(Scanner input, String prompt){
        while (true){

            System.out.print(prompt);
      
            if(input.hasNext()){
              try {
      
                int value = Integer.parseInt(input.nextLine());
                return value; //exits if input is int
                
              } catch (NumberFormatException e){
                System.out.println("\nIntegers only - Try Again!");
              }
            } else {
              //EOF if <ctrl+z/d>
              System.out.println("\nNormal Termination!");
              System.exit(0);
            }
        }
    }

    private static int[] getArray(Scanner input, int size, String prompt){

        int[] array = new int[size];
        //populate array
        for (int i = 0; i < size; i++) {
            array[i] = getArrayValue(input, prompt + i + "]: ");
        }
        return array;
    }

    private static int getArrayValue(Scanner input, String entry){
        //accepts array entries
        System.out.print(entry);
        int value = Integer.parseInt(input.nextLine());
        return value;
    }
}
