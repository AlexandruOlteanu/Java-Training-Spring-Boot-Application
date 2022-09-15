package db.javaschool.session_2.Problems;

public class Generalist extends Doctor implements Comparable<Generalist> {

    private int noPatients;

    public Generalist(int noPatients) {
        super();
        this.noPatients = noPatients;
    }

    public Generalist(String name, int noPatients) {
        super(name);
        this.noPatients = noPatients;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.noPatients;
    }

    public void writeRecipe(String recipe){
        System.out.println(recipe);
    }


    @Override
    public int compareTo(Generalist o) {
        return Integer.compare(noPatients, o.noPatients);
    }

    public int getNoPatients() {
        return noPatients;
    }
}
