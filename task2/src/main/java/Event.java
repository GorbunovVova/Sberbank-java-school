public abstract class Event {
    private int deviceId;
    private int componentId;

    public Event(int deviceId, int componentId) {
        this.deviceId = deviceId;
        this.componentId = componentId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public int getComponentId() {
        return componentId;
    }
}
