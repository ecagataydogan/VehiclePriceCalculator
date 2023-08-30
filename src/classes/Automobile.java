package classes;

public class Automobile extends Vehicle{
    protected double engineVolume;
    public static int BASE_PRICE = 200_000;

    public Automobile(String vehicleID, String monthOfSale, String cityOfSale, int productionYear,double engineVolume,int vat) {
        super(vehicleID,monthOfSale,cityOfSale,productionYear,vat);
        this.engineVolume = engineVolume;
    }

    //Total price calculation for Automobiles. (Hatchback, Sedan, Minivan)
    @Override
    protected double calculateTotalPrice() {
        return BASE_PRICE * (1 + calculateSctValue() * 0.8) + (1 + vat / 100);
    }

    //Getters for manager.Can be available in the future
    public double getEngineVolume() {
        return engineVolume;
    }
}
