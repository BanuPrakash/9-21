package demo;

class Department {
    public String name;
}
class Employee {
    public String name;
    public int age;
    public Department department;

    public Department getDepartment() {
        return department;
    }
}
public class EnhancedNullPointerException {
    public static void main(String[] args) {
        String name = new Employee().getDepartment().name;
        System.out.println(name);
    }
}
