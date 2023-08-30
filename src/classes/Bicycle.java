package classes;

public class Bicycle extends Vehicle{
    private String chainType;
    private String seatPost;
    public static int BASE_PRICE = 10_000;

    public Bicycle(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, String chainType, String seatPost,int vat) {
        super(vehicleID,monthOfSale,cityOfSale,productionYear,vat);
        this.chainType = chainType;
        this.seatPost = seatPost;
    }

    //SCT Value calculations for chainType and seatPost.
    private double calculateSctValueForChainType() {
        return switch (chainType) {
            case "derailleur" -> 1.1;
            case "onechain" -> 1.2;
            case "doublechain" -> 1.3;
            default -> 0.0;
        };
    }

    private double calculateSctValueForSeatPost() {
        return switch (seatPost) {
            case "carbonfiber" -> 0.8;
            case "steel" -> 0.7;
            case "aliminum" -> 0.9;
            case "titanium" -> 0.6;
            default -> 0.0;
        };
    }

    //SCT value calculation for Bicycles
    @Override
    protected double calculateSctValue() {
        double sctValue;
        double sctValueOfChainType = calculateSctValueForChainType();
        double sctValueOfSeatPost = calculateSctValueForSeatPost();
        double sctValueOfMonthOfSale = calculateSctValueForMonthOfSale();
        sctValue = (sctValueOfChainType * sctValueOfSeatPost * 0.1) + sctValueOfMonthOfSale;
        return sctValue;
    }

    //Total price calculation for bicycles
    @Override
    protected double calculateTotalPrice() {
        return (BASE_PRICE * 0.9) * (1 + calculateSctValue()) + (1 + vat / 100);
    }

    //Getters for manager.Can be available in the future
    public String getChainType() {
        return chainType;
    }

    public String getSeatPost() {
        return seatPost;
    }
}
