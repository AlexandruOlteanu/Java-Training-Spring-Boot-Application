package db.javaschool.session_2.Problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Doctor[] doctors = new Doctor[]{
                new Surgeon("Gigel"),
                new Generalist("Ionel", 120),
                new Surgeon("Mihai", "cardiolog"),
                new Generalist("Andrei", 134),
                new Surgeon("Ana", "cardiolog"),

        };

        for (int i = 0; i < doctors.length; i++) {
            System.out.println(doctors[i]);
            if (doctors[i] instanceof Generalist) {
                ((Generalist) doctors[i]).writeRecipe("Algocalmin");
            } else if (doctors[i] instanceof Surgeon) {
                ((Surgeon) doctors[i]).intervention();
            }
        }
        boolean gasit = false;
        for (int i = 0; i < doctors.length; i++) {
            if (doctors[i] instanceof Surgeon) {
                for (int j = 0; j < doctors.length; j++) {
                    if (doctors[j] instanceof Surgeon
                            && ((Surgeon) doctors[i]).getExpertise() != null
                            && ((Surgeon) doctors[i]).getExpertise().equals(((Surgeon) doctors[j]).getExpertise())
                            && i != j) {

                        gasit = true;
                    }

                }
            }
        }
        if (gasit) {
            System.out.println("2 doctori cu aceeasi expertiza");
        }

        Generalist[] generalists = new Generalist[]{
                new Generalist("Adi", 10),
                new Generalist("Andrei", 14),
                new Generalist("Ionel", 8)
        };

        Arrays.sort(generalists);
        for(Generalist generalist : generalists) {
            System.out.println(generalist);
        }

        double medie = 0;
        for(int i = 0; i < generalists.length; i++) {
            medie += generalists[i].getNoPatients();
        }

        medie = medie / generalists.length;

        int nr = 0;
        for(int i = 0; i < generalists.length; i++) {
            if(generalists[i].getNoPatients() > medie) {
                nr++;
            }
        }
        System.out.println("Number of generalists: " + nr);
    }
}
