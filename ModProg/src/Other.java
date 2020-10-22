import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Other {

    public static int search (int [] ints, int targ) {
        for (int i=0;i<ints.length;i++) if (ints[i]==targ) return i;
        return -1;
    }

    public static void main (String [] abc) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=1; String s;
        while ((s=br.readLine())!=null && !s.equals("0 0")) {
            StringTokenizer st=new StringTokenizer(s);
            int N=Integer.parseInt(st.nextToken());
            int Q=Integer.parseInt(st.nextToken());

            int [] ints=new int [N];
            for (int i=0;i<N;i++) ints[i]=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            Arrays.sort(ints);
            System.out.println("CASE# "+testCase+++":");

            for (int i=0;i<Q;i++) {
                int target=Integer.parseInt((new StringTokenizer(br.readLine()).nextToken()));
                int index=search(ints,target);
                if (index>=0) System.out.println(target+" found at "+(index+1));
                else  System.out.println(target+" not found");
            }
        }


    }
}