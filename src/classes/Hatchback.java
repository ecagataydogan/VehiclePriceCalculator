package classes;

public class Hatchback extends Automobile{
    private boolean cityMode;

    public Hatchback(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, String cityMode, double engineVolume, int vat) {
        super(vehicleID,monthOfSale,cityOfSale,productionYear,engineVolume,vat);
        this.cityMode = cityMode == "yes" ? true : false;

    }

    //SCT value calculation for cityMode.
    private double calculateSctValueForCityMode() {
        if(cityMode) return 0.15;
        return 0.1;
    }

    //SCT calculation for Hatchback.
    @Override
    protected double calculateSctValue() {
        double sctValue;
        double sctValueOfEngineVolume = engineVolume;
        double sctValueOfProductionYear = calculateSctValueForProductionYear();
        double sctValueOfCityMode = calculateSctValueForCityMode();
        sctValue = (sctValueOfEngineVolume * 0.3 * sctValueOfProductionYear) + sctValueOfCityMode;
        return sctValue;
    }

    //Getters for manager.Can be available in the future
    public boolean isCityMode() {
        return cityMode;
    }
}
