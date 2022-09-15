package db.javaschool.session_4.Problems;

public class Animal<T> implements Comparable<Animal<T>>{

    private String name;
    private double age;
    private double[] foodHistory;
    private boolean isHungry;
    private boolean isThirsty;

    public Animal(String name, double age, double[] foodHistory) {
        this.name = name;
        this.age = age;
        this.foodHistory = foodHistory;
        this.isHungry = false;
        this.isThirsty = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double[] getFoodHistory() {
        return foodHistory;
    }

    public void setFoodHistory(double[] foodHistory) {
        this.foodHistory = foodHistory;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public boolean isThirsty() {
        return isThirsty;
    }

    public void setThirsty(boolean thirsty) {
        isThirsty = thirsty;
    }

    @Override
    public int compareTo(Animal<T> o) {
      return  Double.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return name;
    }
}
