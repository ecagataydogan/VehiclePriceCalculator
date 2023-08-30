package io;

import classes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    public static ArrayList<Vehicle> getVehicles(String path) {
        String[] data = readDataFromCsvFile(path);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = null;
        for(int i = 0; i < data.length; i++) {
            String[] vehicleData = data[i].split(",");
            String vehicleID = vehicleData[0];
            String monthOfSale = vehicleData[1];
            String cityOfSale = vehicleData[2];
            int productionYear = Integer.parseInt(vehicleData[3]);
            int vat = Integer.parseInt(vehicleData[6]);
            if (vehicleID.charAt(0) == 'S') {
                String roofType = vehicleData[4];
                double engineVolume = Double.parseDouble(vehicleData[5]);
                vehicle = new Sedan(vehicleID,monthOfSale,cityOfSale,productionYear,roofType,engineVolume,vat);

            } else if (vehicleID.charAt(0) == 'H') {
                String cityMode = vehicleData[4];
                double engineVolume = Double.parseDouble(vehicleData[5]);
                vehicle = new Hatchback(vehicleID,monthOfSale,cityOfSale,productionYear,cityMode,engineVolume,vat);

            } else if (vehicleID.charAt(0) == 'M') {
                int numberOfSeats = Integer.parseInt(vehicleData[4]);
                double engineVolume = Double.parseDouble(vehicleData[5]);
                vehicle = new Minivan(vehicleID,monthOfSale,cityOfSale,productionYear,numberOfSeats,engineVolume,vat);

            } else if (vehicleID.charAt(0) == 'P') {
                String cabType = vehicleData[4];
                String truckBedType = vehicleData[5];
                vehicle = new PickupTruck(vehicleID,monthOfSale,cityOfSale,productionYear,cabType,truckBedType,vat);

            } else if(vehicleID.charAt(0) == 'B') {
                String chainType = vehicleData[4];
                String seatPost = vehicleData[5];
                vehicle = new Bicycle(vehicleID,monthOfSale,cityOfSale,productionYear,chainType,seatPost,vat);
            }

            vehicles.add(vehicle);
        }

        return vehicles;

    }


    //Helper method
    private static String[] readDataFromCsvFile(String path) {
        String[] data = new String[20];
        try{
            Scanner scanner = new Scanner(new File(path));
            int index = 0;

            while(scanner.hasNextLine()) {
                data[index] = scanner.nextLine();
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return data;
    }

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        ArrayList<Vehicle> vehicles = csvReader.getVehicles("src/csvFiles/HW2_SoldVehicles.csv");
        System.out.println(vehicles);
    }

}
