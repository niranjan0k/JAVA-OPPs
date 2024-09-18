package Encapsulation;

// Encapsulated class with private data members
class EmployeeTest {
    private String name;
    private int age;
    private double salary;

    // Constructor to initialize Employee object
    public EmployeeTest(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter method for name
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        if (salary > 0){
            this.salary = salary;
        }
        else{
            System.out.println("Salary must be positive");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an object of Employee class
        EmployeeTest emp = new EmployeeTest("John", 30, 50000);

        // Accessing the Employee's details using getter methods
        System.out.println("Name: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Salary: " + emp.getSalary());

        // Modifying the Employee's details using setter methods
        emp.setName("Doe");
        emp.setAge(35);
        emp.setSalary(60000);

        // Displaying the updated Employee details
        System.out.println("Updated Name: " + emp.getName());
        System.out.println("Updated Age: " + emp.getAge());
        System.out.println("Updated Salary: " + emp.getSalary());
    }
}

