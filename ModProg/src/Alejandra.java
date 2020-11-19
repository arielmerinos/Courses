import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Objects;

public class Alejandra {

    public static void main(String[] args) {

        Calificación calificación9 = new Calificación(9);
        Calificación calificación8 = new Calificación(8);
        Calificación calificación7 = new Calificación(7);
        Calificación calificación6 = new Calificación(6);

        ArrayList<Calificación> finales = new ArrayList<>();
        finales.add(calificación6);
        finales.add(calificación7);
        finales.add(calificación8);
        finales.add(calificación9);

        for (int i = 0; i < 10000; i++) {
            Calificación uno = calculaCalificaciones(12);
            int califi = uno.calificacionFinal;
            int[] promedios = uno.calificacionesIndiv.get(0);


            switch (califi) {
                case 9:
                    calificación9.agregarPromedios(promedios);
                    break;
                case 8:
                    calificación8.agregarPromedios(promedios);
                    break;
                case 7:
                    calificación7.agregarPromedios(promedios);
                    break;
                case 6:
                    calificación6.agregarPromedios(promedios);
                    break;
            }
        }


        System.out.println(finales);
    }

    public static Calificación calculaCalificaciones(int semanas){
        int max = 10;
        int min = 6;

        int[] promedios = new int[semanas];

        int promedioTentativo = 0;

        for (int i = 0; i < promedios.length; i++) {
            int promedio = (int)(Math.random() * (max - min + 1) + min);
            promedios[i] = promedio;
            promedioTentativo+= promedio;
        }

        promedioTentativo = promedioTentativo/ semanas;
        Calificación calif = new Calificación(promedioTentativo);
        calif.agregarPromedios(promedios);

        return calif;
    }
}

class Calificación{
    int calificacionFinal;
    int semanas;
    ArrayList<int[]> calificacionesIndiv;

    public Calificación(int calificacionFinal){
        this.calificacionFinal = calificacionFinal;
        calificacionesIndiv = new ArrayList();
    }

    public void agregarPromedios(int[] promedios){
        calificacionesIndiv.add(promedios);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calificación that = (Calificación) o;
        return calificacionFinal == that.calificacionFinal;
    }

    String arreglo(){
        StringBuilder st = new StringBuilder();
        for (int[] prome: calificacionesIndiv) {
            st.append(myJoin(prome, ", ") + "\n");
        }

        return st.toString();
    }

    public static String myJoin(int[] arr, String separator) {
        if (null == arr || 0 == arr.length) return "";

        StringBuilder sb = new StringBuilder(256);
        sb.append(arr[0]);

        //if (arr.length == 1) return sb.toString();

        for (int i = 1; i < arr.length; i++) sb.append(separator).append(arr[i]);

        return sb.toString();
    }
    @Override
    public String toString() {
        return "\n\nCalificación a asignar: " + calificacionFinal + " Estos son los promedios: \n" + arreglo();
    }
}
