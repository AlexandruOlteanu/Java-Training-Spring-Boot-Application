package db.javaschool.session_4.Problems;


import java.util.List;

public class Shelter {
    private String name;
    private Account account;
    private List<Animal> animals;

    Shelter(String name, Account account, List<Animal> animals) {
        this.name = name;
        this.account = account;
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }


}
