
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Task2 {
    public static void main(String[] args) throws IOException {
        // creating components and devices
        HashMap<Integer, Device> devices = new HashMap<Integer, Device>();
        for (int i = 1; i <= 10; i++) {
            ArrayList<Component> components = new ArrayList<Component>();
            components.add(new Component(1, "Display"));
            components.add(new Component(2, "battery"));
            components.add(new Component(3, "memory"));
            components.add(new Component(4, "modem"));
            components.add(new Component(5, "camera"));
            components.add(new Component(6, "cpu"));
            devices.put(i, new Device(i, "Android_" + i, components));
        }
        // reading events
        BufferedReader input = new BufferedReader(new FileReader(new File("events.txt")));
        String[] s = input.readLine().split(" ");
        ArrayList<Event> events = new ArrayList<Event>();
        while (s.length == 3) {
            int deviceId = Integer.parseInt(s[1]);
            int componentId = Integer.parseInt(s[2]);
            if (s[0].equals("ErrorEvent")) {
                events.add(new ErrorEvent(deviceId, componentId));
            } else if (s[0].equals("RestoreEvent")) {
                events.add(new RestoreEvent(deviceId, componentId));
            }
            s = input.readLine().split(" ");
        }
        input.close();
        // changing status, writing log
        Logger log = LoggerFactory.getLogger(Task2.class);
        for (int i = 0; i < events.size(); i++) {
            int deviceId = events.get(i).getDeviceId();
            int componentId = events.get(i).getComponentId();
            Device currentDevice = devices.get(deviceId);
            Component currentComponent = currentDevice.getComponents().get(componentId - 1);
            if (events.get(i) instanceof ErrorEvent && currentComponent.getStatus()) {
                currentComponent.setStatus(false);
                currentDevice.setBrokenComponents(currentDevice.getBrokenComponents() + 1);
                if (currentDevice.getBrokenComponents() > currentDevice.getComponents().size() / 2 && currentDevice.getStatus() != Status.Error) {
                    currentDevice.setStatus(Status.Error);
                    log.info("Устройство id={}, name={} изменило свое состояние на {}", deviceId, currentDevice.getName(), Status.Error);
                } else if (currentDevice.getStatus() == Status.Normal) {
                    currentDevice.setStatus(Status.Warning);
                    log.info("Устройство id={}, name={} изменило свое состояние на {}", deviceId, currentDevice.getName(), Status.Warning);
                }
            } else if (events.get(i) instanceof RestoreEvent && !currentComponent.getStatus()) {
                currentComponent.setStatus(true);
                currentDevice.setBrokenComponents(currentDevice.getBrokenComponents() - 1);
                if (currentDevice.getBrokenComponents() == 0) {
                    currentDevice.setStatus(Status.Normal);
                    log.info("Устройство id={}, name={} изменило свое состояние на {}", deviceId, currentDevice.getName(), Status.Normal);
                } else if (currentDevice.getStatus() == Status.Error) {
                    currentDevice.setStatus(Status.Warning);
                    log.info("Устройство id={}, name={} изменило свое состояние на {}", deviceId, currentDevice.getName(), Status.Warning);
                }
            }
        }
    }
}
