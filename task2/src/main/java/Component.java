public class Component {
    private int id;
    private String name;
    private Boolean status;

    public Component(int id, String name) {
        this.id = id;
        this.name = name;
        status = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
