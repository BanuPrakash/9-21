package demo;

public record Failure<V>(Integer ex) implements AsyncReturn<V> {
}
