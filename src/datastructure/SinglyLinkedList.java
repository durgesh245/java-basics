package datastructure;


class LinkedListImpl {
    private Object value;
    private LinkedListImpl nextNode;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public LinkedListImpl getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListImpl nextNode) {
        this.nextNode = nextNode;
    }
}

class LinkedListDecler{
    private LinkedListImpl head;

    public void addAtFront(Object value) {
        //Setting head value in case of null
        if(this.head == null){
            LinkedListImpl lli = new LinkedListImpl();
            this.head = lli;
            lli.setValue(value);
            lli.setNextNode(null);
        }else {
            LinkedListImpl lli = new LinkedListImpl();
            lli.setValue(value);
            lli.setNextNode(this.head);
            this.head = lli;
        }
    }

    @Override
    public String toString() {
        LinkedListImpl val = this.head;
        if(val != null){
            StringBuilder strb = new StringBuilder();
            strb.append("[");
            while (val.getNextNode() != null){
                strb.append(val.getValue().toString()).append(", ");
                val = val.getNextNode();
            }
            strb.append(val.getValue().toString());
            strb.append("]");
            return strb.toString();
        }else {
            return "[]";
        }
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        //Linked List implementation for single predefined class

        LinkedListDecler linkedListDecler = new LinkedListDecler();
        Employee ee = new Employee(30, 2000, "Durgesh");
        Employee ee1 = new Employee(30, 2000, "Rakesh");
        Employee ee2 = new Employee(30, 2000, "Pooja");
        Employee ee3 = new Employee(30, 2000, "Dharma");
        Employee ee4 = new Employee(30, 2000, "Ravikant");
        Employee ee5 = new Employee(30, 2000, "Kiran");
        linkedListDecler.addAtFront(ee);
        linkedListDecler.addAtFront(ee1);
        linkedListDecler.addAtFront(ee1);
        linkedListDecler.addAtFront(ee3);
        linkedListDecler.addAtFront(ee4);
        linkedListDecler.addAtFront(ee5);
        linkedListDecler.addAtFront(ee5);

        System.out.println("Printing all the list =>"+linkedListDecler);
    }
}
