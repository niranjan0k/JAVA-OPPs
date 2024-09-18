package Lembda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *  Employee
 */
class Employee {

    private String name;
    private int age;
    private long salary;
    private boolean hasCar;
    
    public Employee(String name, int age, long salary, boolean hasCar){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.hasCar = hasCar;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return this.salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public boolean isHasCar() {
        return this.hasCar;
    }

    public boolean getHasCar() {
        return this.hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

}


public class Test {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Niranjan", 30, 250000, false));
        list.add(new Employee("Gautam", 32, 230000, true));
        list.add(new Employee("Mukesh", 35, 320000, true));
        list.add(new Employee("Samsul", 33, 230000, false));

        list.stream().filter(e-> e.getSalary() > 230000L)
        .map(employee->employee.getName())
        .collect(Collectors.toList())
        .forEach(e->System.out.println(e));

        list.stream().filter(e->e.getSalary() > 230000L && e.isHasCar() == true)
        .map(Employee::getName)
        .collect(Collectors.toList())
        .forEach(System.out::println);

        // list.stream().filter(e->e.)
    }
}
