package demo;

public class SealedExample {
    public static void main(String[] args) {
        TrafficLight light = new RedLight();
        // no need for default
        String result = switch (light) {
            case RedLight r -> r.getData();
            case GreenLight g -> g.getData();
            case YellowLight y -> y.getData();
        };

        System.out.println(result);
    }
}
