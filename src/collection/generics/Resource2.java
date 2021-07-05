package collection.generics;

public class Resource2 extends ResourceBase {
    ResourceUnitPojo res2;

    @Override
    public void displayResource() {
        System.out.println("Display in resource2");
    }

    @Override
    public void setResource() {
        System.out.println("Set Resource in resource2");
        int id = (int) (Math.random() * 1000);
        ResourceUnitPojo1 res = new ResourceUnitPojo1();
        res.setId(id);

        res2=  new ResourceUnitPojo();
        res2.setResourceUnitPojo1(res);
        res2.setValue("resource2");
    }

    @Override
    public String toString() {
        return "Value=>"+res2.getValue()+"  Id =>"+res2.getResourceUnitPojo1().getId();
    }
}
