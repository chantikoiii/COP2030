import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class psuedo{
    public static void main(String [] args) throws IOException {

        //declaring file as object
        File file = new File("your/directory/here");

        //reads the text file one character at a time
        FileReader readMe = new FileReader(file);
        //wrapping 'readMe' with a BufferedReader will allow file to be read one line at a time
        BufferedReader bufferedReadMe = new BufferedReader(readMe);

        try(bufferedReadMe){

            String line;

            while((line = bufferedReadMe.readLine()) != null){
                System.out.println(line);
            }

        } catch(IOException e){ //program keeps throwing 'FileNotFoundException' error for some reason
            System.err.println("An error has occured " + e.getMessage());
        }
    }
}
