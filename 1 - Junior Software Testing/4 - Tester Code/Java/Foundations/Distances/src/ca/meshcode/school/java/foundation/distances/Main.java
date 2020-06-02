package ca.meshcode.school.java.foundation.distances;


// Me  Masz punkt x = 0 y = 0,
// Old Zabka starą żabkę w punkcie x = 1.2, y = 2.5
// New Zabka zlikwidowano i przeniesiono na punkt x = 5.5, y = -2.3.
// Biedronka Czy bliżej będzie do nowej Żabki czy do Biedronki (x = 3.3, y=2.7)? Policz różnicę odległości między starą żabką a nowym najbliższym sklepem -
// czy wypada na korzyść czy niekorzyść spacerującego? Jaka to różnica?
//


import java.awt.*;
import java.lang.Math;

public class Main {
    
    public static void main(String[] args) {
        //These points are converted to doubles in the Point class, otherwise without the point class they would be integers
        Point domek = new Point(0, 0);
        Point zabka = new Point(1.2, 2.5);
        Point biedronka = new Point(3.3, 2.7);
        Point zabka2 = new Point(5.5, -2.3);
        //
        String closerSpot = "spot";

        //Distance to new Zabka
        double odl_zabka2 = odleglosc(zabka2.getX(), domek.getX(), zabka2.getY(), domek.getY());
        System.out.println("Odleglosc do nowej zabki wynosi " + odl_zabka2 + " km.");
        //Distance to Biedronka
        double odl_biedronka = odleglosc(biedronka.getX(), domek.getX(), biedronka.getY(), domek.getY());
        System.out.println("Odleglosc do biedronki wynosi " + odl_biedronka + " km.");

        //Compare for shorter distance
        if (odl_zabka2 > odl_biedronka) {
            closerSpot = "biedronka";
        } else {
            closerSpot = "nowa zabka";
        }
        //shorter distance is
        double shorterDistance = Math.min(odl_zabka2, odl_biedronka);
        //
        //Return shortest distance
        System.out.println("Going " + shorterDistance + " to " + closerSpot + " is the shorter distance.");

        //Distance to old Zabka
        double odl_zabka = odleglosc(zabka.getX(), domek.getX(), zabka.getY(), domek.getY());

        //Compare for shorter distance between current best and old zabka
        if (shorterDistance > odl_zabka) {
            System.out.println("Stara Zabka was closer than " + closerSpot + " originally by " + (shorterDistance - odl_zabka) + " km.");

        } else {
            System.out.println(closerSpot + " wins as the most convenient location.");
        }


    }


    //
    //
    public static double odleglosc (double x1, double x2, double y1, double y2){
        double potega = 2;
        return Math.sqrt(Math.pow(x1 - x2, potega) + Math.pow(y1 - y2, potega));
    }
}
