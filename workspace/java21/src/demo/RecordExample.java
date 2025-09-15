package demo;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecordExample {
    public static void main(String[] args) {
        Person person = new Person("George", 24);
        System.out.println(person.name() + ", " + person.age());

        List<String> data = Arrays.asList("Harry", "George", "Angelina", "Brad", "Clooney");
        System.out.println(getLongest(data));
    }

    private static String getLongest(List<String> names) {
        record Pair(String name, int length) {}
        return names.stream()
                .map(name -> new Pair(name, name.length()))
                .collect(Collectors.toList())
                .stream().max(Comparator.comparingInt(pair -> pair.length))
                .map(pair -> pair.name)
                .orElseThrow();
    }
}
