package streams;

import java.util.*;


interface FuncationalExample{
    void funRun();
}

class FunctionalImpl implements FuncationalExample{
    @Override
    public void funRun() {
        System.out.println("This is Functional Implementation");
    }
}

public class LambdaExamples {
    public static void main (String[] arg){
        //Calling Functional Interface without Lambda expression
        FuncationalExample fe= new FunctionalImpl();
            fe.funRun();

        //Calling Functional Interface with Lambda / annonymous expression
        FuncationalExample fe1 = new FuncationalExample() {
            @Override
            public void funRun() {
                System.out.println("This is lambda expression using annonymous class or inner class concept");
            }
        };
        fe1.funRun();

        //Calling Functional Interface with pure Lambda expression
        FuncationalExample fe2 = () -> { System.out.println("Pure Lambda expression calling"); };
        fe2.funRun();
    }
}
