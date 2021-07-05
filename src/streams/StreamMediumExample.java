package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Employee{
    private int salary;
    private String Name;
    private int id;

    public Employee(int salary, String name, int id) {
        this.salary = salary;
        Name = name;
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Employee> getObjectList(){
        List<Employee> empList = Arrays.asList(new Employee(300,"dkp1", 1),
                new Employee(500,"dkp2", 2),
                new Employee(200,"dkp3", 3),
                new Employee(100,"dkp4", 4),
                new Employee(500,"dkp5", 5));
        return empList;
    }
}

public class StreamMediumExample {
    public static void main(String[] args){
        List<String> listValue = new ArrayList();
        for(int i : IntStream.range(2,50).toArray()){
            String str = "name"+i;
            listValue.add(str);
        }

        System.out.println(listValue);
        System.out.println("AllMatches =>"+listValue.stream().allMatch(s -> s.length() > 4 && s.contains("name") ));
        System.out.println("AllMatches =>"+listValue.stream().allMatch(s ->
        {
            boolean res = false;
            if(s.length() > 6 )
                res = true;
        return res;
        }));


        //Example with Predicate
        Predicate<String> ps = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                s = s.substring(4);
                Integer val = Integer.parseInt(s);
                if(val % 3  == 0)
                    return true;
                return false;
            }
        };

        Predicate<String> ps1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                s = s.substring(4);
                Integer val = Integer.parseInt(s);
                if(val % 5  == 0)
                    return true;
                return false;
            }
        };

        Predicate ps3 = ps.or(ps1);

        System.out.println(listValue.stream().anyMatch(ps3));
        System.out.println(listValue.stream().filter(ps3).collect(Collectors.toList()));


        //map function using class and distinct
        List<Employee> empList = Employee.getObjectList();
        System.out.println(empList.stream().map(employee -> employee.getSalary() * 10).distinct().collect(Collectors.toList()));

        //FlatMap example -> Expect stream in return (Be careful with that)

        String[][] str = new String[][]{{"abc","123"},{"adbc","13323"},{"abddc","333"},{"abc","123"}};
        List strList = Arrays.asList(str);
        System.out.println(Arrays.stream(str)
                .flatMap(o -> Arrays.stream(o))
                .collect(Collectors.toList()));


        //Sorted exmaple
        List<Integer> intList = Arrays.asList(100,20,300,40,5,600);
        //intList.sort((o1, o2) -> o1.compareTo(o2)); // Normal Method
        System.out.println(intList.stream());
        System.out.println(intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //Peek -> Used mainly for debugging and dispalying the intermediate stream data.
        System.out.println("Peek=>"+intList.stream().filter(integer -> integer > 25).peek(System.out::println).collect(Collectors.toList()));

        //Limit and Skip
        System.out.println("Limit and Skip=>"+intList.stream().peek(System.out::println).skip(2).limit(3).collect(Collectors.toList()));
    }
}
