import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Schewissen {
    public static void main(String[] args) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String primeraLinea;

        while ((primeraLinea = lector.readLine())!= null && !primeraLinea.equals("0 0 0")) {

            StringTokenizer tokensPrimeraLinea = new StringTokenizer(primeraLinea);


            int[][] base = new int[intValueOf(tokensPrimeraLinea.nextToken())][intValueOf(tokensPrimeraLinea.nextToken())];




            int costoMataPlagas = intValueOf(tokensPrimeraLinea.nextToken());


            int consultas = intValueOf(lector.readLine());
            StringTokenizer consulta;

            for (int i = 0; i < consultas; i++) {
                consulta = new StringTokenizer(lector.readLine());

                if (consulta.nextToken().equals("A")) {

                    int plaga = intValueOf(consulta.nextToken());
                    int corrdenadaX = intValueOf(consulta.nextToken());
                    int coordenadaY = intValueOf(consulta.nextToken());

                    for (int j = corrdenadaX; j < base.length; j |= j + 1)
                        for (int k = coordenadaY; k < base[0].length; k |= k + 1)
                            base[j][k] += plaga;



                }else{

                    int coordenada1X = intValueOf(consulta.nextToken());
                    int coordenada1Y = intValueOf(consulta.nextToken());
                    int coordenada2X = intValueOf(consulta.nextToken());
                    int coordenada2Y = intValueOf(consulta.nextToken());

                    int minX = (coordenada1X > coordenada2X ? coordenada2X: coordenada1X);
                    int miny = (coordenada1Y > coordenada2Y ? coordenada2Y: coordenada1Y);
                    int maxX = (coordenada1X < coordenada2X ? coordenada2X: coordenada1X);
                    int maxY = (coordenada1Y < coordenada2Y ? coordenada2Y: coordenada1Y);


                    int cuadranteGrande = 0;
                    for (int k = maxX; k >= 0; k = (k & (k + 1)) - 1)
                        for (int j = maxY; j >= 0; j = (j & (j + 1)) - 1)
                            cuadranteGrande += base[k][j];

                    int cuadranteInf = 0;
                    for (int k = (minX - 1); k >= 0; k = (k & (k + 1)) - 1)
                        for (int j = maxY; j >= 0; j = (j & (j + 1)) - 1)
                            cuadranteInf += base[k][j];

                    int cuadranteLat = 0;
                    for (int k = maxX; k >= 0; k = (k & (k + 1)) - 1)
                        for (int j = (miny -1); j >= 0; j = (j & (j + 1)) - 1)
                            cuadranteLat += base[k][j];

                    int cuadraroRestante = 0;
                    for (int k = minX - 1; k >= 0; k = (k & (k + 1)) - 1)
                        for (int j = miny - 1; j >= 0; j = (j & (j + 1)) - 1)
                            cuadraroRestante += base[k][j];

                    int sumatoria = cuadranteGrande - cuadranteInf- cuadranteLat
                            + cuadraroRestante;
                    System.out.println(sumatoria*costoMataPlagas);
                }
            }
            System.out.println();
        }
    }


    /**
     * Sirve para convertir una cadena a número, se usa invocándolo directamente
     * @param str cadena que será convertida
     * @return número convertido
     */
    public static int intValueOf( String str ) {
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
