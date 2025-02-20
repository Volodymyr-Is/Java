package Classes.task7;

public class Triangle extends Figure {
    double a;
    double b;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b * 0.5;
    }
}
