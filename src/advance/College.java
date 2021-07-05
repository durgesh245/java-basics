package advance;

import java.io.Serializable;
import java.util.List;

public class College implements Serializable{
    private static final long serialVersionUID= 2L;
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    List<Student> studentList;
}
