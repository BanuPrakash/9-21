package client;

import com.cisco.api.LogService;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<LogService> services = ServiceLoader.load(LogService.class);
        for(LogService service : services) {
            service.info("Good Day!!!");
        }
    }
}
