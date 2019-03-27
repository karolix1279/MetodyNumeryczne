package newton;

import java.util.*;

public class Newton {

    private double result;
    private double[] arrayX = {0, 2, 3, 5, 6};
    private double[] arrayY = {0, 8, 27, 125, 216};
    private int pointsQuantity = 5;
    private Double[][] resultsTable;
    List<String> lista;

    public Newton() {

        resultsTable = new Double[pointsQuantity][pointsQuantity];
        this.lista = new ArrayList<>();
    }

    private double newton(Double[][] resultsTable, double[] arrayX, double[] arrayY, int k, int i) {

        if (resultsTable[i][k] == null) {
            if (k == 0) {
                resultsTable[i][k] = 0.0;

                return 1;
            }
            if (k == 1) {

                lista.add( k + "   " + (arrayY[i + 1] - arrayY[i]) / (arrayX[i + k] - arrayX[i]));


                resultsTable[i][k] = (arrayY[i + 1] - arrayY[i]) / (arrayX[i + k] - arrayX[i]);

                return (arrayY[i + 1] - arrayY[i]) / (arrayX[i + k] - arrayX[i]);
            }

            lista.add( k + "   " + (newton(resultsTable, arrayX, arrayY, k - 1, i + 1) - newton(resultsTable, arrayX, arrayY, k - 1, i)) / (arrayX[i + k] - arrayX[i]));

            resultsTable[i][k] = (newton(resultsTable, arrayX, arrayY, k - 1, i + 1) - newton(resultsTable, arrayX, arrayY, k - 1, i)) / (arrayX[i + k] - arrayX[i]);




            return (newton(resultsTable, arrayX, arrayY, k - 1, i + 1) - newton(resultsTable, arrayX, arrayY, k - 1, i)) / (arrayX[i + k] - arrayX[i]);

        } else return resultsTable[i][k];

    }

    public void countArray() {

        double temp = 0;


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj x: ");
//        int x = scanner.nextInt();

         int x = 3;
            for (int i = 0; i < pointsQuantity; i++) {
                temp = 0;
                for (int j = 0; j < i; j++) {
                    if (j == 0) temp = x - arrayX[0];
                    else temp *= x - arrayX[j];
                }
                result += temp * newton(resultsTable, arrayX, arrayY, i, 0);
                //System.out.print(" + ");

            }

        Collections.sort(lista);
        lista.stream()
                .forEach(e -> System.out.println("Dla rzedu: " + e ));
//            System.out.println();
           System.out.println("Wynik dla x=" + x + " to " + result);


    }

}
