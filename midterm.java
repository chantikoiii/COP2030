import java.util.Scanner;
import java.util.Arrays;

public class midterm{ //main class
    public static void main(String [] args){
        Scanner readString = new Scanner(System.in); //create scanner object
        System.out.println("\nYour String:TO QUIT-<ctrl d>(UNIX)/<ctrl z>(Windows)>\n"); //prompt input

        mainloop:
        while(readString.hasNextLine()){ //checks if user uses <crtl + z> command
            String myString = readString.nextLine(); //assign input to variable

            double vowels = 0, characters = myString.length(); //initialize variables
            double a=0, e=0, i=0, o=0, u=0;
            
            while(characters == 0){ //restarts mainloop if nothing is inputted
                System.out.println("Empty string!");
                System.out.print("\nYour String:TO QUIT-<ctrl d>(UNIX)/<ctrl z>(Windows)>\n");
                continue mainloop;
            }

            myString = myString.toLowerCase();
        
            for (int j = 0; j < myString.length(); ++j) { //conditions for counting
                char ch = myString.charAt(j); //indexing 'ch'

                if(ch=='a'){ //loop body
                 a++;
                } else if(ch=='e'){
                    e++;
                } else if(ch=='i'){
                    i++;
                } else if(ch=='o'){
                    o++;
                } else if(ch=='u'){
                    u++;
                }
                vowels=a+e+i+o+u; //sum vowels
            }

            if(vowels==0){ //restarts mainloop if there are no vowels 
                System.out.println("Vowels - Defieicent Language!");
                System.out.print("\nYour String:TO QUIT-<ctrl d>(UNIX)/<ctrl z>(Windows)>\n");
                continue mainloop;
            }

            //printing results to console
            System.out.println("\nVowel Summary");
            System.out.println("#a: "+(int)a); 
            System.out.println("#e: "+(int)e);
            System.out.println("#i: "+(int)i);
            System.out.println("#o: "+(int)o);
            System.out.println("#u: "+(int)u);
            System.out.println();
            System.out.println("Number of characters: "+(int)characters);
            System.out.println("Total vowels: "+(int)vowels);
            System.out.println();

            double probTotal=vowels/characters; //calculating & assigning probabilities
            double proba=a/characters, probe=e/characters, probi=i/characters, probo=o/characters, probu=u/characters;

            //printing probabilities 
            if(probTotal == 1){//if all characters are vowels
                System.out.print("Probability of finding a vowel at random is: 1... Must be talking crazy!");
                } else {
                    System.out.print("Probability of finding a vowel at random : ");
                    System.out.format("%.2f", probTotal);
                }
    
            System.out.println("\n");
    
            System.out.print("Probability of finding an 'a': ");
            System.out.format("%.2f", proba);
            System.out.println();
            System.out.print("Probability of finding an 'e': ");
            System.out.format("%.2f", probe);
            System.out.println();
            System.out.print("Probability of finding an 'i': ");
            System.out.format("%.2f", probi);
            System.out.println();
            System.out.print("Probability of finding an 'o': ");
            System.out.format("%.2f", probo);
            System.out.println();
            System.out.print("Probability of finding an 'u': ");
            System.out.format("%.2f", probu);
    
            System.out.println("\n");
            //histogram (Horizontal)
            //asterisks printed based on vowel frequency
            System.out.println("Horizontal Picture");
            
            System.out.print("\na | ");
            for(int z=0; z<a; z++){
                System.out.print("*");
            }
            System.out.print("\ne | ");
            for(int y=0; y<e; y++){
                System.out.print("*");
            } 
            System.out.print("\ni | ");
            for(int x=0; x<i; x++){
                System.out.print("*");
                }
            System.out.print("\no | ");
            for(int w=0; w<o; w++){
                System.out.print("*");
                }
            System.out.print("\nu | ");
            for(int v=0; v<u; v++){
                System.out.print("*");
                }
    
            System.out.println("\n");

            //histogram (Vertical)
            System.out.println("Vertical Picture");
            System.out.println();
    
            double[] vert = new double[5]; //creating array for chart
            vert[0]=a; vert[1]=e; vert[2]=i; vert[3]=o; vert[4]=u;
    
            double max=0;
            for(double num:vert){ //determining largest value
                if(num > max){
                    max=num;
                }
            }
                
            for(double k=max; k>0; k--){ //determines if position has '*' or ' '
                for (double num:vert){
                    if(num >= k){
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println(); //new column
            }
            System.out.println("_________");
            System.out.println("a e i o u");
            System.out.println("\n");

            System.out.println("\nYour String:TO QUIT-<ctrl d>(UNIX)/<ctrl z>(Windows)>\n");
        }
        readString.close();//closing scanner
        System.out.println("Normal Termination!");//program ends if <ctrl + z> is inputted 
    }        
}

       
    

