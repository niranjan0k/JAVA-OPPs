import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Niranjan", "Sandeep", "Gautam", "Santosh", "Mukesh", "Laxmi");
        List<String> result = names.stream()
        .filter(name -> name.startsWith("S"))
        .map(String::toUpperCase)
        .collect(Collectors.toList());

        result.forEach((name)->{
            System.out.println(name);
        });

        // System.out.println(result);


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum : " + sum);


        List<String> fullName = Arrays.asList("Niranjan", "Kumar", "Vishwakarma");
        Optional<String> name = fullName.stream().reduce((f1, f2)-> f1 + " " + f2);
        name.ifPresent(System.out::println);
    }
}
