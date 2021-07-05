package datastructure;


import java.util.Arrays;
import java.util.LinkedList;

/*
It's always recommended to use the linkedList for stack implementation. it's provide O(1) -> Constanct complexity. Using Array it will be O(n) because of
Array resizing
 */
class StackImpl{
    private int top;  //Always equal to length of array
    private int capacity; //used to store Array initial capacity
    private Object[] stackArray;

    //Here we are forcing to create array using defined size.
    //We can go with other approaches as well where these handling might not required
    StackImpl(int capacity){
        stackArray = new Object[capacity];
        this.capacity = capacity;
    }

    public void push(Object value){
        //Check the size of array. If it get filled then using some other method
        if((stackArray.length - top) > 0){
            stackArray[top] = value;
            top++;
        }else {
            //Performing Array sizing with received capacity.
            Object[] tmpArray = new Object[capacity*2];
            System.arraycopy(stackArray, 0, tmpArray, 0, top);
            stackArray = tmpArray;
            stackArray[top] = value;
            top++;
        }
    }

    public Object pop(){
        Object obj = null;
        if(stackArray.length > 0) {
            obj = stackArray[--top];
            stackArray[top] = null;
        }
        return obj;
    }

    public Object peek(){
        Object obj = null;
        if(stackArray.length > 0){
            obj = stackArray[top-1];
        }
        return obj;
    }

    public int getSize(){
        return top;
    }

    @Override
    public String toString() {
        return "StackImpl{" +
                "top=" + top +
                ", capacity=" + capacity +
                ", stackArray=" + Arrays.toString(stackArray) +
                '}';
    }
}

public class StackImplUsingArray {
    public static void main(String[] args) {
        System.out.println("This is new stack implementation using Array");
        StackImpl si = new StackImpl(5);
        si.push(2);
        si.push(20);
        si.push("data");
        si.push(new Employee(22, 1000, "dkp"));
        si.push(23);
        si.push(33);

        System.out.println("Value inside stack is =>"+si);

        System.out.println("Performing POP  =>"+si.pop());
        System.out.println("Performing POP =>"+si.pop());
        System.out.println("Performing PEEK =>"+si.peek());


        //Stack Using JDK LinkedList

        LinkedList<Object> stackList = new LinkedList<>();
        stackList.push(10); // add() is equivalent to push()
        stackList.push(11);
        stackList.push(12);
        stackList.push(13);
        System.out.println("Stack PUSH using LinkedList=>"+stackList);
        System.out.println("Stack POP using LinkedList=>"+stackList.pop());
        System.out.println("Stack PEEK using LinkedList=>"+stackList.peek());
        System.out.println("Stack POLE using LinkedList=>"+stackList.poll());

    }
}
