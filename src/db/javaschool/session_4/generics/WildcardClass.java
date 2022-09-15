package db.javaschool.session_4.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardClass<T extends Vehicle>{
    ArrayList<Vehicle> array;
    private int x;
    WildcardClass() {
        array = new ArrayList<>();
    }

    public void addVehicles(List<T> vehicles) {
        array.addAll(vehicles);
    }


    public static void main(String[] args) {
        WildcardClass<ElectricVehicle> wildcard = new WildcardClass<>();
        ArrayList<ElectricVehicle> vehicles = new ArrayList<>();
        vehicles.add(new ElectricVehicle());
        vehicles.add(new ElectricVehicle());
        vehicles.add(new ElectricVehicle());

        wildcard.addVehicles(vehicles);
    }
}
