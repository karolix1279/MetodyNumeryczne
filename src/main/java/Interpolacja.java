import java.util.Scanner;

public class Interpolacja {

    private double [] xValue;
    private double [] yValue;
    private int liczbaPunktow;
    private double wartoscWielomianu;

    public Interpolacja(int liczbaPunktow, int wartosc ) {
        this.liczbaPunktow = liczbaPunktow;
        this.wartoscWielomianu = wartosc;
        this.xValue = new double[liczbaPunktow];
        this.yValue = new double[liczbaPunktow];
    }

    public void fullArray() {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < liczbaPunktow; i ++){

            System.out.println("Podaj x ");
            xValue[i] = input.nextDouble();

            System.out.println("Podaj y");
            yValue[i] = input.nextDouble();
        }
    }

    public void setxValue(double[] xValue) {
        this.xValue = xValue;
    }

    public void setyValue(double[] yValue) {
        this.yValue = yValue;
    }

    public double interpolacjaWPunkcie() {


        double wynik = 0;

        for(int i = 0 ; i < liczbaPunktow; i++ ){
            double sumaLicznik = 0;
            double sumaMianownik = 0;
            double wynikMianownik = 1;
            double wynikLicznik = 1;
            for(int j = 0; j < liczbaPunktow; j++){

                if ( i != j ) {
                    wynikLicznik *= (wartoscWielomianu - xValue[j]);
                    wynikMianownik *= (xValue[i] - xValue[j]);
                }
            }

            sumaMianownik += wynikMianownik;
            sumaLicznik += wynikLicznik * yValue[i];



            wynik += sumaLicznik/sumaMianownik;
        }


        return wynik;
    }



}
