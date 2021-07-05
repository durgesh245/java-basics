package datastructure;


//Queue implementation using array and jdk linked list
// We can use the custom doubly linked list as well to represent the same.
//FIFO
// This has the disadvantage of having unused memory consumption as we are only increasing the memory as per the requirement.


import java.util.Arrays;

class QueueImpl{
    //Implementation using Array
    private int front;  //initially zero -> Later increase for any deletion or remove or get
    private int back;  // initiall zero -> Later increase by the length of array So to access the last element it should be back-1
                        // Also No of element can be determine by  "back - front"
    private int capacity;
    private Object[] queueArray;


    QueueImpl(int capacity){
        this.capacity = capacity;
        queueArray = new Object[capacity];
        this.front=0;
        this.back=0;
    }

    public void add(Object value){
        //Checking if array reached towards the end. Need to increase the Array Size
        if((queueArray.length - back) <= 1){
            Object[] tmpArray = new Object[capacity*2];
            System.arraycopy(queueArray, 0, tmpArray, 0, back);
            queueArray =tmpArray;
        }
        queueArray[back++] = value;
    }

    public Object remove(){
        Object obj = null;
        if((back - front) > 0) {
            obj = queueArray[front++];
            queueArray[front-1] = null;
        }
        return obj;
    }

    public Object peek(){
        Object obj = null;
        if((back - front) > 0) {
            obj = queueArray[front];
        }
        return obj;
    }

    public int size(){
        return (back - front);
    }

    @Override
    public String toString() {
        return "QueueImpl{" +
                "front=" + front +
                ", back=" + back +
                ", capacity=" + capacity +
                ", queueArray=" + Arrays.toString(queueArray) +
                '}';
    }
}

public class QueueImplementation {
    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(4);
        queue.add(22);
        queue.add(99);
        queue.add(3427);
        queue.add(new Employee(12,2222,"dkp"));
        //queue.add("Queue Implementation");

        System.out.println(queue);
        queue.remove();
        queue.remove();
        System.out.println(queue.size());
    }
}
