package device_management;

import behaviours.IInput;
import behaviours.IOutput;

import java.util.ArrayList;

public class Computer {
    private int ram;
    private int hddSize;
    private ArrayList<IOutput> outputDevices;
    private ArrayList<IInput> inputDevices;

    public Computer(int ram, int hddSize) {
        this.ram = ram;
        this.hddSize = hddSize;
        this.outputDevices = new ArrayList<>();
        this.inputDevices = new ArrayList<>();
    }

    public int getRam() {
        return this.ram;
    }

    public int getHddSize() {
        return this.hddSize;
    }

    public ArrayList<IOutput> getOutputDevices() {
        return this.outputDevices;
    }

    public ArrayList<IInput> getInputDevices() {
        return this.inputDevices;
    }

    public String outputData(String data, IOutput device) {
        int index = outputDevices.indexOf(device);
        return this.outputDevices.get(index).outputData(data);
    }

    public String inputData(String data, IInput device) {
        int index = inputDevices.indexOf(device);
        return this.inputDevices.get(index).sendData(data);
    }

    // CREATE METHODS FOR GETTING INPUT & OUTPUT DEVICE(S) - instanceof or input Class <variable name> as an argument of the find method.

    public void addInputDevice(IInput inputDevice) {
        this.inputDevices.add(inputDevice);
    }

    public void addOutputDevice(IOutput outputDevice) {
        this.outputDevices.add(outputDevice);
    }


}
