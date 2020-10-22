import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CasiIgual {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String respuesta;
        int contador = 1;
        int N, Q = 1;
        String[] datos;
        while ((respuesta = lector.readLine()) != null && !respuesta.equals("0 0")) {

            datos = respuesta.split(" ");

            N = Integer.parseInt(datos[0]);
            int[] canicas = new int[N];
            for (int i = 0; i < N; i++) {
                canicas[i] = Integer.parseInt(String.valueOf(lector.readLine()));
            }
            Arrays.sort(canicas);

            Q = Integer.parseInt(datos[1]);

            int[] preguntas = new int[Q];
            for (int i = 0; i < Q; i++) {
                preguntas[i] = Integer.parseInt(lector.readLine());
            }
            System.out.println("CASE# " + contador + ":");
            busqueda(canicas, preguntas);
            contador++;
        }
    }

    private static void busqueda(int[] canicas, int[] preguntas) {
        for (int i = 0; i < preguntas.length; i++){
            boolean encontroLaCanica = false;
            for (int j = 0; j < canicas.length; j++) {
                if ((preguntas[i] == canicas[j])) {
                    encontroLaCanica = true;
                    System.out.println(preguntas[i] + " found at " + (j + 1));
                    break;
                }
            }
            if (!encontroLaCanica){
                System.out.println(preguntas[i] +" not found");
            }
        }
    }
}