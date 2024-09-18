package StreamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * EvenNumber
 */
class StreamAPIUsefulDemo {

    // Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
    public void evenNumber(){
        List<Integer> list = Arrays.asList(1, 10, 13, 16, 15, 25, 98, 23);
        list.stream()
        .filter(n-> n%2 == 0)
        .forEach(System.out::println);

        // Or another way
        int nums[] = {1, 10, 13, 16, 15, 25, 98, 23};
        Map<Boolean, List<Integer>> mList = Arrays.stream(nums).boxed()
        .collect(Collectors.partitioningBy(num-> num % 2 == 0));
        System.out.println(mList);
    }
    
    // Given a list of integers, find out all the numbers starting with 1 using Stream functions?
    public void numberStartWithOne(){
        List<Integer> list = Arrays.asList(1, 10, 13, 16, 15, 25, 98, 23);
        list.stream()
        .map(s->s + "")
        .filter(s->s.startsWith("1"))
        .forEach(System.out::println);

        // or another way
        int nums[] = {1, 10, 13, 16, 15, 25, 98, 23};
        List<String> sList = Arrays.stream(nums).boxed()
        .map(s->s + "")
        .filter(s->s.startsWith("1"))
        .collect(Collectors.toList());

        System.out.println(sList);
    }
    
    // How to find duplicate elements in a given integers list in java using Stream functions?
    public void getDuplicateElements(){
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet<>();
        list.stream().filter(n-> !set.add(n))
        .forEach(System.out::println);

        System.out.println("\n==================\n");

        // Or another way unique Data
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream().distinct().forEach(n->System.out.println(n));

        System.out.println("\n==================\n");

        // Or
        List<Integer> nums = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> uniqueNums = new HashSet<>(nums);
        List<Integer> uniqueData = uniqueNums.stream().collect(Collectors.toList());
        uniqueData.forEach(System.out::println);

        System.out.println("\n==================\n");

        // Or
        int arr[] = {10,15,8,49,25,98,98,32,15};
        List<Integer> duplicateNums = Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());
        System.out.println(duplicateNums);
    }

    // Given the list of integers, find the first element of the list using Stream functions?
    public void getFirstElement(){
        List<Integer> mList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        mList.stream().findFirst().ifPresent(System.out::println);

        System.out.println("===================");

        // or another way
        int arr[] = {10,15,8,49,25,98,98,32,15};
        Arrays.stream(arr).findFirst().ifPresent(System.out::println);
    }

    // Given a list of integers, find the total number of elements present in the list using Stream functions?
    public void getTotalElements(){
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(list.stream().count());

        System.out.println("====================");

        // or another way
        int arr[] = {10,15,8,49,25,98,98,32,15};
        long len = Arrays.stream(arr).boxed().count();
        System.out.println(len);
    }

    // Given a list of integers, find the maximum value element present in it using Stream functions?
    public void getMaxValue()
    {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int max = list.stream().max(Integer::compare).get();
        System.out.println(max);

        // Or
        int arr[] = {10,15,8,49,25,98,98,32,15};
        int maxData = Arrays.stream(arr).boxed().max(Comparator.naturalOrder()).get();
        System.out.println(maxData);
    }

    // Given a list of integers, sort all the values present in it using Stream functions?
    public void sortValues(){
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        list.stream().sorted().forEach(System.out::println);

        // or other way

        int arr[] = {10,15,8,49,25,98,98,32,15};
        List<Integer> myList = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        System.out.println(myList);
    }

    // Given a list of integers, sort all the values present in it in descending order using Stream functions?
    public void sortDescendingOrder()
    {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        list.stream()
        .sorted(Collections.reverseOrder())
        .forEach(System.out::println);

        // or 
        int arr[] = {10,15,8,49,25,98,98,32,15};
        Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).forEach(e->System.out.println(e));

    }

    // Given a String, find the first non-repeated character in it using Stream functions?
    public void getFirstNonRepeatedChar() {
        String input = "Java is awesome language";
        Character result = input.chars()
        .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
        .entrySet()
        .stream()
        .filter(entry->entry.getValue() == 1L)
        .map(entry->entry.getKey())
        .findFirst()
        .get();

        System.out.println(result);

        // or
        char myChar = input.chars().mapToObj(c->(char) c)
        .filter(ch->input.indexOf(ch) == input.lastIndexOf(ch))
        .findFirst().orElse(null);

        System.out.println(myChar);
    }

    // Given a String, find the first repeated character in it using Stream functions?
    public void getFirstRepeatedChar()
    {
        String input = "Java is awesome language";
        Character character = input.chars()
        .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s)))
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry-> entry.getValue() > 1L)
        .map(entry->entry.getKey())
        .findFirst()
        .get();

        System.out.println(character);

        // or
        Set<Character> seenCharacters = new HashSet<>();
        char mChar = input.chars()
        .mapToObj(c->(char) c)
        .filter(c-> !seenCharacters.add(c))
        .findFirst()
        .orElse(null);

        System.out.println(mChar);
    }


    // Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    public boolean containDuplicate(int[] nums)
    {
        List<Integer> list = Arrays.stream(nums).boxed()
        .collect(Collectors.toList());

        Set<Integer> set = new HashSet<>(list);
        if (set.size() == list.size()){
            return false;
        }else{
            return true;
        }

        // or

        // Set<Integer> setData = new HashSet<>();
        // return Arrays.stream(nums).anyMatch(num->!setData.add(num));
    }

    // Write a Java 8 program to concatenate two Streams?
    public void concatTwoStream(){
        List<String> list1 = Arrays.asList("Niranjan", "Sandeep", "Pooja", "Gautam");
        List<String> list2 = Arrays.asList("Santosh", "Laxmi");

        Stream.concat(list1.stream(), list2.stream()).forEach(s->System.out.println(s));
    }

    // Java 8 program to perform cube on list elements and filter numbers greater than 50.
    public void cubeAndFilterGreater50()
    {
        List<Integer> list = Arrays.asList(1, 4, 5, 7, 8, 3, 2);
        list.stream()
        .map(i-> i * i * i)
        .filter(num-> num > 50)
        .forEach(System.out::println);
    }

    // Write a Java 8 program to sort an array and then convert the sorted array into Stream?
    public void sortArrayConvertStream()
    {
        int[] arr = {99, 55, 203, 99, 4, 91};
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }

    // How to use map to convert object into Uppercase in Java 8?
    public void convertToUpperCase()
    {
        List<String> list = Arrays.asList("ab", "Tere bin", "g", "Lenge", "Hm");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }


    // How to count each element/word from the String ArrayList in Java8?
    public void getWordCount(){
        List<String> list = Arrays.asList("AA", "BB", "CC", "AA");
        Map<String, Long> nameCount = list.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(nameCount);
    }

    public void getDuplicateElementsAndItsCount(){
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> duplicateName = names.stream()
        .filter(n-> Collections.frequency(names, n) > 1)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(duplicateName);

        // or

        Map<String, Long> nameCount = names.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .filter(f-> f.getValue() > 1)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(nameCount);

    }

    // Write a Program to find the Maximum element in an array?
    public void getMaxElement()
    {
        int [] arr = {12, 19, 20, 88, 00, 9};
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }

    // Write a program to print the count of each character in a String?
    public void findCountOfChars(String s){
        Map<String, Long> map = Arrays.stream(s.split(""))
        .map(String::toLowerCase)
        .collect(Collectors.groupingBy(str->str, LinkedHashMap::new, Collectors.counting()));

        System.out.println(map);

        // or you can also find Function.identity()
        Map<String, Long> mapObj = Arrays.stream(s.split(""))
        .map(String::toLowerCase)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(mapObj);
    }

}

public class App {
    public static void main(String[] args) {
        StreamAPIUsefulDemo s = new StreamAPIUsefulDemo();

        // s.evenNumber();
        // s.numberStartWithOne();
        // s.getDuplicateElements();
        // s.getFirstElement();
        // s.getTotalElements();
        // s.getMaxValue();
        // s.getFirstNonRepeatedChar();
        // s.getFirstRepeatedChar();
        // s.sortValues();
        // s.sortDescendingOrder();
        // int [] arr = {1, 2, 3, 4};
        // int [] arr = {1, 2, 3, 3};
        // System.out.println(s.containDuplicate(arr));
        // s.concatTwoStream();
        // s.cubeAndFilterGreater50();
        // s.sortArrayConvertStream();
        // s.convertToUpperCase();
        // s.getWordCount();
        // s.getDuplicateElementsAndItsCount();
        // s.getMaxElement();
        s.findCountOfChars("find data to count each char");
    }
}
