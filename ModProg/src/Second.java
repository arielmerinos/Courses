import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Second {
    public static void main(String[] args) throws IOException {

        BufferedReader lector =  new BufferedReader( new InputStreamReader(System.in));
        String primeraLinea;

        int inicio = 1;
        while (inicio-- > 0){
//        while ((primeraLinea = lector.readLine()) != null && !primeraLinea.equals("0 0 0")){
//            String[] dimensiones = primeraLinea.split(" ");

//            int ancho = intValueOf(dimensiones[0]);
//            int largo = intValueOf(dimensiones[1]);
//            int costoMataPlagas = intValueOf(dimensiones[2]);
            int ancho = 4;
            int largo = 2;

            int[][] cancha = {{2,3,4,5},{5,5,3,4}};

            int[] totalesColumnas = new int[ancho];
            int[] totalesFilas = new int[largo];

            int puestasEnContacto = intValueOf(lector.readLine());
            String[] consultaActual;
            int inicioX, inicioY, finX, finY, diferenciaX, diferenciaY;

            int [][] BIT = new int[ancho + 1][ largo + 1];
            construct2DBIT(cancha, BIT, ancho, largo);
            int respuesta = answerQuery(new Query(1,1,2,2), BIT);
            System.out.println(respuesta);



//            for (int i = 0; i < puestasEnContacto; i++) {
//                consultaActual = lector.readLine().split(" ");
//
//                if (consultaActual[0].equals("A")){
//                    int plaga = intValueOf(consultaActual[1]);
//                    int ubicacionX = intValueOf(consultaActual[2]);
//                    int ubicacionY = intValueOf(consultaActual[3]);
//                    cancha[ubicacionX][ubicacionY] += plaga;
//                    /**
//                     * Sumando los totales en filas y columnas
//                     */
//                    totalesColumnas[ubicacionX] += plaga;
//                    totalesFilas[ubicacionY] += plaga;
//
//                } else{
//                    inicioX = intValueOf(consultaActual[1]);
//                    inicioY = intValueOf(consultaActual[2]);
//                    finX = intValueOf(consultaActual[3]);
//                    finY = intValueOf(consultaActual[4]);
//                    diferenciaX = finX - inicioX > 0? finX - inicioX : inicioX - finX;
//                    diferenciaY = finY - inicioY > 0? finY - inicioY : inicioY - finY;
//
//                    /**
//                     * Calculando donde iniciar
//                     */
//                    int minimoX = inicioX < finX ? inicioX: finX;
//                    int minimoY = inicioY < finY ? inicioY: finY;
//
//                    int maximoX = inicioX > finX ? inicioX: finX;
//                    int maximoY = inicioY > finY ? inicioY: finY;
//
//                    int [][] BIT = new int[ancho + 1][ largo + 1];
//                    construct2DBIT(cancha, BIT, ancho, largo);
//                    int respuesta = answerQuery(new Query(minimoX, minimoY, maximoX, maximoY), BIT);
//                    System.out.println(respuesta);
//
//                    int costoEnTotal = 0;
//
////                    costoEnTotal *= costoMataPlagas;
//                    System.out.println(costoEnTotal);
//                }
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

    static int answerQuery(Second.Query q, int BIT[][]) {

        int x1 = q.x1 + 1;
        int y1 = q.y1 + 1;
        int x2 = q.x2 + 1;
        int y2 = q.y2 + 1;

        return getSum(BIT, x2, y2) -
                getSum(BIT, x2, y1 - 1) -
                getSum(BIT, x1 - 1, y2) +
                getSum(BIT, x1 - 1, y1 - 1);
    }


    static class Query {
        int x1, y1; // x and y co-ordinates of bottom left
        int x2, y2; // x and y co-ordinates of top right

        public Query(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    };

    static void updateBIT(int BIT[][], int x, int y, int val, int N, int M) {

        for (; x <= N; x += (x & -x)){
            // This loop update all the 1D BIT inside the
            // array of 1D BIT = BIT[x]
            for (; y <= M; y += (y & -y))
                BIT[x][y] += val;
        }
        return;
    }


// A function to get sum from (0, 0) to (x, y)

    static int getSum(int BIT[][], int x, int y) {
        int sum = 0;
        for(; x > 0; x -= x&-x) {
            // This loop sum through all the 1D BIT
            // inside the array of 1D BIT = BIT[x]
            for(; y > 0; y -= y&-y){
                sum += BIT[x][y];
            }
        }
        return sum;
    }

// A function to create an auxiliary matrix
// from the given input matrix
    static void constructAux(int mat[][], int aux[][], int N, int M){

        // Initialise Auxiliary array to 0
        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= M; j++)
                aux[i][j] = 0;


        // Conthe Auxiliary Matrix
        for (int j = 1; j <= N; j++)
            for (int i = 1; i <= M; i++)
                aux[i][j] = mat[2 - j][i - 1];
        return;
    }


// A function to cona 2D BIT

    static void construct2DBIT(int mat[][], int BIT[][], int N, int M) {

        // Create an auxiliary matrix

        int [][]aux = new int[2 + 1][2 + 1];
        constructAux(mat, aux, N, M);

        // Initialise the BIT to 0

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                BIT[i][j] = 0;


        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {

                // Creating a 2D-BIT using update function
                // everytime we/ encounter a value in the
                // input 2D-array
                int v1 = getSum(BIT, i, j);
                int v2 = getSum(BIT, i, j - 1);
                int v3 = getSum(BIT, i - 1, j - 1);
                int v4 = getSum(BIT, i - 1, j);

                // Assigning a value to a particular element
                // of 2D BIT
                updateBIT(BIT, i, j, aux[i][j] - (v1 - v2 - v4 + v3), N, M);
            }
        }
        return;
    }
}


