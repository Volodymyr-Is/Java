import Classes.task3;
import Classes.task4.Builder;
import Classes.task4.Human;
import Classes.task4.Pilot;
import Classes.task4.Sailor;
import Classes.task5.ForeignPassport;
import Classes.task5.Passport;
import Classes.task6.Engineer;
import Classes.task6.Manager;
import Classes.task6.President;
import Classes.task6.Security;
import Classes.task7.Circle;
import Classes.task7.Rectangle;
import Classes.task7.Trapezoid;
import Classes.task7.Triangle;
import Classes.task8.Array;

public class Main {
    public static void main(String[] args) {

//        task3
//        task3 t =  new task3();
//        System.out.println("Min: " + t.min(3,5,2,0));
//        System.out.println("Max: " + t.max(3,5,2,0));
//        System.out.println("Avg: " + t.avg(3,5,2,0));
//        System.out.println("Fact: " + t.fact(5));


//        task4
//        Human human = new Human(20, "Jack");
//        Builder builder = new Builder(32, "John", "workingAddress");
//        Sailor sailor = new Sailor(23, "Bob", "someShip");
//        Pilot pilot = new Pilot(23, "Alice", 5);
//
//        System.out.println(human.toString());
//        System.out.println(builder.toString());
//        System.out.println(sailor.toString());
//        System.out.println(pilot.toString());


//        task5
//        Passport passport = new Passport("John", "Ukraine", "12345");
//        ForeignPassport forignPassport = new ForeignPassport(passport, "someInfo", "54321");
//
//        System.out.println("Passport: " + passport);
//        System.out.println("ForeignPassport: " + forignPassport);


//        task6
//        President president = new President();
//        Security security = new Security();
//        Manager manager = new Manager();
//        Engineer engineer = new Engineer();
//
//        president.Print();
//        security.Print();
//        engineer.Print();
//        manager.Print();


//        task7
//        Rectangle rectangle = new Rectangle(5, 5);
//        System.out.println("Rectangle area: " + rectangle.area());
//
//        Circle circle = new Circle(5);
//        System.out.println("Circle area: " + circle.area());
//
//        Triangle triangle = new Triangle(5, 5);
//        System.out.println("Triangle area: " + triangle.area());
//
//        Trapezoid trapezoid = new Trapezoid(5, 5, 5);
//        System.out.println("Trapezoid area: " + trapezoid.area());


//        task8
        int []arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        Array array = new Array(arr);

        array.Print();
        System.out.println();

        array.Print("Hello, World!");
    }
}