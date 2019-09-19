import java.util.ArrayList;

public class Device {
    private int id;
    private String name;
    private ArrayList<Component> components;
    private Status status;
    private int brokenComponents = 0;

    public Device(int id, String name, ArrayList<Component> components) {
        this.id = id;
        this.name = name;
        this.components = components;
        status = Status.Normal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public int getBrokenComponents() {
        return brokenComponents;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBrokenComponents(int brokenComponents) {
        this.brokenComponents = brokenComponents;
    }
}
