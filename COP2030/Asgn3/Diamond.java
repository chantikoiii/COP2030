import java.util.Scanner;

public class Diamond { // inclusion of prompt for user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of diamond: ");
        int center = scanner.nextInt();

        //input must be odd
        while (center % 2 == 0) {
            System.out.println("Please enter an odd number.");
            center = scanner.nextInt();
        }
        // diamond method from last assignment
        int ask=1; int spc=center/2;
        System.out.print("Diamond of size "+center+":\n");

        for (int i=1; i<=center; i++) { //iteration of rows
        
            for (int k=spc; k>=1; k--) { //number of spaces
                System.out.print(" ");
            }
    
            for (int j=1; j<=ask; j++) { //number of asterisks
                System.out.print("*");
            }
    
            System.out.println(); //prints diamond
    
            if (i < center/2+1) {
                ask += 2; //asterisks increasing before center 
                spc -= 1; //spaces decreasing before center
            } else {
                ask -= 2; //asterisks decreasing
                spc += 1; //spaces increasing
    
            }
        }
    }
}