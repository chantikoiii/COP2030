import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class psuedo{
    public static void main(String [] args) throws FileNotFoundException {

        File file = new File("your/directory/here");

        FileReader readMe = new FileReader(file);
        BufferedReader bufferedReadMe = new BufferedReader(readMe);

        try(bufferedReadMe){

            String line;

            while((line = bufferedReadMe.readLine()) != null){
                System.out.println(line);
            }

        } catch(IOException e){
            System.err.println("An error has occured while reading document: " + e.getMessage());
        }
    }
}
