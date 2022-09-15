package db.javaschool.session_2.Problems;

public class Doctor {

    protected String name = "NO NAME";

    public Doctor() {
        this.name = "NO NAME";
    }

    public Doctor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
