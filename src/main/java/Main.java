import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Podaj ilosc punktow");
        int iloscPunktow = input.nextInt();

        System.out.println("Podaj wartosc w wielomianu" );
        int wartosc = input.nextInt();
        Interpolacja proba = new Interpolacja(iloscPunktow, wartosc);

        proba.fullArray();
        System.out.println("Wynik to " + proba.interpolacjaWPunkcie());
    }
}
