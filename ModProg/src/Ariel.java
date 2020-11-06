
/* Java program to implement 2D Binary Indexed Tree  

  
2D BIT is basically a BIT where each element is another BIT.  
Updating by adding v on (x, y) means it's effect will be found  
throughout the rectangle [(x, y), (max_x, max_y)],  
and query for (x, y) gives you the result of the rectangle  
[(0, 0), (x, y)], assuming the total rectangle is  
[(0, 0), (max_x, max_y)]. So when you query and update on  
this BIT,you have to be careful about how many times you are  
subtracting a rectangle and adding it. Simple set union formula  
works here.  

  
So if you want to get the result of a specific rectangle  
[(x1, y1), (x2, y2)], the following steps are necessary:  

  
Query(x1,y1,x2,y2) = getSum(x2, y2)-getSum(x2, y1-1) -  

                    getSum(x1-1, y2)+getSum(x1-1, y1-1)  

  
Here 'Query(x1,y1,x2,y2)' means the sum of elements enclosed  
in the rectangle with bottom-left corner's co-ordinates  
(x1, y1) and top-right corner's co-ordinates - (x2, y2)  

  
Constraints -> x1<=x2 and y1<=y2  

  

    /\  
y |  

    |     --------(x2,y2)  

    |     | |  

    |     | |  

    |     | |  

    |     ---------  

    | (x1,y1)  

    |  

    |___________________________  
(0, 0)             x-->  

  
In this program we have assumed a square matrix. The  
program can be easily extended to a rectangular one. */

class Ariel
{

// A structure to hold the queries  

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

// A function to update the 2D BIT
    static void updateBIT(int BIT[][], int x, int y, int val, int N, int M)
    {

        for (; x <= N; x += (x & -x))

        {

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
            for(; y > 0; y -= y&-y) {
                sum += BIT[x][y];
            }
        }
        return sum;
    }


// A function to create an auxiliary matrix  
// from the given input matrix  

    static void constructAux(int mat[][], int aux[][], int N, int M) {

        // Initialise Auxiliary array to 0

        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= M; j++)
                aux[i][j] = 0;


        // Conthe Auxiliary Matrix
        for (int j = 1; j <= M; j++)
            for (int i = 1; i <= N; i++)
                aux[i][j] = mat[M - j][i - 1];

        return;
    }


// A function to cona 2D BIT  

    static void construct2DBIT(int mat[][], int BIT[][], int N, int M) {
        // Create an auxiliary matrix
        int [][]aux = new int[N + 1][M + 1];

        constructAux(mat, aux, N, M);



        // Initialise the BIT to 0
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                BIT[i][j] = 0;



        for (int j = 1; j <= M; j++){
            for (int i = 1; i <= N; i++) {

                // Creating a 2D-BIT using update function
                // everytime we/ encounter a value in the
                // input 2D-array

                int v1 = getSum(BIT, i, j);
                int v2 = getSum(BIT, i, j - 1);
                int v3 = getSum(BIT, i - 1, j - 1);
                int v4 = getSum(BIT, i - 1, j);

                // Assigning a value to a particular element
                // of 2D BIT

                updateBIT(BIT, i, j, aux[i][j] -

                        (v1 - v2 - v4 + v3),N, M);
            }
        }
        return;
    }


// A function to answer the queries  

    static void answerQueries(Query q[], int m, int BIT[][]) {

        for (int i = 0; i < m; i++) {
            int x1 = q[i].x1 + 1;
            int y1 = q[i].y1 + 1;
            int x2 = q[i].x2 + 1;
            int y2 = q[i].y2 + 1;

            int ans = getSum(BIT, x2, y2) -
                    getSum(BIT, x2, y1 - 1) -

                    getSum(BIT, x1 - 1, y2) +

                    getSum(BIT, x1 - 1, y1 - 1);



            System.out.printf("Query(%d, %d, %d, %d) = %d\n",

                    q[i].x1, q[i].y1, q[i].x2, q[i].y2, ans);

        }

        return;
    }


// Driver Code 

    public static void main(String[] args)
    {

        int mat[][] = { {1, 2},
                {3,2},
                {4,7}};


        // Create a 2D Binary Indexed Tree
        // Nomás me tomo el más grande de largo o ancho
        int [][]BIT = new int[4][4];

        // Procuro no mentirle respecto al tamaño
        construct2DBIT(mat, BIT, 2 , 3);

  

    /* Queries of the form - x1, y1, x2, y2  

    For example the query- {1, 1, 3, 2} means the sub-matrix-  

        y  

        /\  

    3 | 1 2 3 4     Sub-matrix  

    2 | 5 3 8 1     {1,1,3,2} --.     3 8 1  

    1 | 4 6 7 5                                 6 7 5  

    0 | 2 4 8 9  

        |  

    --|------ 0 1 2 3 ---. x  

        |  

      

        Hence sum of the sub-matrix = 3+8+1+6+7+5 = 30  

    */

        Query q[] = {new Query(0, 0, 1, 2)};

        int m = q.length;



        answerQueries(q, m, BIT);
    }
} 
