package datastructure;

//This method use to store the collision key in format of chain.
// Generally we use the linked list to perform the operations
// This approach is bit faster if we have less data but can be cumbersome in case of huge data
// Complexity also dependency on the List capacity.

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Class to store the key and value and same will be stored in the hashtable array
class HashtableElement1{
    private Object key;
    private Object value;

    HashtableElement1(Object key, Object value){
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HashtableElement{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class HashtableChainImpl{
    //default bucket size or list capacity  of array to perform the chaining
    private int capacity =10;
    private List<Object>[] hashtable = new List[capacity];
    HashtableChainImpl(){
        for(int i =0; i < capacity; i++){
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(Object key, Object value){
            int hashkey = getHashIndex(key);
            //Addition of element in case of blank element
            if(hashtable[hashkey].isEmpty()){
                hashtable[hashkey].add(new HashtableElement1(key, value));
            }else{
                int index =  getIndexForRemoveAndGet(hashkey , key);
                if(index > -1){
                    ((HashtableElement1)hashtable[hashkey].get(index)).setValue(value);
                }else {
                    hashtable[hashkey].add(new HashtableElement1(key, value));
                }
            }
    }

    public Object get(Object key){
        Object obj = null;
        int hashkey = getHashIndex(key);
        int index = getIndexForRemoveAndGet(hashkey, key);
        if(index > -1){
            obj = ((HashtableElement1) (hashtable[hashkey].get(index))).getValue();
        }
        return obj;

    }

    public Object remove(Object key){
        Object obj = null;
        int hashkey = getHashIndex(key);
        int index = getIndexForRemoveAndGet(hashkey, key);
        if(index > -1){
            obj = ((HashtableElement1) (hashtable[hashkey].get(index))).getValue();
            hashtable[hashkey].remove(index);
        }

        return obj;
    }

    public int getIndexForRemoveAndGet(int hashkey, Object key){
        Iterator<Object> irt = hashtable[hashkey].iterator();
        int index = -1;
        int cnt = 0;
        while (irt.hasNext()){
            HashtableElement1 elm = (HashtableElement1) irt.next();
            if(elm.getKey().equals(key)){
                index = cnt;
                break;
            }
            cnt++;
        }
        return index;
    }

    private int getHashIndex(Object key){
        System.out.println("Key => "+key+ " HashCodeVal=>"+Math.abs(key.hashCode() % hashtable.length));
        return Math.abs(key.hashCode() % hashtable.length);
    }

    @Override
    public String toString() {
        return "HashtableChainImpl{" +
                "capacity=" + capacity +
                ", hashtable=" + Arrays.toString(hashtable) +
                '}';
    }
}

public class HashtableUsingChaining {
    public static void main(String[] args) {
        HashtableChainImpl hsi = new HashtableChainImpl();
        hsi.put("1223", "dkp1");
        hsi.put(2323, "dkp2");

        hsi.put(2323, "dkp..");
        hsi.put(1122, "dkp3");
        hsi.put("hmmm", "pandey");
        hsi.put("qweqwe", "dharma");
        System.out.println(hsi);
        hsi.remove(2323);
        System.out.println(hsi);
        System.out.println(hsi.get("qweqwe"));
        System.out.println(hsi.get("hmmm"));
        System.out.println(hsi.get("hmm"));
        System.out.println(hsi.remove("1223"));
        System.out.println(hsi);
    }
}
