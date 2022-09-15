package db.javaschool.session_5.IO;

import java.io.*;

public class Employee implements Serializable {
    private String name;
    private String position;
    private transient Integer no;
    public Employee(String name, String position, Integer no) {
        this.name = name;
        this.position = position;
        this.no = no;
    }
    public String toString() {
        return name + " " + position + " " + no;
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Marcel", "Manager", 1);
        Employee empRead = null;
        ObjectOutputStream os = null;

        try {
            os = new ObjectOutputStream(new FileOutputStream("out.bin"));
            os.writeObject(emp);
        } catch (IOException e) {
            System.out.println("Could not write to file");
        }

        ObjectInputStream is = null;

        try {
            is = new ObjectInputStream(new FileInputStream("out.bin"));
            empRead = (Employee) is.readObject();
        } catch (IOException e) {
            System.out.println("Could not read from file.");
        } catch (ClassNotFoundException e) {
            System.out.println("Wrong class");
        }

        System.out.println(empRead);

    }
}