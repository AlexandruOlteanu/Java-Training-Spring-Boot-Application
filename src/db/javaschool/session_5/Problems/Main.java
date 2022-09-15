package db.javaschool.session_5.Problems;

public class Main {
    public static void main(String[] args) {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.addStudent(new Student("Vlad",4));
        studentRegister.addStudent(new Student("Mihai",7));
        studentRegister.addStudent(new Student("Andreea",9));

        studentRegister.writeStudents("students.txt");

        StudentRegister studentReg = new StudentRegister();

        studentReg.readStudents("students.txt");

        System.out.println(studentRegister.getStudenti());

    }
}
