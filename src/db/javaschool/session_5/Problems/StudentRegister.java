package db.javaschool.session_5.Problems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRegister {

    private List<Student> studenti = new ArrayList<>();

    public void addStudent(final Student student) {
        studenti.add(student);
    }

    public void writeStudents(String fileName) {
        try {
            FileOutputStream outputFile = new FileOutputStream(fileName);
            for (Student student : studenti) {
                student.writeToFile(outputFile);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void readStudents(String fileName) {
        try {
            FileInputStream inputFile = new FileInputStream(fileName);
            Student student = null;
            do {
                try{
                student = Student.readFromFile(inputFile);}
                catch (IOException e) {
                    return;
                }
                if (student != null) {
                    studenti.add(student);
                }
            }while (student != null);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudenti() {
        return studenti;
    }
}