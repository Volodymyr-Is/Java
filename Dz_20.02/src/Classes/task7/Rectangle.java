package Classes.task7;

public class Rectangle extends Figure {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }
}
