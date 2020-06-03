package ca.meshcode.school.java.foundation.distances;

public class Point {

    private double zmiennaX;
    private double zmiennaY;

    public Point (double x, double y) {
        this.zmiennaX = x;
        this.zmiennaY = y;
    }

    public double getX() { return zmiennaX; }
    public double getY() { return zmiennaY; }

    public void setX(double zmienna) { zmiennaX = zmienna; }
    public void setY(double zmienna) { zmiennaY = zmienna; }
}
