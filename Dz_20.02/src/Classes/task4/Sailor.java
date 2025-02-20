package Classes.task4;

public class Sailor extends Human {
    String shipName;

    public Sailor(int age, String name, String shipName) {
        super(age, name);
        this.shipName = shipName;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + shipName;
    }
}
