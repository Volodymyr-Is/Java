import java.util.concurrent.Semaphore;

class DiningTable
{
    private Semaphore semaphore;

    public DiningTable(int seats) {
        semaphore=new Semaphore(seats);
    }
    public void dine(String philosopherName)
    {

        try {
            System.out.println(philosopherName + " намагається сісти за стіл");
            semaphore.acquire();
            System.out.println(philosopherName + " обідає");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(philosopherName + " закінчив обід і пішов");
            semaphore.release();
        }
    }
}
class Philosopher implements  Runnable
{
    DiningTable table;
    private String philosopherName;

    public Philosopher(DiningTable table, String philosopherName) {
        this.table = table;
        this.philosopherName = philosopherName;
    }

    @Override
    public void run() {
        table.dine(philosopherName);
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int parkingSlots = 3;
        DiningTable table = new DiningTable(parkingSlots);

        Philosopher philosopher1 = new Philosopher(table,"Philosopher1");
        Philosopher philosopher2 = new Philosopher(table,"Philosopher2");
        Philosopher philosopher3 = new Philosopher(table,"Philosopher3");
        Philosopher philosopher4 = new Philosopher(table,"Philosopher4");
        Philosopher philosopher5 = new Philosopher(table,"Philosopher5");
        Philosopher philosopher6 = new Philosopher(table,"Philosopher6");

        Thread thread1=new Thread(philosopher1);
        Thread thread2=new Thread(philosopher2);
        Thread thread3=new Thread(philosopher3);
        Thread thread4=new Thread(philosopher4);
        Thread thread5=new Thread(philosopher5);
        Thread thread6=new Thread(philosopher6);

        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);
        thread4.setDaemon(true);
        thread5.setDaemon(true);
        thread6.setDaemon(true);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
    }
}