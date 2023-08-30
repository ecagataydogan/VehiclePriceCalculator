package classes;

public class Minivan  extends Automobile{
    private int numberOfSeats;

    public Minivan(String vehicleID, String monthOfSale, String cityOfSale, int productionYear,int numberOfSeats,double engineVolume, int vat) {
        super(vehicleID,monthOfSale,cityOfSale,productionYear,engineVolume,vat);
        this.numberOfSeats = numberOfSeats;

    }

    //SCT value calculation for numberOfSeats.
    private double calculateSctValueForNumberOfSeats() {
        return switch (numberOfSeats) {
            case 4 -> 0.1;
            case 5 -> 0.4;
            case 6 -> 0.6;
            case 7 -> 0.8;
            default -> 0.0;
        };
    }

    //SCT value calculation for Minivan
    @Override
    protected double calculateSctValue() {
        double sctValue;
        double sctValueOfProductionYear = calculateSctValueForProductionYear();
        double sctValueOfEngineVolume = engineVolume;
        double sctValueOfNumberOfSeats = calculateSctValueForNumberOfSeats();
        sctValue = (0.6 * sctValueOfProductionYear) / (sctValueOfEngineVolume + sctValueOfNumberOfSeats);
        return sctValue;
    }

    //Getters for manager.Can be available in the future
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
