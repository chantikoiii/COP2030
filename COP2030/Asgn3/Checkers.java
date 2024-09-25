import java.util.Scanner;

public class Checkers{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rows of checkers: ");
        int rows = scanner.nextInt(); int cols = rows*2;

        System.out.print("Checker board of size "+rows+":\n");
        // checkers method from last assignment
        for(int i=0; i<rows; i++) {
            for(int j=0; j<=cols; j++){
                if((i+j)%2==0){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
