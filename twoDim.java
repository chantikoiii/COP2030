import java.util.Arrays;
import java.util.Scanner;

public class twoDim{ //main class
    public static void main(String [] args){ //main method

        Scanner input = new Scanner(System.in); //for array input

        System.out.print("\nNumber of rows:<ctrl d/ctrl z to quit> ");

        mainloop:
        while(input.hasNextInt()){ 
            int rowsInput = input.nextInt();

            if(rowsInput<=0){ //array must be positive
                System.out.println("Matrix size needs a positive integer-try again!\n");
                System.out.print("Number of rows:<ctrl d/ctrl z to quit> ");
                continue;
            }

            System.out.print("Number of columns:<ctrl d/ctrl z to quit> ");
            while(input.hasNextInt()){

                int columnsInput = input.nextInt();

                if(columnsInput<=0){ //array must be positive
                    System.out.println("Matrix size needs a positive integer-try again!\n");
                    System.out.print("Number of columns:<ctrl d/ctrl z to quit> ");
                    continue;
                }

                int[][] userMatrix = new int[rowsInput][columnsInput]; //initialize xay

                twoDim.array(userMatrix, rowsInput, columnsInput); //this method populates the array with user inputted values & prints result

                System.out.println();
                System.out.println("Sort rows or columns:");
                System.out.println("\t1 to Sort rows");
                System.out.println("\t2 to Sort columns");
                System.out.print("\tDecide! <OR ctrl d/ctrl z to quit> ");

                while(input.hasNextInt()){

                    int sort = input.nextInt();

                    if(sort!=1 && sort!=2){ //if user inputs any other value
                        System.out.println("Messed up input - try again!\n");
                        System.out.println("Unsorted matrix - look above!\n");
                        System.out.print("Number of rows:<ctrl d/ctrl z to quit> ");
                        continue mainloop;
                    } else if(sort==1){
                        //this method sorts the array by rows
                        twoDim.arraySortedR(userMatrix, rowsInput, columnsInput);
                        System.out.print("Number of rows:<ctrl d/ctrl z to quit> ");
                        continue mainloop;
                    } else if(sort==2){
                        //this method sorts the array by columns
                        twoDim.arraySortedC(userMatrix, rowsInput, columnsInput);
                        System.out.print("Number of rows:<ctrl d/ctrl z to quit> ");
                        continue mainloop;
                    }
                }
            }
        }
        input.close();
        System.out.println("Normal Termination!");
    }

    public static void array(int x[][], int rows, int columns){ //populate array

        Scanner populate = new Scanner(System.in); //for populateing array

        int i=0; int j=0; //initialize loop var

        while(i < rows){
            while(j < columns){
                System.out.print("x["+i+"]["+j+"]: ");
                x[i][j] = populate.nextInt();

                j+=1;
            }
            i+=1;
            j=0; //resets column value when row iterates
        }

        System.out.println("\n");

        System.out.println("Here's your Matrix");
        System.out.println("------------------");

        //generates matrix
        for(int a=0; a<columns; a++){
            System.out.print("\tc"+a);
        }
        System.out.println();

        for(int b=0; b<rows; b++){
            System.out.print("Row-"+b+" : ");

            for(int c=0; c<columns; c++){
                System.out.print(x[b][c]+"\t");
            }
            System.out.println();
        }
        populate.close();
    }

    public static void arraySortedR(int x[][], int rowSortR, int columnSortR){ //sort array by row
        
        System.out.println("Row Sorted- alternate descending and ascending:\n");
        System.out.println("Original left-Sorted Right!");
        System.out.println("---------------------------\n");
            
                
        for (int d = 0; d < columnSortR; d++) {
            System.out.print("\tc" + d);
        }

        System.out.print("\t\t\t"); //column headers for og & new array

        for (int d = 0; d < columnSortR; d++) {
            System.out.print("\tc" + d);
        }

        System.out.println();

        for (int e=0; e<rowSortR; e++) {

            System.out.print("Row-" + e + " : ");
                
            for (int f = 0; f<columnSortR; f++){
                System.out.print(x[e][f] + "\t");
            }

            System.out.print("\t\tRow-" + e + " : ");

            int[] rowCopyR = new int[columnSortR]; //create a copy row to sort
            System.arraycopy(x[e], 0, rowCopyR, 0, columnSortR); //populate with same values


            for (int j = 0; j < columnSortR - 1; j++){
                for (int k = j + 1; k < columnSortR; k++){
                    if(e%2==0){ //high to low
                        if(rowCopyR[j] < rowCopyR[k]){
                            int temp = rowCopyR[j];
                            rowCopyR[j] = rowCopyR[k];
                            rowCopyR[k] = temp;
                        }
                    } else { //low to high
                        if(rowCopyR[j] > rowCopyR[k]){
                            int temp = rowCopyR[j];
                            rowCopyR[j] = rowCopyR[k];
                            rowCopyR[k] = temp;
                        }
                    }
                }
            }

            for (int j = 0; j < columnSortR; j++) {
                System.out.print(rowCopyR[j] + "\t");
            }

            System.out.println(); 
        }
        
    }

    public static void arraySortedC(int x[][], int rowSortC, int columnSortC){ //sort array by column
        System.out.println("Column Sorted- alternate ascending and descending:\n");
        System.out.println("Original left-Sorted Right!");
        System.out.println("---------------------------\n");

        for (int d=0; d<columnSortC; d++){
            System.out.print("\tc" + d);
        }

        System.out.print("\t\t\t"); //column headers for og & new array

        for (int d=0; d<columnSortC; d++){
            System.out.print("\tc" + d);
        }

        System.out.println();

        for (int e=0; e<rowSortC; e++){

            System.out.print("Row-" + e + " : ");
                
            for (int f = 0; f<columnSortC; f++){
                System.out.print(x[e][f] + "\t");
            }

            System.out.print("\t\tRow-" + e + " : ");

            int[] columnCopyC = Arrays.copyOf(x[e], columnSortC);

            //sorting by columns [WIP] [DOES NOT WORK]
            for (int g=0; g<columnSortC; g++){

                for (int i=0; i<rowSortC-1; i++){
                    int min = i;
    
                    for (int j=i+1; j<rowSortC; j++){
                        if(g%2==0){
                            if (x[j][g]<x[min][g]){
                                min=j;
                            }
                        } else {
                            if(x[j][g]>x[min][g]){
                                min=j;
                            }
                        }
                    }
    
                    // Swap rows
                    if (min!= i) {
                        for (int k=0; k<columnSortC; k++){
                            int temp = x[i][k];
                            x[i][k] = x[min][k];
                            x[min][k] = temp;
                        }
                    }
                }
            }

            for (int f=0; f<columnSortC; f++){
                System.out.print(columnCopyC[f] + "\t");
            }

            System.out.println();
        }
    } 
}
