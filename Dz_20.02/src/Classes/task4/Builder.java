package Classes.task4;

public class Builder extends Human {
    String address;

    public Builder(int age, String name, String address) {
        super(age, name);
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + address;
    }
}
