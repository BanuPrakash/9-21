package demo;

// single file "permits" is optional
//public sealed interface TrafficLight permits RedLight, GreenLight, YellowLight {
public sealed interface TrafficLight {
    String getData();
}

final class RedLight implements  TrafficLight {
    @Override
    public String getData() {
        return "STOP";
    }
}


final class GreenLight implements  TrafficLight {
    @Override
    public String getData() {
        return "GO";
    }
}


final class YellowLight implements  TrafficLight {
    @Override
    public String getData() {
        return "READY";
    }
}

