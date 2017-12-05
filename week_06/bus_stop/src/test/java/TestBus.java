import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBus {

    Bus bus;
    Person george;
    BusStop busStop;

    @Before
    public void before(){
        bus = new Bus("Waverley", 20);
        george = new Person();
        busStop = new BusStop("Haymarket");
        busStop.addPerson(george);
    }

    @Test
    public void hasCapacity(){
        assertEquals(20, bus.getCapacity());
    }

    @Test
    public void canAddPassenger(){
        bus.addPassenger(busStop, george);
        assertEquals(1, bus.countPassengers());
    }

    @Test
    public void busIsEmpty() {
        assertEquals(0, bus.countPassengers());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(busStop, george);
        bus.removePassenger(george);
        assertEquals(0, bus.countPassengers());
    }


}
