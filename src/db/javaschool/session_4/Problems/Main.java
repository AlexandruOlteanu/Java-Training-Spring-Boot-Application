package db.javaschool.session_4.Problems;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Dog> animals = new LinkedList<>();
        animals.add(new Dog("dog1", 12, new double[]{3, 5.6, 8.1}));
        animals.add(new Dog("dog2", 7, new double[]{24}));
        animals.add(new Dog("dog3", 1, new double[]{41, 6.2}));
        animals.add(new Dog("dog4", 5, new double[]{3, 5.6, 4.3, 4.9}));


        Set<Animal> animalSet = new TreeSet<Animal>();
        animalSet.addAll(animals);

        for (Animal animal : animalSet) {
            System.out.println(animal);
        }
        Account account = new Account(1, "Ro123456677", Currency.USD, 10.00, new Date(), 20);
        DogShelter<Dog> dogShelter = new DogShelter<>("Happy Paws", account, animals, "Marcel");
        dogShelter.addAnimal(new Dog("Bobita", 3, new double[]{2.4, 1, 6.54}));

        System.out.println(dogShelter);
    }

}
