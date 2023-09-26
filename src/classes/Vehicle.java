package classes;

import java.text.DecimalFormat;

public abstract class Vehicle {
    public final String vehicleID;
    protected String monthOfSale;
    protected String cityOfSale;
    protected int productionYear;
    protected int vat;

    public Vehicle(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, int vat) {
        this.vehicleID = vehicleID;
        this.monthOfSale = monthOfSale;
        this.cityOfSale = cityOfSale;
        this.productionYear = productionYear;
        this.vat = vat;

    }

    //SCT Value calculations for inherited fields
    protected double calculateSctValueForMonthOfSale() {
        return switch (monthOfSale) {
            case "January" -> 0.3;
            case "May" -> 0.4;
            case "August" -> 0.5;
            case "October" -> 0.6;
            case "December" -> 0.7;
            default -> 0.0;
        };
    }

    protected double calculateSctValueForCityOfSale() {
        return switch (cityOfSale) {
            case "Izmir" -> 0.3;
            case "Istanbul" -> 0.4;
            case "Ankara" -> 0.5;
            default -> 0.0;
        };
    }

    protected double calculateSctValueForProductionYear() {
        double sctValueForProductionYear = 0;
        if(productionYear >= 2001 && productionYear <= 2008) {
            sctValueForProductionYear = 1.0;
        } else if (productionYear >= 2012 && productionYear <= 2017) {
            sctValueForProductionYear = 1.2;
        } else if (productionYear >= 2018 && productionYear <= 2022) {
            sctValueForProductionYear = 1.6;
        }
        return sctValueForProductionYear;
    }

    //Dummy SCT value for overriding. There are five different calculation for SCT value.
    //Method will override for Hatchback, Sedan, Minivan, PickupTruck, Bicycle
    protected abstract double calculateSctValue();

    // Dummy total price calculation for overriding. There are three different calculation for total price.
    //Method will override for Automobile, PickupTruck, Bicycle
    protected abstract double calculateTotalPrice();

    @Override
    public String toString() {
        return "Vehicle: " +
                getClass().getSimpleName() + " "+
                "Vehicle ID: '" + vehicleID + '\'' +
                ", Month: '" + monthOfSale + '\'' +
                ", City: '" + cityOfSale + '\'' +
                ", Production Year: " + productionYear +
                " SCT: " + new DecimalFormat("0.00").format(calculateSctValue()) + "\n" +
                "The total price paid for " + vehicleID + " is " + (int) calculateTotalPrice();
    }

    //Getters for manager. Can be available in the future
    public String getVehicleID() {
        return vehicleID;
    }

    public String getMonthOfSale() {
        return monthOfSale;
    }

    public String getCityOfSale() {
        return cityOfSale;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public int getVat() {
        return vat;
    }
}
