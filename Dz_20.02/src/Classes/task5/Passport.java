package Classes.task5;

public class Passport {
    String name;
    String nationality;
    String passportNumber;

    public Passport() {}

    public Passport(String name, String nationality, String passportNumber) {
        this.name = name;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return this.name + " " + this.nationality + " " + this.passportNumber;
    }
}
