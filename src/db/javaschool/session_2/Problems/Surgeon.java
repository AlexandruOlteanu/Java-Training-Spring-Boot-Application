package db.javaschool.session_2.Problems;

public class Surgeon extends Doctor {

    private String expertise;

    public Surgeon() {
        super();
    }

    public Surgeon(String name) {
        super(name);
    }

    public Surgeon(String name, String expertise) {
        super(name);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return this.expertise;
    }

    @Override
    public String toString() {
        return this.name + " " + expertise;
    }

    public void intervention() {
        System.out.println("A avut loc o interventie.");
    }
}
