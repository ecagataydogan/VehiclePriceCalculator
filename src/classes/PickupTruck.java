package classes;

public class PickupTruck extends Vehicle{
    private String cabType;
    private String truckBedType;
    public static int BASE_PRICE = 250_000;

    public PickupTruck(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, String cabType, String truckBedType, int vat) {
        super(vehicleID,monthOfSale,cityOfSale,productionYear,vat);
        this.cabType = cabType;
        this.truckBedType = truckBedType;
    }

    //SCT value calculations for cabType and truckBedType.
    private double calculateSctValueForCabType() {
        return switch (cabType) {
            case "regular" -> 2.5;
            case "extended" -> 2.8;
            case "crew" -> 3;
            default -> 0.0;
        };
    }

    private double calculateSctValueForTruckBedType() {
        return switch (truckBedType) {
            case "regular" -> 0.5;
            case "tanker" -> 0.8;
            case "trailer" -> 1.0;
            default -> 0.0;
        };
    }

    //SCT calculation for PickUpTruck.
    @Override
    protected double calculateSctValue() {
        double sctValue;
        double sctValueOfTruckBedType = calculateSctValueForTruckBedType();
        double sctValueOfProductionYear = calculateSctValueForProductionYear();
        double sctValueOfCabType = calculateSctValueForCabType();
        sctValue = (sctValueOfTruckBedType * sctValueOfProductionYear) / sctValueOfCabType;
        return sctValue;
    }

    //Total price calculation for PickupTrucks.
    @Override
    protected double calculateTotalPrice() {
        return BASE_PRICE * (1 + (calculateSctValue() * 0.6)) + (1 + vat / 100);
    }

    //Getters for manager.Can be available in the future
    public String getCabType() {
        return cabType;
    }

    public String getTruckBedType() {
        return truckBedType;
    }
}
