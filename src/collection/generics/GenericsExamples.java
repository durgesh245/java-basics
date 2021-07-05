package collection.generics;



public class GenericsExamples {
    public static void main(String[] args) {
        System.out.println("Class level generics example started => ");

        BaseResourceGenerics<Resource1, Resource2> baseResourceGenerics =  new BaseResourceGenerics();

        //baseResourceGenerics.res1 = new Resource1();
        //baseResourceGenerics.res2 = new Resource2();
        Resource1 res1 = new Resource1();
        Resource2 res2 = new Resource2();

        //Onject getting populated with additional data from central place
        baseResourceGenerics.setResourceValue(res1, res2);
        baseResourceGenerics.show();

        System.out.println("Value of resource one is => "+res1);
        System.out.println("Value of resource one is => "+res2);
    }
}
