package Classes.task7;

public class Trapezoid extends Figure {
    double a;
    double b;
    double h;

    public Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public double area() {
        return 0.5 * (a + b) * h;
    }
}
