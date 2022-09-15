package db.javaschool.session_2;

public class Main {
    public static void main(String[] args) {
        University univ = new University();

        System.out.println(University.is_higher_education); // true
        System.out.println(univ.is_higher_education); // true - de preferat nu
        univ.setName("ASE");
        System.out.println(univ.getName());
    }

}



