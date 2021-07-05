package streams;

import java.util.*;
import java.util.function.BinaryOperator;

public class StreamBasicExample {
    public static void main(String[] args) {
        List<Integer> valueList = new ArrayList<>();
        List valueList1 = new ArrayList();
        Set<String> valueSet = new HashSet<>();
        Map<String, Integer> valueMap = new HashMap<>();

        //Filling the collection data

        for(int i=0; i< 10; i++){
            String str = "name"+i;
            valueList.add(i);
            valueSet.add(str);
            valueMap.put(str, i);
            valueList1.add(i);
            valueList1.add(str);
        }

        List e = new ArrayList();
        System.out.println(valueList.stream().findAny());
        System.out.println(valueList.stream().findAny().isPresent());
        System.out.println(e.stream().findFirst().isPresent());

        //Using Method reference
        StreamBasicExample streamBasicExample = new StreamBasicExample();

        System.out.println(valueList.stream()
            .map((i) -> streamBasicExample.calculateValue(i))
       //     .forEach(System.out::println)
           .reduce((integer, integer2) -> integer+integer2) )
            ;


        //Detailed implementation with explanation
        System.out.println(valueSet.stream().reduce( (s, s2) -> { if(s.length() > 3)  s= s+"_"+s2; return s;} )
        );
        System.out.println(valueSet.stream().reduce("myIdentity", (s, s2) -> { if(s.length() > 3)  s= s+"_"+s2; return s;} )
        );

        //Actulal implementation
        BinaryOperator bo = new BinaryOperator() {
            @Override
            public Object apply(Object o, Object o2) {
                return o+"-"+o2;
            }
        };

        System.out.println(valueSet.stream().reduce("firstValue", bo));
    }

    public int calculateValue(int i){
        int res = i+3;
        res = res *2;
        res = res%3;

        return res;
    }
}
