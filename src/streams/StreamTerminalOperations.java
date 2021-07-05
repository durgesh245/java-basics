package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee1 {
    private int salary;
    private String Name;
    private int id;

    public Employee1(int salary, String name, int id) {
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

    public static List<Employee1> getObjectList(){
        List<Employee1> empList = Arrays.asList(new Employee1(300,"dkp1", 1),
                new Employee1(500,"dkp2", 2),
                new Employee1(100,"dkp3", 3),
                new Employee1(100,"dkp4", 4),
                new Employee1(500,"dkp5", 5));
        return empList;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "salary=" + salary +
                ", Name='" + Name + '\'' +
                ", id=" + id +
                '}';
    }

}

class NameSorter implements Comparator<Employee1>
{
    @Override
    public int compare(Employee1 e1, Employee1 e2) {
        return e1.getName().compareToIgnoreCase( e2.getName() ); // for name
    }
}

public class StreamTerminalOperations {
    public static void main(String[] args) {

        //forEach Method demonstrations using distinct
        List<Integer> intList = Arrays.asList(1,3,4,22,1,3,444,11,55,33,555,566,33);
        intList.stream().distinct().sorted(Comparator.reverseOrder()).forEach(integer -> {
            System.out.println("forEach Values in reverse sorting=>"+integer);
        });

        //forEachOrdered  -> Maintained the order for both parallel and sequential stream
        System.out.println("forEach with Parallel stream\n");
        intList.stream().parallel().forEach(System.out::println); //Order not Guaranteed
        System.out.println("forEachOrdered with Parallel stream\n");
        intList.stream().parallel().distinct().forEachOrdered(System.out::println); //Order Guaranteed

        //toArray ->
        Employee1[] values = Employee1.getObjectList().stream().filter(employee1 -> employee1.getSalary()>200).toArray(Employee1[]::new);
        System.out.println(Arrays.toString(values));


        Comparator<Employee1> getEmpData = new Comparator<Employee1>() {
            @Override
            public int compare(Employee1 o1, Employee1 o2) {
                return Integer.compare(o1.getSalary(),o2.getSalary());
            }
        };

        //Min using Comparator inner functions class concept -> Min giving only first occurance value not all values
        System.out.println(Employee1.getObjectList().stream().min(Comparator.comparing(Employee1::getSalary)));

        //Max using Comparator annonymous class concept -> Max giving only first occurance value not all values
        System.out.println(Employee1.getObjectList().stream().max(getEmpData).get());

        //
    }
}
