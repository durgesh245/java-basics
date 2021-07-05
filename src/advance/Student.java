package advance;

import java.io.Serializable;

public class Student implements Serializable{
    private static final long serialVersionUID= 1L;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
