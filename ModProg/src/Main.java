import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = bufferedReader.readLine() )!= null && !line.equals("0 0")){
            System.out.println("Ola putos " + line + " long: " + line.length() );
            if (line.length() > 1){
                System.out.println("Esta tiene 2 numeros puto " + "el " + line.charAt(0)+ " y el: " + line.charAt(2));
            }
        }
    }
}
