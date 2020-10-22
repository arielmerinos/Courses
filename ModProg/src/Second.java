import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Second {
    public static void main(String[] args) throws IOException {

        BufferedReader lector =  new BufferedReader( new InputStreamReader(System.in));
        String primeraLinea;
        while ((primeraLinea = lector.readLine()) != null && !primeraLinea.equals("0 0 0")){
            StringTokenizer tokensPrimeraLinea = new StringTokenizer(primeraLinea);
            int ancho = Integer.parseInt(tokensPrimeraLinea.nextToken());
            int largo = Integer.parseInt(tokensPrimeraLinea.nextToken());
            int costoMataPlagas = Integer.parseInt(tokensPrimeraLinea.nextToken());

            int[][] cancha = new int[ancho][largo];

            int consultas = Integer.parseInt(lector.readLine());
            StringTokenizer consulta;
            for (int i = 0; i < consultas; i++) {
                consulta = new StringTokenizer(lector.readLine());

                String identificador = consulta.nextToken();
                if (identificador.equals("A")){
                    int plaga = Integer.parseInt(consulta.nextToken());
                    int ubicacionX = Integer.parseInt(consulta.nextToken());
                    int ubicacionY = Integer.parseInt(consulta.nextToken());
                    cancha[ubicacionX][ubicacionY] += plaga;

                } else{
                    int inicioX = Integer.parseInt(consulta.nextToken());
                    int inicioY = Integer.parseInt(consulta.nextToken());
                    int finX = Integer.parseInt(consulta.nextToken());
                    int finY = Integer.parseInt(consulta.nextToken());
                    System.out.println("Aquí inicia: " + inicioX +" " + inicioY + ": "+cancha[inicioX][inicioY]);
                    System.out.println("Aquí termina: "+ finX + " " + finY + ": " +  cancha[finX][finY]);
                    int diferenciaX = Math.abs(finX - inicioX);
                    int diferenciaY = Math.abs(finY - inicioY);
                    int costoEnTotal = 0;
                    int minimoX = Math.min(inicioX, finX);
                    int minimoY = Math.min(inicioY, finY);
                    System.out.println("la diferencia en X es: " + diferenciaX);
                    System.out.println("la diferencia en Y es: " + diferenciaY);
                    for (int j = 0; j <= diferenciaX; j++) {
                        for (int k = 0; k <= diferenciaY ; k++) {
                            System.out.println(cancha[j + minimoX][k + minimoY]);
                            costoEnTotal += cancha[j + minimoX][k + minimoY];
                        }
                    }
                    costoEnTotal *= costoMataPlagas;
                    System.out.println("El costo en esta consulta es de: " +costoEnTotal);
                }

            }


        }

    }
}
