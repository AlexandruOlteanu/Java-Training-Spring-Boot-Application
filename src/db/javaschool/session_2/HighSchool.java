package db.javaschool.session_2;

public class HighSchool extends EducationSystem { // IS-A
    static boolean is_higher_education = false;

    public String getEducationSystem() {
        return this.system_name;
    }
}
