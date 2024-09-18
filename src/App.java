import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/**
 * GenericsTest
 */
class GenericsClassTest<T> {

    T obj;
    void add(T obj){
        this.obj = obj;
    }
    T get(){
        return obj;
    }
}

/**
 * Person
 */
class Person {

    private String name;
    private int age;
    private String gender;
    
    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getPersonName(){
        return "Name: " + name + " Age: " + age + " Gender: " + gender;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // GenericsClassTest<Integer> m = new GenericsClassTest<Integer>();
        // m.add(10);
        // // m.add("Hello"); // compile time error
        // System.out.println(m.get());


        ArrayList<String> list = new ArrayList<String>();
        list.add("Niranjan");
        list.add("Sandeep");
        list.add("Pooja");
        System.out.println(list);

        list.forEach((n)->{
            System.out.println(n);
        });

        // Iterator<String> itr = list.iterator();
        // System.out.println(itr.hasNext());
        // while (itr.hasNext()) {
        //     System.out.println(itr.next());
        // }
        // list.forEach(String name);
        ArrayList<Person> persons = new ArrayList<Person>();

        HashMap<Integer, String>  hMap = new HashMap<>();
        hMap.put(1, "Niranjan");
        hMap.put(2, "Gautam");
        hMap.put(3, "Sandeep");

        hMap.forEach((k, v)->{
            System.out.println("Key: " + k + " Value: " + v);
        });
        // for (Integer i: hMap.keySet()){
        //     System.out.println(hMap.get(i));
        // }

        
    }
}
