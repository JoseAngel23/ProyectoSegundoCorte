package observers;

public class Observers {
    private String name;

    public Observers(String name) {
        this.name = name;
    }

    public void receiveMessage(String message) {
        System.out.println(name + ": " + message);
    }
}
