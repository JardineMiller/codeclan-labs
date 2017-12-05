import java.util.ArrayList;

public class BusStop {
    private String location;
    private ArrayList<Person> queue;

    public BusStop (String location) {
        this.location = location;
        this.queue = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.queue.add(person);
    }

    public int countQueue() {
        return this.queue.size();
    }

    public Person removePerson(Person person) {
        int index = queue.indexOf(person);
        return this.queue.remove(index);
    }
}
