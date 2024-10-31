import java.util.Scanner;

public class triples{
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer <ctrl+Z to exit> ");

        while(input.hasNextInt()){ // checks if <ctrl> command is inputted

            int pythTrip = input.nextInt();

            if(pythTrip <= 0){ // only accepting positive int
                System.out.println("\nPositive numbers only!\n");
            } else {

                int a,b; // equation triples
                int freq=0, cat1=0, cat2 = 0; // initialize counters
                int cat3=0; // if triple contains y=x+1 & z=y+1

                for(a=1; a<pythTrip; a++){ // iterating through potential triples
                    for(b=a; b<pythTrip; b++){ // will not print any int over pythTrip

                        int c = (int)Math.sqrt(a*a + b*b);

                        if(c<=pythTrip && a*a + b*b == c*c){ // checks if 'a,b,c' are pythagorean triples
                            if(b+1==c && a+1==b){
                                System.out.println("\t\t("+a+"," +b+"," +c+")");
                                cat3++;
                            } else if(b+1==c){
                                System.out.println("\t("+a+"," +b+"," +c+")");
                                cat1++;
                            } else if(a+1==b){
                                System.out.println("\t\t("+a+"," +b+"," +c+")");
                                cat2++;
                            } else {
                                System.out.println("("+a+"," +b+"," +c+")");
                            }
                            freq++; // increments once triple is confirmed
                        }
                    }
                }
                // printing results
                System.out.println("Number of pythagorean triples less than or equal to "+pythTrip+" is: "+freq);
                System.out.println("\nNumber of pythagorean triples less than or equal to "+pythTrip+" with either y=x+1 or z=y+1 is: "+(cat1+cat2+cat3));
                System.out.println("\nNumber of triples specifically with z=y+1 is: "+(cat1+cat3));
                System.out.println("\nNumber of tripples specifically with y=z+1 is: "+(cat2+cat3));
                System.out.println("\nHere's the visual:\n");

                // histogram
                if(freq>80){
                    System.out.print("Total Triples  | Number of stars: "+freq);
                } else {
                    System.out.print("Total Triples  | ");
                    for(int z=0; z<freq; z++){
                        System.out.print("*");
                    }
                }

                System.out.print("\ny=x+1 or z=y+1 | ");
                for(int y=0; y<(cat1+cat2+cat3); y++){
                    System.out.print("*");
                }
                System.out.print("\nz=y+1          | ");
                for(int x=0; x<(cat1+cat3); x++){
                    System.out.print("*");
                }
                System.out.print("\ny=x+1          | ");
                for(int w=0; w<(cat2+cat3); w++){
                    System.out.print("*");
                }
            }
            System.out.print("\nEnter a positive integer <ctrl+Z to exit> ");
        }
        input.close(); // closing scanner
        System.out.println("\nNormal Termination!"); // program ends if <crtl> command is inputted
    }
}