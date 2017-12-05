import java.util.ArrayList;

public class Bus {
    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String inputDestination, int inputCapacity) {
        this.destination = inputDestination;
        this.capacity = inputCapacity;
        this.passengers = new ArrayList<>();
    }

    public int countPassengers() {
        return this.passengers.size();
    }

    public void addPassenger(BusStop busStop, Person person) {
        if (this.countPassengers() < this.capacity) {
            this.passengers.add(busStop.removePerson(person));
        }
    }

    public void removePassenger(Person person) {
        this.passengers.remove(person);
    }

    public int getCapacity() {
        return this.capacity;
    }
}
