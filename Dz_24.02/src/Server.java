import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Server {
    private PriorityQueue<Request> requests = new PriorityQueue<>();
    private Queue<String> log = new LinkedList<>();

    public void addRequest(String client, int priority) {
        Request request = new Request(client, priority);
        requests.add(request);
        log.add("Client: " + client + " sent request at " + new Date(request.getTimeStamp()));
    }

    public void processRequests() {
        while (!requests.isEmpty()) {
            Request request = requests.poll();
            System.out.println("Processing " + request);
        }
    }

    public void printLog() {
        System.out.println("\nRequest Log:");
        for (String log : log) {
            System.out.println(log);
        }
    }
}

class Request implements Comparable<Request> {
    private String client;
    private int priority;
    private long timeStamp;

    public Request(String client, int priority) {
        this.client = client;
        this.priority = priority;
        this.timeStamp =  System.currentTimeMillis();
    }

    public String getClient() {
        return client;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public int compareTo(Request otherRequest) {
        return Integer.compare(otherRequest.priority, this.priority);
    }

    @Override
    public String toString() {
        return "Client: " + client + ", Priority: " + priority + ", Time: " + new Date(timeStamp);
    }
}