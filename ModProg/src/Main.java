import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String primeraLinea;

        int N, Q, counter ;
        counter = 0;
        String[] inicioDeUnCaso;
        while ( (primeraLinea = lector.readLine() ) != null  && !primeraLinea.equals("0 0") ){
            inicioDeUnCaso = primeraLinea.split(" ");

            N = Integer.parseInt(inicioDeUnCaso[0]);
            Q = Integer.parseInt(inicioDeUnCaso[1]);

            int[] secuenciaCanicas = new int[N+1];

            System.out.println("CASE# " + ++counter + ":");

            for (int i = 0; i < N ; i++) {
                secuenciaCanicas[i] = Integer.parseInt(String.valueOf(lector.readLine()));
            }
            Arrays.sort(secuenciaCanicas);

            for (int i = 0; i < Q; i++) {
                int pregunta = Integer.parseInt(lector.readLine());
                boolean encontroLaPregunta = false;
                for (int j = 0; j < secuenciaCanicas.length; j++) {
                    if (secuenciaCanicas[j] == pregunta){
                        System.out.println(pregunta + " found at " + j);
                        encontroLaPregunta = true;
                        break;
                    }
                }
                if (!encontroLaPregunta){
                    System.out.println(pregunta +" not found" );
                }
            }

        }
    }
}
