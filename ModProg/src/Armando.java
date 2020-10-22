import java.io.IOException;
//import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Armando {
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String respuesta;
        int contador = 1;
        int a1, a2 = 1;
        String[] datos;
        while ((respuesta = leer.readLine()) != null && !respuesta.equals("0 0")) {  
            datos = respuesta.split(" ");
            a1 = Integer.parseInt(datos[0]);
            int[] cantidad = new int[a1];
            for (int i = 0; i < a1; i++) {
                cantidad[i] = Integer.parseInt(String.valueOf(leer.readLine()));
            }
            quickSort(cantidad, 0, cantidad.length - 1);
            //Arrays.sort(cantidad);
            a2 = Integer.parseInt(datos[1]);
            int[] veces = new int[a2];
            for (int i = 0; i < a2; i++) {
                int consulta = Integer.parseInt(leer.readLine());
                veces[i] = (consulta);
            }
            System.out.println("CASE# " + contador + ":");
            busqueda(cantidad, veces);
            contador++;
        }
    }

    private static void quickSort(int[] a, int inicio, int fin) {
        if (inicio < fin) {
            int posicion = separar(a, inicio, fin);
            quickSort(a, inicio, posicion - 1);
            quickSort(a, posicion + 1, fin);
        }
    }

    private static int separar(int[] a, int inicio, int fin) {
        int pivote = a[inicio];
        int izq = inicio + 1;
        int der = fin;
        while (izq <= der) {
            if (a[izq] <= pivote)
                izq++;
            else if (pivote < a[der])
                der--;
            else {
                int copia = a[izq];
                a[izq] = a[der];
                a[der] = copia;
                izq++;
                der--;
            }
        }
        a[inicio] = a[der];
        a[der] = pivote;
        return der;
    }

    private static void busqueda(int[] cantidad, int[] veces) {
        for (int i = 0; i < veces.length; i++) {
            boolean a1 = false;
            for (int j = 0; j < cantidad.length; j++) {
                if (a1 == false && (veces[i] == cantidad[j])) {
                    System.out.println(veces[i] + " found at " + (j + 1));
                    a1 = true;
                }
                if (a1 == false && (j == cantidad.length - 1)) {
                    System.out.println(veces[i] + " not found");
                }
            }

        }

    }
}