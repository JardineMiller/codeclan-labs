import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBusStop {
    Person gwendaline;
    BusStop busStop;

    @Before
    public void before() {
        gwendaline = new Person();
        busStop = new BusStop("Haymarket");
    }

    @Test
    public void canAddPerson() {
        busStop.addPerson(gwendaline);
        assertEquals(1, busStop.countQueue());
    }

    @Test
    public void canRemovePerson() {
        busStop.addPerson(gwendaline);
        Person removed = busStop.removePerson(gwendaline);
        assertEquals(0, busStop.countQueue());
        assertEquals(removed, gwendaline);
    }


}
