import behaviours.IInput;
import behaviours.IOutput;
import device_management.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComputerTest {
    Computer computer;
    Monitor monitor;
    Mouse mouse;
    Keyboard keyboard;
    Printer printer;
    Speaker speaker;

    @Before
    public void before() {
        monitor = new Monitor(22, 786432);
        mouse = new Mouse("Wireless", 960);
        keyboard = new Keyboard("Logitech", "Wired");
        computer = new Computer(8, 512);
        computer.addInputDevice(mouse);
        computer.addInputDevice(keyboard);
        computer.addOutputDevice(monitor);
        printer = new Printer("Epson", "Stylus", 120, 4);
        speaker = new Speaker(10);
        computer.addOutputDevice(printer);
        computer.addOutputDevice(speaker);
    }

    @Test
    public void hasRam() {
        assertEquals(8, computer.getRam());
    }

    @Test
    public void hasHddSize() {
        assertEquals(512, computer.getHddSize());
    }

//    @Test
//    public void hasMonitor() {
//        assertEquals(22, computer.getMonitor().getScreenSize());
//        assertEquals(786432, computer.getMonitor().getPixels());
//    }

    @Test
    public void hasOutputDevice() {
        assertNotNull(computer.getOutputDevices());
    }

    @Test
    public void canOutputData() {
        assertEquals("space invaders is now on screen", computer.outputData("space invaders", monitor));
    }

    @Test
    public void canOutputDataViaPrinter() {
        assertEquals("printing: space invaders", computer.outputData("space invaders", printer));
    }

    @Test
    public void canOutputViaSpeaker() {
        assertEquals("playing: tetris theme tune", computer.outputData("tetris theme tune", speaker));
    }

    @Test
    public void canAddOutputDevice() {
        Monitor newMoniter = new Monitor(32, 1000000);
        computer.addOutputDevice(newMoniter);
        assertEquals(4, computer.getOutputDevices().size());
    }

    @Test
    public void canInputViaMouse() {
        assertEquals("Sending: click", computer.inputData("click", mouse));
    }

    @Test
    public void canInputViaKeyboard() {
        assertEquals("Sending: typed string", computer.inputData("typed string", keyboard));
    }

    @Test
    public void hasInputDevice() {
        assertNotNull(computer.getInputDevices());
    }

    @Test
    public void canCastMouse() {
        assertEquals("Squeak", ((Mouse) computer.getInputDevices().get(0)).click());
    }

}
