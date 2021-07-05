package advance;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SerialisationUsingXML  {
    public static void main(String[] args) throws Exception {
        Student st = new Student();
        st.setAge(10);
        st.setName("Durgesh");

        Student st1 = new Student();
        st1.setAge(100);
        st1.setName("Pandey");

        List<Student> stList = new ArrayList<>();
        stList.add(st);
        stList.add(st1);

        College cl = new College();
        cl.setStudentList(stList);
        System.out.println("Going to write the object");
        XMLEncoder xmlWrite = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("collegeWithStudent.xml")));
        xmlWrite.writeObject(cl);
        xmlWrite.flush();
        xmlWrite.close();
        System.out.println("Object written successfully");

        //Deserialisation Using Java
        System.out.println("Goint to read the same object from XML");
        XMLDecoder xmlDec = new XMLDecoder(new BufferedInputStream(new FileInputStream("collegeWithStudent.xml")));
        College clOut = (College)xmlDec.readObject();
        xmlDec.close();
        System.out.println("Output after reading the object is => "+clOut.getStudentList().get(1).getName());




        //Serilisation Using JSON -> Possible usinh JACKSON and Gson Libs


    }
}