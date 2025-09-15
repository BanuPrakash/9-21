package demo;


public record Person(String name, int age) {
    public Person {
        if(age < 0) {
            throw  new IllegalArgumentException("Age Cannot be negative!!!");
        }
    }
}