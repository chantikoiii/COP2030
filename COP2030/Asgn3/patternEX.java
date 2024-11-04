import java.util.Scanner;

public class patternEX{

    public static void main(String[] args){

        Scanner inputInt = new Scanner(System.in);
        System.out.print("\nEnter the size for your shapes (Max: 16): ");

        while(inputInt.hasNextInt()){

            int size = inputInt.nextInt();

            if(size>16){
                System.out.print("\nMax value exceeded. Try again: ");
                continue;
            }

            patternEX.diamondEX(size);
            System.out.print("\n");
            patternEX.checkersEX(size);
            
            System.out.print("\nEnter the size for your shapes (16 max): ");
        }
        inputInt.close();
        System.out.println("\nNormal Termination!");
    }

    public static void diamondEX(int center){

        if(center % 2 == 0 || center <= 0){
            System.out.println("\nDiamond needs an odd number!");
            return;
        } else {

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

    public static void checkersEX(int rows){

        System.out.print("Checker board of size "+rows+":\n");

        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                if(i%2==0){
                    System.out.print(" *");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
