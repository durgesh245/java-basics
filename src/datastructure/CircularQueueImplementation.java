package datastructure;

//TO overcome the problem of memory consumption, we have to reuse the unused memories

/*
0 ->    10 - D
1 ->    11 - D
2 ->    12 - D
3 ->    13 - D
4 ->    14 - A - front
5 ->    15 - A - back (current value of back is equal to array length )

After that we move the back to zero and start using the additional elements

0 ->    10 - D - back
1 ->    11 - D
2 ->    12 - D
3 ->    13 - D  -
4 ->    14 - A - front
5 ->    15 - A (current value of back is equal to array length )

 */

import java.util.Arrays;

class QueueImpl1{
    //Implementation using Array
    private int front;  //initially zero -> Later increase for any deletion or remove or get
    private int back;  // initially zero -> Later increase by the length of array So to access the last element it should be back-1
    // Also No of element can be determine by  "back - front"
    private int capacity;
    private Object[] queueArray;


    QueueImpl1(int capacity){
        this.capacity = capacity;
        queueArray = new Object[capacity];
        this.front=0;
        this.back=0;
    }

    public void add(Object value){
        //Checking if array reached towards the end. Need to increase the Array Size
        // Need to do the handling for circular Queue
        if((back < front && (queueArray.length - (queueArray.length+back-front)) <= 1)){
            Object[] tmpArray = new Object[capacity*2];
            System.arraycopy(queueArray, front, tmpArray, 0, queueArray.length-front);
            System.arraycopy(queueArray, 0, tmpArray, front+1, back);
            back = queueArray.length;
            queueArray =tmpArray;
        }else if(back > front && ((queueArray.length - back) <= 1)){
            if(this.size() < (queueArray.length-1)){
                queueArray[back] = value;
                back = 0;
                return;
            }else {
                Object[] tmpArray = new Object[capacity*2];
                System.arraycopy(queueArray, 0, tmpArray, 0, back);
                queueArray =tmpArray;
            }
        }
        queueArray[back++] = value;
    }

    public Object remove(){
        Object obj = null;
        if(back < front && (queueArray.length - front) >= 1){
            obj = queueArray[0];
            queueArray[front] = null;
            front = 0;
        }
        else if((back - front) > 0) {
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
        if(back < front){
            return (queueArray.length+back-front);
        }else
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


public class CircularQueueImplementation {
    public static void main(String[] args) {
        QueueImpl1 queue = new QueueImpl1(4);
        queue.add(10);
        queue.add(11);
        queue.remove();
        System.out.println(queue);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.remove();
       // queue.add(14);
       // queue.add(15);

        System.out.println(queue);
       // queue.remove();
       // queue.remove();
       // System.out.println(queue.size());
    }
}
