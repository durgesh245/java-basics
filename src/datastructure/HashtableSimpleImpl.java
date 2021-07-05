package datastructure;

/*
* Hashtable implementation can be done using only array or combination of array and linkedList
* */

import java.util.Arrays;

//Implementation using Array
class HashtableSimImpl{
    private Object[] hashtable;
    private int capcity = 10;

    HashtableSimImpl(int capacity){
        this.capcity = capacity;
        hashtable = new Object[capacity];
    }

    public void put(Object key, Object value){
        int hashkey = getHashIndex(key);
        if(hashtable[hashkey] == null){
            hashtable[hashkey] = value;
        }else {
            System.out.println(key+" hashKey=>"+hashkey+" Already occupied");
        }
    }

    public Object get(Object key){
        int hashkey = getHashIndex(key);

        return hashtable[hashkey];
    }

    public void remove(Object key){
        int hashkey = getHashIndex(key);
        hashtable[hashkey] = null;
    }

    private int getHashIndex(Object key){
        return Math.abs(key.hashCode() % hashtable.length);
    }

    @Override
    public String toString() {
        return "HashtableSimImpl{" +
                "hashtable=" + Arrays.toString(hashtable) +
                ", capcity=" + capcity +
                '}';
    }
}

public class HashtableSimpleImpl {
    public static void main(String[] args){

        HashtableSimImpl hsi = new HashtableSimImpl(10);

        hsi.put("1223", "dkp1");
        hsi.put(2323, "dkp2");

        hsi.put(2323, "dkp..");
        hsi.put(1122, "dkp3");
        hsi.put("hmmm", "pandey");
        hsi.put("hmm", "dharma");
        System.out.println(hsi);
        hsi.remove(2323);
        System.out.println(hsi);
        System.out.println(hsi.get("hmm"));
        System.out.println(hsi.get("hmmm"));
    }
}
