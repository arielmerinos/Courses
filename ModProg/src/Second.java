import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Second {
    public static void main(String[] args) throws IOException {

        BufferedReader lector =  new BufferedReader( new InputStreamReader(System.in));
        String primeraLinea;
        String[] dimensiones;

        while ((primeraLinea = lector.readLine()) != null && !primeraLinea.equals("0 0 0")){
            dimensiones = primeraLinea.split(" ");
            int ancho = intValueOf(dimensiones[0]);
            int largo = intValueOf(dimensiones[1]);
            int costoMataPlagas = intValueOf(dimensiones[2]);

            int[][] cancha = new int[ancho][largo];

            int consultas = intValueOf(lector.readLine());
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
                    int plaga = intValueOf(consulta[1]);
                    int ubicacionX = intValueOf(consulta[2]);
                    int ubicacionY = intValueOf(consulta[3]);
                    cancha[ubicacionX][ubicacionY] += plaga;

                } else{
                    inicioX = intValueOf(consulta[1]);
                    inicioY = intValueOf(consulta[2]);
                    finX = intValueOf(consulta[3]);
                    finY = intValueOf(consulta[4]);
                    diferenciaX = finX - inicioX > 0? finX - inicioX : inicioX - finX;
                    diferenciaY = finY - inicioY > 0? finY - inicioY : inicioY - finY;
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
    public static int intValueOf( String str )
    {
        int ival = 0, idx = 0, end;
        boolean sign = false;
        char ch;

        if( str == null || ( end = str.length() ) == 0 ||
                ( ( ch = str.charAt( 0 ) ) < '0' || ch > '9' )
                        && ( !( sign = ch == '-' ) || ++idx == end || ( ( ch = str.charAt( idx ) ) < '0' || ch > '9' ) ) )
            throw new NumberFormatException( str );

        for(;; ival *= 10 )
        {
            ival += '0'- ch;
            if( ++idx == end )
                return sign ? ival : -ival;
            if( ( ch = str.charAt( idx ) ) < '0' || ch > '9' )
                throw new NumberFormatException( str );
        }
    }
}
