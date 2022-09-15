package db.javaschool.session_5.IO;

import java.io.*;
import java.util.Scanner;

public class ExampleFile {
    public static void main(String[] args) {
        File f = new File("test.txt");

        System.out.println(f.exists());
        System.out.println(f.length());
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.isAbsolute());
        System.out.println(f.isHidden());
        System.out.println(f.getAbsolutePath());

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(f);
            pw.print("Hello, World!");
            pw.println(2022);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }

        try {
//            Scanner s = new Scanner(System.in);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream("test.dat");
            for (int i = 1; i <= 50; i++) {
                out.write(i);
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        } catch (IOException e) {
            System.out.println("Could not write to the file.");
        }

        FileInputStream in = null;
        try {
            in = new FileInputStream("test.dat");
            int x;
            while ((x = in.read()) != -1) {
                System.out.print(x + " ");
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        } catch (IOException e) {
            System.out.println("Could not read from the file.");
        }
    }
}
