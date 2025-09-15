package demo;

interface Future<V> {
    AsyncReturn<V> get();
}

public class PromiseExample {
    public static void main(String[] args) {
        Future<Integer> future = new Future<Integer>() {
            @Override
            public AsyncReturn<Integer> get() {
                return new Success<Integer>(100);
                // return new Failure<Throwable>(new IllegalArgumentException(...));
            }
        };

        AsyncReturn<Integer> result = future.get();
        switch (result) {
            case Success(var res) -> System.out.println(result);
            case Failure(var ex) -> System.out.println(ex);
        }
    }
}
