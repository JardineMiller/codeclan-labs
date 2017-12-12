package device_management;

import behaviours.IInput;

public class Keyboard implements IInput {
    private String make;
    private String type;

    public Keyboard(String make, String type) {
        this.make = make;
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public String getType() {
        return type;
    }

    public String sendData(String inputData) {
        return "Sending: " + inputData;
    }

    public String type(String input) {
        return "You typed: " + input;
    }
}
