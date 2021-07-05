package datastructure;

class LinkedListImpl1{
    LinkedListImpl1 nextNode;
    LinkedListImpl1 prevNode;
    Object value;

    public LinkedListImpl1 getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListImpl1 nextNode) {
        this.nextNode = nextNode;
    }

    public LinkedListImpl1 getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(LinkedListImpl1 prevNode) {
        this.prevNode = prevNode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

class LinkedListDeclar1{
    private LinkedListImpl1 head;
    private LinkedListImpl1 tail;
    private int size;

    public int getSize() {
        return size;
    }

    public void addAtFront(Object value){
        LinkedListImpl1 lli = new LinkedListImpl1();
        lli.setValue(value);
        if(this.head == null){
            //lli.setNextNode(null);
            //lli.setPrevNode(null);
            this.head = lli;
            this.tail = lli;
        }else {
            lli.setNextNode(this.head);
            //lli.setPrevNode(null);
            // In case of size  more then 0 we have to provide previous value
            this.head.setPrevNode(lli);
            this.head = lli;
        }
        size++;
    }

    public void addFromLast(Object value){
        LinkedListImpl1 lli = new LinkedListImpl1();
        lli.setValue(value);
        if(this.head == null){
            this.head = lli;
            this.tail = lli;
        }else {
            this.tail.setNextNode(lli);
            lli.setPrevNode(this.tail);
            this.tail = lli;
        }
        size++;
    }

    public void removeFromLast(){
        if(this.head != null) {
            this.tail = this.tail.getPrevNode();
            //Incase only One Node
            if(this.tail != null)
                this.tail.setNextNode(null);
            size--;
        }
    }

    public void removeFromFront(){
        if(this.head != null) {
            this.head = this.head.getNextNode();
            //Incase only One Node
            if(this.head != null)
                this.head.setPrevNode(null);
            size--;
        }
    }

    public void remove(Object value){
        //Need traverse the List to find the object
        if(this.head != null){
            LinkedListImpl1 node = this.head;
            while (node != null && !node.getValue().equals(value) ){
                node = node.getNextNode();
            }

            //Handeling for single node
            if(node != null) {
                if (node.getNextNode() == null && node.getPrevNode() == null) {
                    this.head = null;
                    this.tail = null;
                    size++;
                } else {
                    if (node.getPrevNode() != null)
                        node.getPrevNode().setNextNode(node.getNextNode());
                    if (node.getNextNode() != null)
                        node.getNextNode().setPrevNode(node.getPrevNode());
                    size++;
                }
            }
        }
    }

    public void addBefore(Object beforeValue, Object insertItem){

        size++;
    }

    @Override
    public String toString() {
        LinkedListImpl1 val = this.head;
        if(val != null){
            StringBuilder strb = new StringBuilder();
            strb.append("[");
            int counter = 0;
            while (val != null && counter < 10){
                strb.append(val.getValue().toString()).append(", ");
                val = val.getNextNode();
                counter++;
            }
            strb.append("]");
            return strb.toString();
        }else {
            return "[]";
        }
    }

}

public class DoublyLinkedList {
    public static void main(String[] args) {
        LinkedListDeclar1 linkedListDecler = new LinkedListDeclar1();
        Employee ee = new Employee(30, 2000, "Durgesh");
        Employee ee1 = new Employee(30, 2000, "Rakesh");
        Employee ee2 = new Employee(30, 2000, "Pooja");
        Employee ee3 = new Employee(30, 2000, "Dharma");
        Employee ee4 = new Employee(30, 2000, "Ravikant");
        Employee ee5 = new Employee(30, 2000, "Kiran");
        linkedListDecler.removeFromFront();
        linkedListDecler.addAtFront(ee);
        linkedListDecler.removeFromFront();
        linkedListDecler.addAtFront(ee1);
        linkedListDecler.addAtFront(ee1);
        linkedListDecler.addAtFront(ee3);
        linkedListDecler.addAtFront(ee4);
        linkedListDecler.addAtFront(ee5);

        linkedListDecler.addFromLast(ee5);

       // System.out.println("Printing all the list =>"+linkedListDecler);

        linkedListDecler.removeFromFront();
       // System.out.println("Printing After Front Deletion=>"+linkedListDecler);
        linkedListDecler.removeFromLast();
       // System.out.println("Printing After End Deletion=>"+linkedListDecler);



        //Checking object removeal
        LinkedListDeclar1 llc = new LinkedListDeclar1();
        Employee e = new Employee(30, 2000, "Durgesh");
        llc.addAtFront(e);
        Employee e1 = new Employee(30, 2000, "Rakesh");
        llc.addAtFront(e1);
        System.out.println(llc);
        llc.remove(e);
        llc.remove(ee1); // Other value is here
        System.out.println(llc);
    }
}
