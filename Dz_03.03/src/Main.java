import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Олег", 40, "Львів"),
                new Person("Анна", 30, "Київ"),
                new Person("Іван", 28, "Лондон"),
                new Person("Марія", 22, "Львів"),
                new Person("Олег", 37, "Київ"),
                new Person("Петро", 26, "Одеса"),
                new Person("Оксана", 24, "Лондон"),
                new Person("Андрій", 50, "Львів")
        );

//        task1
//        List<Person> olderThan25 = people.stream().filter(x -> x.age > 25).collect(Collectors.toList());
//        System.out.println("Older than 25: ");
//        olderThan25.forEach(System.out::println);


//        task2
//        List<Person> notInKyiv = people.stream().filter(x -> !x.city.equals("Київ")).collect(Collectors.toList());
//        System.out.println("Not in Kyiv: ");
//        notInKyiv.forEach(System.out::println);


//        task3
//        List<String> inKyiv = people.stream().filter(x -> x.city.equals("Київ")).map(p -> p.name).collect(Collectors.toList());
//        System.out.println("In Kyiv: ");
//        inKyiv.forEach(System.out::println);


//        task4
//        List<Person> olegsOlderThan35 = people.stream().filter(x -> x.age > 35 && x.name.equals("Олег")).collect(Collectors.toList());
//        System.out.println("Olegs older than 35: ");
//        olegsOlderThan35.forEach(System.out::println);


//        task5
//        List<Person> inLondon = people.stream().filter(x -> x.city.equals("Лондон")).collect(Collectors.toList());
//        System.out.println("In London: ");
//        inLondon.forEach(System.out::println);


//        task6
//        List<Person> sortedPeopleByAge = people.stream().sorted(Comparator.comparingInt(p -> p.age)).collect(Collectors.toList());
//        System.out.println("Sorted people by age: ");
//        sortedPeopleByAge.forEach(System.out::println);


//        task7
//        List<Person> sortedPeopleByName = people.stream().sorted(Comparator.comparing((Person p) -> p.name).reversed()).collect(Collectors.toList());
//        System.out.println("Sorted people by name (descending order): ");
//        sortedPeopleByName.forEach(System.out::println);


//        task8
//        Map<String, List<Person>> groupedPeopleByCity = people.stream().collect(Collectors.groupingBy(p -> p.city));
//        System.out.println("Grouped people by city: ");
//        for (Map.Entry<String, List<Person>> entry : groupedPeopleByCity.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }


//        task9
//        Map<String, Optional<Person>> maxAgeInEachCity = people.stream().collect(Collectors.groupingBy(p -> p.city, Collectors.maxBy(Comparator.comparingInt(p -> p.age))));
//        System.out.println("Max age in each city: ");
//        for (Map.Entry<String, Optional<Person>> entry : maxAgeInEachCity.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }


//        task10
//        Map<String, Double> avgAgeInEachCity = people.stream().collect(Collectors.groupingBy(p -> p.city, Collectors.averagingInt(p -> p.age)));
//        System.out.println("Max age in each city: ");
//        for (Map.Entry<String, Double> entry : avgAgeInEachCity.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }


//        task11
//        double avgAge = people.stream().collect(Collectors.averagingInt(p -> p.age));
//        System.out.println("Avg age: " + avgAge);


//        task12
        List<Person> oldestInLviv = people.stream().filter(p -> p.city.equals("Львів")).sorted(Comparator.comparingInt(p -> -p.age)).limit(3).collect(Collectors.toList());
        System.out.println("Top 3 oldest people in Lviv: ");
        oldestInLviv.forEach(System.out::println);
    }
}

class Person {
    String name;
    int age;
    String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}