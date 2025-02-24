import java.util.*;

public class Main {
    public static void main(String[] args) {

//        task1
//        Scanner sc = new Scanner(System.in);
//        ArrayList<String> arr = new ArrayList<>();
//        String choice;
//        boolean exit = false;
//
//        while(exit == false){
//            System.out.println("1. Додати елемент в список");
//            System.out.println("2. Видалити елемент з списку");
//            System.out.println("3. Показати вміст списку");
//            System.out.println("4. Перевірити чи є значення в списку");
//            System.out.println("5. Замінити значення в списку");
//            System.out.println("6. Вийти");
//
//            System.out.print("\nВведіть опцію: ");
//            choice = sc.nextLine();
//
//            switch(choice){
//                case "1":
//                    System.out.print("Введіть елемент, який бажаєте додати: ");
//                    String addEl = sc.nextLine();
//                    arr.add(addEl);
//                    System.out.println();
//                    break;
//                case "2":
//                    System.out.print("Введіть елемент, який бажаєте видалити: ");
//                    String delEl = sc.nextLine();
//                    arr.remove(delEl);
//                    System.out.println();
//                    break;
//                case "3":
//                    System.out.print("Ваш масив: ");
//                    for (String i : arr)
//                        System.out.print(i + " ");
//                    System.out.println("\n");
//                    break;
//                case "4":
//                    System.out.print("Введіть елемент, який бажаєте перевірити: ");
//                    String checkEl = sc.nextLine();
//                    if(arr.contains(checkEl))
//                        System.out.println("Елемент знайдено!");
//                    else
//                        System.out.println("Елемент не знайдено...");
//                    System.out.println();
//                    break;
//                case "5":
//                    System.out.print("Введіть елемент, який бажаєте змінити: ");
//                    String changeEl = sc.nextLine();
//                    System.out.print("Введіть новий елемент: ");
//                    String newEl = sc.nextLine();
//
//                    if(arr.contains(changeEl)) {
//                        arr.add(arr.indexOf(changeEl), newEl);
//                        arr.remove(changeEl);
//                    }
//
//                    System.out.println();
//                    break;
//                case "6":
//                    exit = true;
//                    System.out.println();
//                    break;
//                default:
//                    System.out.print("Введіть існуючу опцію: ");
//                    break;
//            }
//        }


//        task2
//        Scanner sc = new Scanner(System.in);
//        HashMap<String, String> users = new HashMap<String, String>();
//        String choice;
//        boolean exit = false;
//
//        while(exit == false){
//            System.out.println("1. Додати нового користувача");
//            System.out.println("2. Видалення існуючого користувача");
//            System.out.println("3. Перевірити чи існує користувач");
//            System.out.println("4. Змінити логін існуючого користувача");
//            System.out.println("5. Змінити пароль існуючого користувача");
//            System.out.println("6. Вийти");
//
//            System.out.print("\nВведіть опцію: ");
//            choice = sc.nextLine();
//
//            switch(choice){
//                case "1":
//                    System.out.print("Введіть логін користувача: ");
//                    String addLogin = sc.nextLine();
//                    System.out.print("Введіть пароль користувача: ");
//                    String addPassword = sc.nextLine();
//                    users.put(addLogin, addPassword);
//                    System.out.println();
//                    break;
//
//                case "2":
//                    System.out.print("Введіть логін, який бажаєте видалити: ");
//                    String delLogin = sc.nextLine();
//                    users.remove(delLogin);
//                    System.out.println();
//                    break;
//
//                case "3":
//                    System.out.print("Введіть логін користувача, який бажаєте перевірити: ");
//                    String checkLogin = sc.nextLine();
//                    if(users.containsKey(checkLogin)){
//                        System.out.println("Користувача знайдено!");
//                        System.out.println(checkLogin + " " + users.get(checkLogin));}
//                    else
//                        System.out.println("Користувача не знайдено...");
//                    System.out.println();
//                    break;
//
//                case "4":
//                    System.out.print("Введіть логін користувача, який бажаєте змінити: ");
//                    String changeLogin = sc.nextLine();
//                    System.out.print("Введіть новий логін: ");
//                    String newLogin = sc.nextLine();
//
//                    if(users.containsKey(changeLogin)) {
//                        String password = users.get(changeLogin);
//                        users.remove(changeLogin);
//                        users.put(newLogin, password);
//                    }
//                    else {
//                        System.out.println("Користувача з таким логіном не знайдено...");
//                    }
//
//                    System.out.println();
//                    break;
//
//                case "5":
//                    System.out.print("Введіть логін користувача, пароль якого бажаєте змінити: ");
//                    String changePassword = sc.nextLine();
//                    System.out.print("Введіть новий пароль: ");
//                    String newPassword = sc.nextLine();
//
//                    if(users.containsKey(changePassword)) {
//                        users.replace(changePassword, users.get(changePassword), newPassword);
//                    }
//                    else {
//                        System.out.println("Користувача з таким логіном не знайдено...");
//                    }
//                    System.out.println();
//                    break;
//
//                case "6":
//                    exit = true;
//                    System.out.println();
//                    break;
//
//                default:
//                    System.out.print("Введіть існуючу опцію: ");
//                    break;
//            }
//        }


//        task3
        Server server = new Server();
        server.addRequest("Alice", 2);
        server.addRequest("Bob", 1);
        server.addRequest("Charlie", 3);
        System.out.println("Processing requests in order of priority: ");
        server.processRequests();

        server.printLog();
    }
}