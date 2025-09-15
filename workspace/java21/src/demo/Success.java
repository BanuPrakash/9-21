package demo;

public record Success<V>(V result) implements AsyncReturn<V> {
}
