package com.prep.dsa.arrays.streams;

import com.prep.dsa.arrays.streams.pojo.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamsQues2 {
    static List<Employee> employees;
    public static void main(String[] args) {
//        QUES 1:
//        Convert a string like "ebebccc" to "e2b2c3" using Streams.
        String s = "ebebccc";
        String result = s.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().map(x-> x.getKey() +""+ x.getValue())
                .collect(Collectors.joining());
        System.out.println(result);

//------------------------------------------------------------------------------------------------------------------
/*1. Count frequency of each character
        Input:  "programming"
        Output: {p=1, r=2, o=1, g=2, a=1, m=2, i=1, n=1}
*/
        String s2 = "programming";
        java.util.Map<Character, Long>map = s2.chars().mapToObj(x->(char)x).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        System.out.println(map);
//------------------------------------------------------------------------------------------------------------------

/*2. Find duplicate characters
        Input: "programming"
        Output: [r, g, m]
*/
        String s3 = "programming";
        Set<Character>set=new HashSet<>();
        List<Character> list = s3.chars().mapToObj(x->(char)x)
                        .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                                .entrySet().stream().
                                    filter(x-> x.getValue()>1).
                                    map(x->x.getKey()).collect(Collectors.toList());
        System.out.println(list);

//------------------------------------------------------------------------------------------------------------------

/*3. Find first non-repeated character
       Input: "swiss"
        Output: w
*/
        String s4 = "swiss";
        Character c =  s4.chars().mapToObj(x->(char)x).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x-> x.getValue()==1).findFirst().get().getKey();
        System.out.println(c);


//------------------------------------------------------------------------------------------------------------------

/*4. Find first repeated character
            Input: "abcaef"
            Output: a
*/
        String s5 = "abcaef";
        Character c2 =  s5.chars().mapToObj(x->(char)x).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x-> x.getValue()>1).findFirst().get().getKey();
        System.out.println(c2);

//------------------------------------------------------------------------------------------------------------------

/*5. Convert list to map
        List<Employee>
        Output - {id -> employee}
*/
        initialization();
        Map<Integer, Employee> map1 = employees.stream().collect(Collectors.toMap(Employee::getId,Function.identity()));
        System.out.println(map1);


//------------------------------------------------------------------------------------------------------------------

/*
    * 6. Find highest salary employee
    List<Employee>
    Using Streams only.
*/
        Employee e = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(e);

//------------------------------------------------------------------------------------------------------------------

/*
    10. Highest paid employee in each department
        Output
        IT -> Rahul
        HR -> Amit
*/
        Map<String, String> map2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list1 -> list1.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                                                        .findFirst().get().getName()
                        )
                        )
                );
        System.out.println(map2);



/*
    11. Partition employees

            Salary > 50000

            Output

            true -> [...]
            false -> [...]

            Hint:
            partitioningBy()
*/
                // ==================== 10. (Reserved) ====================


// ==================== 11. Partition Employees ====================

                Map<Boolean, List<Employee>> partitionResult = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 50000));
        System.out.println(partitionResult);

// ==================== 12. Convert to Uppercase ====================

        List<String> languageList = Arrays.asList("java", "python", "c++");

        String upperCaseResult = languageList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(upperCaseResult);


// ==================== 13. Flatten List ====================

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );

        List<Integer> flattenedList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flattenedList);


// ==================== 14. Longest String ====================

        List<String> stringList = Arrays.asList("Java", "SpringBoot", "SQL");

        String longestString = stringList.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println(longestString);


// ==================== 15. Word Frequency ====================

        String sentence = "I love java java streams";

        Map<String, Long> wordFrequency = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));

        System.out.println(wordFrequency);


// ==================== 16. Remove Duplicates ====================

        List<Integer> duplicateNumbers = Arrays.asList(3, 2, 4, 2, 5, 3, 6);

        List<Integer> uniqueNumbers = duplicateNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueNumbers);


// ==================== 17. (Reserved) ====================


// ==================== 18. (Reserved) ====================


// ==================== 19. Frequency Sort ====================

        String frequencyInput = "tree";

        String frequencySorted = frequencyInput.chars()
                .mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue().intValue()))
                .collect(Collectors.joining());

        System.out.println(frequencySorted);


// ==================== 20. Top K Frequent ====================

        List<Integer> topKInput = Arrays.asList(1,1,1,2,2,3);
        int topK = 2;

        List<Integer> topKResult = topKInput.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(topK)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(topKResult);


// ==================== 21. Common Elements ====================

        List<Integer> firstList = Arrays.asList(1,2,3,4);
        List<Integer> secondList = Arrays.asList(3,4,5,6);


        List<Integer> commonElements = firstList.stream()
                .filter(new HashSet<>(secondList)::contains)
                .collect(Collectors.toList());

        System.out.println(commonElements);


// ==================== 22. Missing Numbers ====================

        List<Integer> missingInput = Arrays.asList(1,2,4,6,7);

        int maxValue = missingInput.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        Set<Integer> missingSet = new HashSet<>(missingInput);

        List<Integer> missingNumbers = IntStream.rangeClosed(1, maxValue)
                .filter(i -> !missingSet.contains(i))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(missingNumbers);


// ==================== 23. Anagram ====================

        String firstWord = "listen";
        String secondWord = "silent";

        boolean anagramResult = Arrays.stream(firstWord.split(""))
                .sorted()
                .collect(Collectors.joining())
                .equals(
                        Arrays.stream(secondWord.split(""))
                                .sorted()
                                .collect(Collectors.joining())
                );

        System.out.println(anagramResult);


// ==================== 24. Most Frequent Character ====================

        String frequentInput = "success";

        Character frequentCharacter = frequentInput.chars()
                .mapToObj(x -> (char)x)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(frequentCharacter);


// ==================== 25. Reverse Every Word ====================

        String reverseSentence = "Java Stream API";

        String reversedWords = Arrays.stream(reverseSentence.split("\\s+"))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println(reversedWords);


// ==================== 26. Group By Length ====================

        List<String> lengthInput = Arrays.asList("java","c","python","go");

        Map<Integer, List<String>> groupedByLength = lengthInput.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);


// ==================== 27. Average Salary By Department ====================

        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println(averageSalary);


// ==================== 28. Kth Highest Salary ====================

        int kth = 3;

        Double kthHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(kth - 1)
                .findFirst()
                .orElse(null);

        System.out.println(kthHighestSalary);


// ==================== 29. Merge Lists ====================

        List<Integer> mergeFirst = Arrays.asList(1,2,3);
        List<Integer> mergeSecond = Arrays.asList(3,4,5);

        List<Integer> mergedList = Stream.concat(
                        mergeFirst.stream(),
                        mergeSecond.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(mergedList);


// ==================== 30. Find Palindromes ====================

        List<String> palindromeInput = Arrays.asList(
                "madam","java","level","stream");

        List<String> palindromeResult = palindromeInput.stream()
                .filter(word ->
                        word.equals(new StringBuilder(word).reverse().toString()))
                .collect(Collectors.toList());

        System.out.println(palindromeResult);










    }
    public static void initialization() {
        employees =  List.of(
                new Employee(1, "Alice", "IT", 90000),
                new Employee(2, "Bob", "IT", 80000),
                new Employee(3, "Charlie", "IT", 70000),
                new Employee(4, "David", "HR", 60000),
                new Employee(5, "Eva", "HR", 75000),
                new Employee(6, "Frank", "HR", 50000),
                new Employee(7, "George", "Sales", 85000),
                new Employee(8, "Helen", "Sales", 95000),
                new Employee(9, "Ian", "Sales", 70000)
        );
    }
}
