package device_management;

import behaviours.IInput;

public class Mouse implements IInput {
    private String type;
    private int dpi;

    public Mouse(String type, int dpi) {
        this.type = type;
        this.dpi = dpi;
    }

    public String getType() {
        return type;
    }
    public int getDpi() {
        return dpi;
    }

    public String sendData(String inputData) {
        return "Sending: " + inputData;
    }

    public String move(String direction) {
        return "Moving " + direction;
    }

    public String click() {
        return "Squeak";
    }
}
