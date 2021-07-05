package collection.generics;

public class BaseResourceGenerics<T extends ResourceBase, X extends ResourceBase> {
    T res1;
    X res2;

    public void show(){
        System.out.println("BaseResourceGenerics res2 Class=>"+res1.getClass()+ " res2 class=>"+res2.getClass());
    }
    public synchronized boolean setResourceValue(T res1){
        this.res1 = res1;
        //Generating IDs for One resources
        res1.setResource();

        return true;
    }

    public synchronized boolean setResourceValue(T res1, X res2){
        this.res1 = res1;
        this.res2 = res2;

        //Generating IDs for both resources
        res1.setResource();
        res2.setResource();

        return true;
    }

}
