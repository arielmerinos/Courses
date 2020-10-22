import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Second {
    public static void main(String[] args) throws IOException {

        BufferedReader lector =  new BufferedReader( new InputStreamReader(System.in));
        String primeraLinea;
        String[] dimensiones;

        while ((primeraLinea = lector.readLine()) != null && !primeraLinea.equals("0 0 0")){
            dimensiones = primeraLinea.split(" ");
            int ancho = Integer.parseInt(dimensiones[0]);
            int largo = Integer.parseInt(dimensiones[1]);
            int costoMataPlagas = Integer.parseInt(dimensiones[2]);

            int[][] cancha = new int[ancho][largo];

            int consultas = Integer.parseInt(lector.readLine());
            String[] consulta;
            int inicioX;
            int inicioY;
            int finX;
            int finY;
            int diferenciaX;
            int diferenciaY;
            for (int i = 0; i < consultas; i++) {
                consulta = lector.readLine().split(" ");
                if (consulta[0].equals("A")){
                    int plaga = Integer.parseInt(consulta[1]);
                    int ubicacionX = Integer.parseInt(consulta[2]);
                    int ubicacionY = Integer.parseInt(consulta[3]);
                    cancha[ubicacionX][ubicacionY] += plaga;

                } else{
                    inicioX = Integer.parseInt(consulta[1]);
                    inicioY = Integer.parseInt(consulta[2]);
                    finX = Integer.parseInt(consulta[3]);
                    finY = Integer.parseInt(consulta[4]);
                    diferenciaX = Math.abs(finX - inicioX);
                    diferenciaY = Math.abs(finY - inicioY);
                    int costoEnTotal = 0;
                    int minimoX = inicioX < finX ? inicioX: finX;
                    int minimoY = inicioY < finY ? inicioY: finY;
                    for (int j = 0; j <= diferenciaX; j++) {
                        for (int k = 0; k <= diferenciaY ; k++) {
                            costoEnTotal += cancha[j + minimoX][k + minimoY];
                        }
                    }
                    costoEnTotal *= costoMataPlagas;
                    System.out.println(costoEnTotal);
                }

            }

        }

    }
}
