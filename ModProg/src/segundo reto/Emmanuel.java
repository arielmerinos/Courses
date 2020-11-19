//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
//        String primeraLinea;
//
//        while ((primeraLinea = lector.readLine())!= null && !primeraLinea.equals("0 0 0")) {
//
//            StringTokenizer tokensPrimeraLinea = new StringTokenizer(primeraLinea);
//
//            FTree2D canchaFut = new FTree2D(intValueOf(tokensPrimeraLinea.nextToken()),
//                    intValueOf(tokensPrimeraLinea.nextToken()));
//
//            int costoMataPlagas = intValueOf(tokensPrimeraLinea.nextToken());
//
//
//            int consultas = intValueOf(lector.readLine());
//            StringTokenizer consulta;
//
//            for (int i = 0; i < consultas; i++) {
//                consulta = new StringTokenizer(lector.readLine());
//
//                if (consulta.nextToken().equals("A")) {
//
//                    int plaga = intValueOf(consulta.nextToken());
//
//                    canchaFut.añadirValor(intValueOf(consulta.nextToken()),
//                            intValueOf(consulta.nextToken()),
//                            plaga);
//
//                }else{
//
//                    int coordenada1X = intValueOf(consulta.nextToken());
//                    int coordenada1Y = intValueOf(consulta.nextToken());
//                    int coordenada2X = intValueOf(consulta.nextToken());
//                    int coordenada2Y = intValueOf(consulta.nextToken());
//
//                    int sumatoria = canchaFut.getSumaCoordenada((coordenada1X > coordenada2X ? coordenada2X: coordenada1X),
//                            (coordenada1Y > coordenada2Y ? coordenada2Y: coordenada1Y),
//                            (coordenada1X < coordenada2X ? coordenada2X: coordenada1X),
//                            (coordenada1Y < coordenada2Y ? coordenada2Y: coordenada1Y));
//
//                    System.out.println(sumatoria*costoMataPlagas);
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    /**
//     * Sirve para convertir una cadena a número, se usa invocándolo directamente
//     * @param str cadena que será convertida
//     * @return número convertido
//     */
//    public static int intValueOf( String str ) {
//        int ival = 0, idx = 0, end;
//        boolean sign = false;
//        char ch;
//
//        if( str == null || ( end = str.length() ) == 0 ||
//                ( ( ch = str.charAt( 0 ) ) < '0' || ch > '9' )
//                        && ( !( sign = ch == '-' ) || ++idx == end || ( ( ch = str.charAt( idx ) ) < '0' || ch > '9' ) ) )
//            throw new NumberFormatException( str );
//
//        for(;; ival *= 10 )
//        {
//            ival += '0'- ch;
//            if( ++idx == end )
//                return sign ? ival : -ival;
//            if( ( ch = str.charAt( idx ) ) < '0' || ch > '9' )
//                throw new NumberFormatException( str );
//        }
//    }
//
//}
//class FTree2D {
//
//    int[][] base;
//    int maxEnX, maxEnY;
//
//    public FTree2D(int maxEnX, int maxEnY) {
//        this.maxEnX = maxEnX;
//        this.maxEnY = maxEnY;
//        this.base = new int[maxEnX][maxEnY];
//    }
//
//    public void añadirValor(int r, int c, int value) {
//        for (int i = r; i < base.length; i |= i + 1)
//            for (int j = c; j < base[0].length; j |= j + 1)
//                base[i][j] += value;
//    }
//
//    public int getSuma(int r, int c) {
//        int resultado = 0;
//        for (int i = r; i >= 0; i = (i & (i + 1)) - 1)
//            for (int j = c; j >= 0; j = (j & (j + 1)) - 1)
//                resultado += base[i][j];
//        return resultado;
//    }
//
//    public int getSumaCoordenada(int r1, int c1, int r2, int c2) {
//        return getSuma(r2, c2) - getSuma(r1 - 1, c2) - getSuma(r2, c1 - 1)
//                + getSuma(r1 - 1, c1 - 1);
//    }
//}
