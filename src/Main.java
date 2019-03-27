import java.io.*;

public class Main {

    private static final int STOPIENWIELOMIANU = 2;

    public static double WielomianLegendre(double x, double k) {

        if (k == 0)

            return 1;

        else if (k == 1)

            return x;

        else

            return ((2 * k - 1) / k) * x * WielomianLegendre(x, k - 1) - ((k - 1) / k) * x * WielomianLegendre(x, k - 2);

    }


    public static double iloczynSkalarny(double[] tabx, double[] taby, int n) {

        double suma = 0;

        for (int i = 0; i < n; i++) {
            suma += tabx[i] * taby[i];
        }

        return suma;
    }


    public static double liczymyAlfa(double[] f, double[] fi, int n) {

        double result = iloczynSkalarny(f, fi, n) / iloczynSkalarny(fi, fi, n);

        return result;

    }


    public static double LiczH(double[] tabx, double[] taby, double x, int n) {

        double wynik = 0;

        for (int i = 0; i <= STOPIENWIELOMIANU ; i++) {

            double[] tablicaZLagranda = new double[n];

            for (int j = 0; j <= STOPIENWIELOMIANU; j++) {
                tablicaZLagranda[j] = WielomianLegendre(tabx[j], 2);
            }

            wynik += liczymyAlfa(taby, tablicaZLagranda, n) * WielomianLegendre(x, 2);
        }


        return wynik;
    }


    public static void main(String[] args) {

        double[] x = {-1, -0.9, -0.7, -0.5, -0.3, -0.1, 0, 0.1, 0.3, 0.5, 0.7, 0.9, 1};
        double[] y = {1.809247, 1.3258615, 0.6585576, 0.1355277, -0.017093, -0.04407, 0.0319066, 0.5315639, 0.9444663, 1.4567172, 2.0350662, 2.2806261};

        double[] tabX = {-1, -0.8, -0.6, -0.4, -0.2, 0, 0.2, 0.4, 0.6, 0.8, 1};

        for (int i = 0; i < tabX.length; i++) {

            System.out.println(tabX[i] + "  " + LiczH(x, y, tabX[i], tabX.length));
        }

        try(FileWriter fileWriter = new FileWriter("wynik.txt")){
            for (int i = 0; i < tabX.length; i++) {

                fileWriter.write(tabX[i] + " " + LiczH(x, y, tabX[i], tabX.length) + "\n");
            }

        } catch (IOException e) {
            e.getMessage();
        }


        try(FileWriter fileWriter = new FileWriter("dane.txt")){
            for (int i = 0; i < tabX.length ; i++) {

                fileWriter.write(x[i] + " " + y[i] + "\n");

            }

        } catch (IOException e) {
            e.getMessage();
        }


    }
}

