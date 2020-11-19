
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Spurs {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String primeraLinea;
        while ((primeraLinea = lector.readLine()) !=  null){
            StringTokenizer tokensPrimeraLinea = new StringTokenizer(primeraLinea);
            int equipos = Integer.parseInt(tokensPrimeraLinea.nextToken());
            if (equipos != 0){

                int instancia = 1;
                System.out.println("Instancia " + instancia++);
                for (int i = 0; i < equipos*(equipos-1)/2; i++) {
                    
                }

            }else {
                System.out.println("\n");
            }

        }
    }
}
