package db.javaschool.session_4.Problems;

import java.util.ArrayList;
import java.util.List;

public class DogShelter<T extends Dog> extends Shelter implements IShelter {
    private String owner;

    DogShelter(String name, Account account, List<T> animals, String owner) {
        super(name, account, new ArrayList<Animal>());
        this.owner = owner;
        for (T animal : animals) {
            addAnimal(animal);
        }
    }

    @Override
    public String toString() {
        String text = "";
        text += "Cainii prezenti in "  + this.getName() + " dragut:";
        for (Animal dog: getAnimals()){
            text += dog + "\n";
        }
        return text;
    }

    @Override
    public float getLatitude() {
        return 45.67f;
    }

    @Override
    public float getLongitude() {
        return 90.43f;
    }

    @Override
    public String getOwner() {
        return this.owner;
    }

    @Override
    public void receiveDonation(double value) {
        this.getAccount().setAmount(this.getAccount().getAmount() + value);
    }

    @Override
    public void spend(double value, String reason) {
        this.getAccount().setAmount(this.getAccount().getAmount() - value);
    }


    public void addAnimal(T animal) {
        super.addAnimal(animal);
    }
}
