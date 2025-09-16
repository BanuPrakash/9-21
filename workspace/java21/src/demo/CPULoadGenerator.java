package demo;

import jdk.jfr.consumer.RecordingStream;

public class CPULoadGenerator {
    public static void main(String[] args) {
        System.out.println("Starting CPU load generation...");
        // open a RecordingStream to consume events -- Since Java 14
        try(RecordingStream rs = new RecordingStream()) {
            // jdk.GarbageCollection
            // jdk.Heap
            rs.enable("jdk.CPULoad").with("period", "1 s");

            rs.onEvent("jdk.CPULoad", event -> {
                System.out.println("... CPU Load Event ---");
                System.out.println("TimeStamp " + event.getStartTime());
                System.out.println("Machine total CPU Load: " + String.format("%.2f%%", event.getFloat("machineTotal") * 100));
                System.out.println("JVM User CPU Load: " + String.format("%.2f%%", event.getFloat("jvmUser")* 100));
                System.out.println("JVM System total CPU Load: " + String.format("%.2f%%", event.getFloat("jvmSystem") * 100));
            });
            rs.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Thread threads = new Thread(() -> {
            while (true){
                calcFibonacci(40);
            }
        });

        threads.setDaemon(true);
        threads.start();

        try {
            Thread.sleep(60000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public static long calcFibonacci(int no) {
        if(no <=1) {
            return no;
        }
        return calcFibonacci(no - 1) + calcFibonacci(no - 2);
    }
}
