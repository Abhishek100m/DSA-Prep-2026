package com.prep.dsa.arrays.streams;

import com.prep.dsa.arrays.streams.pojo.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsQues1 {
    static List<Employee> employees;
    public static void main(String[] args) {
        initialization();
        //QUES 1: Find Employee count department wise
                Map<String, Long> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
                System.out.println(map);

        //QUES 2: Find Second Highest salary Department-wise from Employee
        Map<String, Double> map2 = employees.stream().
                        collect(Collectors.groupingBy(
                                Employee::getDepartment
                                ,Collectors.collectingAndThen(Collectors.toList(),
                                        list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                                                .skip(1).findFirst().get().getSalary()
                                )));
        System.out.println(map2);
                /*  here Key learning is
                    Collectors.collectingAndThen(
                        Collector<T, A, R> downstream,
                        Function<R, RR> finisher
                    )
                downstream → The collector that does the main work (like toList(), toSet(), groupingBy(), etc.).
                finisher → A function applied to the collected result before returning it.

                 Example 1: Make a List Unmodifiable

                            Without collectingAndThen():

                            List<String> list = names.stream()
                                    .collect(Collectors.toList());

                            list = Collections.unmodifiableList(list);

                            With collectingAndThen():

                            List<String> list = names.stream()
                                    .collect(Collectors.collectingAndThen(
                                            Collectors.toList(),
                                            Collections::unmodifiableList
                                    ));
                            Output
                            [Alice, Bob, Charlie]

                            Attempting:

                            list.add("David");

                            throws

                            UnsupportedOperationException
                            Example 2: Find the Maximum Value
                            List<Integer> nums = List.of(10, 20, 30, 40);

                            Integer max = nums.stream()
                                    .collect(Collectors.collectingAndThen(
                                            Collectors.maxBy(Integer::compareTo),
                                            Optional::get
                                    ));

                            System.out.println(max);

                            Output:

                            40
                            What's happening?
                            Collectors.maxBy() returns
                            Optional<Integer>
                            Optional::get converts it to
                            Integer

                            So instead of getting

                            Optional[40]

                            you directly get

                            40
                            Example 3: Count and Format
                            String result = names.stream()
                                    .collect(Collectors.collectingAndThen(
                                            Collectors.counting(),
                                            count -> "Total names: " + count
                                    ));

                            System.out.println(result);

                            Output:

                            Total names: 3
                            Example 4: Sort After Collecting
                            List<Integer> sorted = nums.stream()
                                    .collect(Collectors.collectingAndThen(
                                            Collectors.toList(),
                                            list -> {
                                                Collections.sort(list);
                                                return list;
                                            }
                                    ));
                            Example 5: Get First Element
                            String first = names.stream()
                                    .collect(Collectors.collectingAndThen(
                                            Collectors.toList(),
                                            list -> list.get(0)
                                    ));

                            System.out.println(first);

                            Output

                            Alice
                            Example 6: With groupingBy()

                            Suppose:

                            class Employee {
                                String department;
                                String name;

                                Employee(String department, String name) {
                                    this.department = department;
                                    this.name = name;
                                }

                                String getDepartment() {
                                    return department;
                                }
                            }
                            Map<String, Integer> result = employees.stream()
                                    .collect(Collectors.groupingBy(
                                            Employee::getDepartment,
                                            Collectors.collectingAndThen(
                                                    Collectors.counting(),
                                                    Long::intValue
                                            )
                                    ));

                            Here:

                            counting() returns Long
                            Long::intValue converts it to Integer

                            Result:

                            {
                                HR=5,
                                IT=8,
                                Sales=3
                            }


                */
    }

    private static void initialization() {
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
