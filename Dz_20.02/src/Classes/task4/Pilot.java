package Classes.task4;

public class Pilot  extends Human{
    int flightCounter;

    public Pilot(int age, String name, int flightCounter) {
        super(age, name);
        this.flightCounter = flightCounter;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + flightCounter;
    }
}
