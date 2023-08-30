package classes;

public class Sedan extends Automobile{
    private String roofType;

    public Sedan(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, String roofType,double engineVolume ,int vat) {
        super(vehicleID,monthOfSale,cityOfSale,productionYear,engineVolume,vat);
        this.roofType = roofType;

    }

    //SCT value calculation for roofType.
    private double calculateSctValueForRoofType() {
        return switch (roofType) {
            case "regular" -> 0.5;
            case "moonroof" -> 0.6;
            case "sunroof" -> 0.8;
            default -> 0.0;
        };
    }

    //SCT value calculation for Sedan.
    @Override
    protected double calculateSctValue() {
        double sctValue;
        double sctValueOfEngineVolume = engineVolume;
        double sctValueOfRoofType = calculateSctValueForRoofType();
        double sctValueForProductionYear = calculateSctValueForProductionYear();
        sctValue = (sctValueOfEngineVolume * 0.2 * sctValueOfRoofType) / sctValueForProductionYear;
        return sctValue;
    }

    //Getters for manager.Can be available in the future
    public String getRoofType() {
        return roofType;
    }
}
