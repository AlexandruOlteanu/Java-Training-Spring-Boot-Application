package db.javaschool.session_5.Problems;

import java.io.*;

public class Student implements Serializable {
    private String name;
    private Integer grade;

    Student(String name , Integer grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void writeToFile(FileOutputStream file){
        try {
            ObjectOutputStream stream=new ObjectOutputStream(file);
            stream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Student readFromFile(FileInputStream file) throws IOException {
        Student student;
        try {
            ObjectInputStream stream = new ObjectInputStream(file);
            student = (Student) stream.readObject();
        }  catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
