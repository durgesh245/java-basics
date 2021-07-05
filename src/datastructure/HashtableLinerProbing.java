package datastructure;

import java.util.Arrays;

//Class to store the key and value and same will be stored in the hashtable array
class HashtableElement{
    private Object key;
    private Object value;

    HashtableElement(Object key, Object value){
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

//This will identify the collision and assign the value with next available null value
class HashtableLinerProbImpl{
    private HashtableElement[] hashtable;
    private int capcity = 10;

    HashtableLinerProbImpl(int capacity){
        this.capcity = capacity;
        hashtable = new HashtableElement[capacity];
    }

    /**
     * We have to handle the next available index in case of collision.
     * Also we have to consider the changes and perform the null handling carefully
     * @param key
     * @param value
     */

    //We are not performing resizing activity in this implementation
    public void put(Object key, Object value){
        int hashkey = getHashIndex(key);
        int initialIndex = 0;
        hashkey = getNextAvlIndex(hashkey , key);
        if(hashtable[hashkey] == null ){
            hashtable[hashkey] = new HashtableElement(key, value);
        }else  {
            hashtable[hashkey].setValue(value);  //Setting up the value as data will give the same value
        }
    }

    private int getNextAvlIndex(int hashkey , Object key){
        int index =0;
        int tmpHaskey = hashkey+1;
        //Case - 1 when avaibale index is blank Or has the same key
        if(hashtable[hashkey] == null || (hashtable[hashkey] != null && hashtable[hashkey].getKey().equals(key))){
            return hashkey;
        }

        //Case -2 When default index don't have the same key

        while (tmpHaskey < hashtable.length && tmpHaskey != hashkey){
            if(hashtable[tmpHaskey] == null || (hashtable[tmpHaskey] != null && hashtable[tmpHaskey].getKey().equals(key))){
                index = tmpHaskey;
                break;
            }
            tmpHaskey++;
            //Handeling the Right part
            if(tmpHaskey > hashkey && (tmpHaskey == hashtable.length)){
                tmpHaskey = 0;
            }
        }
        return index;
    }

    public Object get(Object key){
        int index = getHashIndexForGetAndRemove(key);
        if(index != -1 && hashtable[index] != null )
            return hashtable[index].getValue();
        else
            return null;
    }

    private int getHashIndexForGetAndRemove(Object key){
        int hashkey = getHashIndex(key);
        int index =-1;
        int tmpHaskey = hashkey+1;
        if(hashtable[hashkey] != null && hashtable[hashkey].getKey().equals(key))
            return hashkey;

        while (tmpHaskey < hashtable.length && tmpHaskey != hashkey){
            if(hashtable[tmpHaskey] != null && hashtable[tmpHaskey].getKey().equals(key)){
                index = tmpHaskey;
                break;
            }
            tmpHaskey++;
            //Handeling the Right part
            if(tmpHaskey > hashkey && (tmpHaskey == hashtable.length)){
                tmpHaskey = 0;
            }
        }
        System.out.println("Returning index is =>"+index);
        return index;
    }

    public Object remove(Object key){
        int index = getHashIndexForGetAndRemove(key);
        Object value = null;
        if(index != -1 && hashtable[index] != null) {
            value = hashtable[index].getValue();
            hashtable[index] = null;
        }
        return value;
    }

    private int getHashIndex(Object key){
        System.out.println("Key => "+key+ " HashCodeVal=>"+Math.abs(key.hashCode() % hashtable.length));
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
public class HashtableLinerProbing {

    public static void main(String[] args) {
        HashtableLinerProbImpl hsi = new HashtableLinerProbImpl(10);
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
