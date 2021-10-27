package basic;

import java.util.*;
import java.util.stream.Collectors;

public class SortedStringList {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        List<Integer> intDup = intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(intDup);

        //Finding Duplicates
        Set<Integer> intSet = new HashSet<>();
        //System.out.println(intSet.add(98));
        List<Integer> intDup1 = intList.stream().filter(a-> !intSet.add(a)).peek(System.out::println).collect(Collectors.toList());
        System.out.println(intDup1);
    }
}

/*

Employee table

Salary

select AB.salary
from
(
select distinct(salary) as salary , ROW_NUMBER() OVER (PARTITIONED By Salary order by Salary DESC) as rank
    from employee
) as AB
where AB.rank = 3;


 */





