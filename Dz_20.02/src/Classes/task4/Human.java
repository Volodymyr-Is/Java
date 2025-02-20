package Classes.task4;

public class Human {
    String name;
    int age;

    public Human() {}

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
