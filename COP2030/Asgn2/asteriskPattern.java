public class asteriskPattern {
    public static void main(String[] args){
        asteriskPattern.diamond();
        System.out.print("\n");
        asteriskPattern.checker();
        System.out.print("\nNicely Done!");
    }

    public static void diamond() {
        int lnNo=9, ask=1, spc=lnNo/2;

        for (int i=1; i<=lnNo; i++) { //iteration of rows

            for (int k=spc; k>=1; k--) { //number of spaces
                System.out.print(" ");
            }

            for (int j=1; j<=ask; j++) { //number of asterisks
                System.out.print("*");
            }

            System.out.println(); //prints diamond

            if (i < lnNo/2+1) {
                ask += 2; //asterisks increasing before center 
                spc -= 1; //spaces decreasing before center
            } else {
                ask -= 2; //asterisks decreasing
                spc += 1; //spaces increasing

            }
        }
    }

    public static void checker() {
        int rows=6; int cols=16; //size of checkers

    for(int i=0; i<rows; i++) { //setting boundaries for checkers
        for(int j=0; j<cols; j++) {
            if((i + j) % 2 == 0) { //loop to create staggered pattern
                System.out.print(" ");
            } else {
                System.out.print("*");
            }
        }

        System.out.println(); //prints checkers
    }
    }
}
