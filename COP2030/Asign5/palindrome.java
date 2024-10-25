import java.util.Scanner;

public class palindrome{ // main class
    public static void main(String [] args){ // main method

        Scanner inputStr = new Scanner(System.in);
        System.out.println("\nYour String:TO QUIT-<ctrl d>(UNIX)/<ctrl z>(Windows)>"); //prompt input

        mainloop:
        while(inputStr.hasNextLine()){ // checks if <crtl> command is inputted 
            
            String myString = inputStr.nextLine();

            int lenPal = myString.length(); // counting char

            if(lenPal == 1){
                System.out.println("\nLength one string is always a palindrome!");
            } else if(lenPal == 0){
                System.out.println("\nEmpty string is vacuuously a palindrome!");
              } else { // if input is greater than 1

                int i=0; int j=lenPal-1; // initialize loop variables
                myString = myString.toLowerCase(); // for ASCII values

                while(i<j){ // increments 'i' & decrements 'j' until they land on the same char
                    if(myString.charAt(i)!=myString.charAt(j)){
                        System.out.println("\n\""+myString+ "\" is not a palindrome");
                        System.out.println("\nYour String:TO QUIT-<ctrl d>(UNIX)/<ctrl z>(Windows)>");
                        continue mainloop;
                    }
                    i++;
                    j--;
                }
                System.out.println("\n\""+myString+ "\" is a palindrome"); // if 'i' & 'j' are always equal
            }
            System.out.println("\nYour String:TO QUIT-<ctrl d>(UNIX)/<ctrl z>(Windows)>");
        }
        inputStr.close(); // closing scanner
        System.out.println("\nNormal Termination!"); // program ends if <crtl> command is inputted
    }
}
