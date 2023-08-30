package vehiclepricemanager;

import java.util.Scanner;

public class VehiclePriceManager {
    private SalesRecord salesRecord = new SalesRecord();
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please press,\n" +
                "1 to see all sold vehicles list\n" +
                "2 to see sold sedan list\n" +
                "3 to see sold hatchback list\n" +
                "4 to see sold minivan list\n" +
                "5 to see sold pickup truck list\n" +
                "6 to see sold bicycle list\n" +
                "Please enter your choice:");
        int input = scanner.nextInt();

        if (input == 1) {
            SalesRecord.printInfo(salesRecord.getAllVehicles());
        } else if(input == 2) {
            SalesRecord.printInfo(salesRecord.getSedanObjects());
        } else if(input == 3) {
            SalesRecord.printInfo(salesRecord.getHatchbackObjects());
        } else if(input == 4) {
            SalesRecord.printInfo(salesRecord.getMinivanObjects());
        }else if (input == 5) {
            SalesRecord.printInfo(salesRecord.getPickupTruckObjects());
        } else if(input == 6) {
            SalesRecord.printInfo(salesRecord.getBicycleObjects());
        }
    }

}
