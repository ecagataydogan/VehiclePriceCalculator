package vehiclepricemanager;

import classes.*;
import io.CSVReader;

import java.util.ArrayList;

public class SalesRecord {

    private ArrayList<Vehicle> vehicles;

    public SalesRecord() {
        vehicles = CSVReader.getVehicles("src/csvfiles/HW2_SoldVehicles.csv");
    }

    // Getters for all type of vehicles. These are uses in printInfo() method.
    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public ArrayList<Sedan> getSedanObjects() {
        ArrayList<Sedan> sedans = new ArrayList<>();
        for(int i = 0; i < vehicles.size() ; i++) {
            if(vehicles.get(i).getClass().getSimpleName().equals("Sedan")) {
                sedans.add((Sedan)vehicles.get(i));
            }
        }
        return sedans;
    }

    public ArrayList<Hatchback> getHatchbackObjects() {
        ArrayList<Hatchback> hatchbacks = new ArrayList<>();
        for(int i = 0; i < vehicles.size() ; i++) {
            if(vehicles.get(i).getClass().getSimpleName().equals("Hatchback")) {
                hatchbacks.add((Hatchback) vehicles.get(i));
            }
        }
        return hatchbacks;
    }

    public ArrayList<Minivan> getMinivanObjects() {
        ArrayList<Minivan> minivans = new ArrayList<>();
        for(int i = 0; i < vehicles.size() ; i++) {
            if(vehicles.get(i).getClass().getSimpleName().equals("Minivan")) {
                minivans.add((Minivan)vehicles.get(i));
            }
        }
        return minivans;
    }

    public ArrayList<PickupTruck> getPickupTruckObjects() {
        ArrayList<PickupTruck> pickupTrucks = new ArrayList<>();
        for(int i = 0; i < vehicles.size() ; i++) {
            if(vehicles.get(i).getClass().getSimpleName().equals("PickupTruck")) {
                pickupTrucks.add((PickupTruck) vehicles.get(i));
            }
        }
        return pickupTrucks;
    }

    public ArrayList<Bicycle> getBicycleObjects() {
        ArrayList<Bicycle> bicycles = new ArrayList<>();
        for(int i = 0; i < vehicles.size() ; i++) {
            if(vehicles.get(i).getClass().getSimpleName().equals("Bicycle")) {
                bicycles.add((Bicycle) vehicles.get(i));
            }
        }
        return bicycles;
    }

    //Thanks to polymorphism, the same method is called as long as the type of the ArrayList passed to the method extends the vehicle.
    //We can pass the arraylist of Hatchbacks, Sedans, Minivans, PickupTrucks, Bicycles.
    public static void printInfo (ArrayList<? extends Vehicle> vehicles) {
        for(int i = 0; i < vehicles.size(); i++) {
            //It accesses the overridden toString() method in the vehicle class.
            //All total price calculations are performed differently depending on the type of object.
            System.out.println(vehicles.get(i));
        }
    }


}
