package Encapsulation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;

class Employee {
    private String name;
    private double salary;
    private String department;
    

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    
    
    public String getName(){
        return name;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public String getDepartment(){
        return department;
    }
    
    public String toString(){
        return "Employee{ " +
            "name='"+ name +"'," +
            " salary='"+ salary +"'," +
            " department='"+ department +"'" +
            "}";
    }
}

public class SecondHighestSalaryByDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Pooja", 30000, "BD"),
            new Employee("Niranjan", 30000, "IT"),
            new Employee("Gautam", 31000, "IT"),
            new Employee("Sandeep", 29000, "HR"),
            new Employee("Santosh", 30000, "IT"),
            new Employee("Animesh", 36000, "HR")
        );
        
        Map<String, List<Employee>> deptWiseEmployee = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        
        Map<String, Optional<Employee>> secondHighestSalaryByDept = new HashMap<>();
        
        deptWiseEmployee.forEach((department, empList)->{
            Optional<Employee> secondHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
            secondHighestSalaryByDept.put(department, secondHighest);
        });
        
        secondHighestSalaryByDept.forEach((department, employee)->{
           if (employee.isPresent()) {
               System.out.println("Department: " + department + ", Second Highest Salary: " +  employee.get().getSalary() + ", Employee: " + employee.get().getName());
           }
            else{
                System.out.println("Department: " + department + " doesn't have enought employee for second-highest salary.");
            }
        });
    }
}
