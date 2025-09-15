package demo;

public class PatternMatching {
    public static void main(String[] args) {
        Object obj = new String("Hello World");
        // java 13 with instanceof
        if(obj instanceof String str) {
            System.out.println(str.toUpperCase());
        }

        // prior to java 13
        if(obj instanceof String) {
            String str = (String) obj; //reduce boilerplate code
            System.out.println(str.toUpperCase());
        }
        printType(obj);
        System.out.println(getInfo("YELLOW"));
    }

    public static void printType(Object obj) {
        // java 17
        switch (obj) {
            case  Integer i -> System.out.println("Integer :" + i.intValue());
            case String str -> System.out.println("String " + str.toUpperCase());
            default -> System.out.println("Unknown type");
        }
    }

    public static String getInfo(String data) {
        // Java 17, switch returning
        return  switch (data) {
            case "RED" -> "STOP";
            case "YELLOW" -> "READY";
            case "GREEN" -> "GO";
            default ->  "INVALID";
        };
    }

    public static String getInformation(String data) {
        // Java 17, switch returning
        // yield keyword for multiple statements
        return  switch (data) {
            case "RED" : {
                System.out.println("Switch off the Engine!!!");
                yield "STOP";
            }
            case "YELLOW" : yield "READY";
            case "GREEN" : yield  "GO";
            default : yield   "INVALID";
        };
    }
}
