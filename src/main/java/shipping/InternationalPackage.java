package shipping;

public class InternationalPackage implements Transportable{
    private static int NORMAL_PRICE=1200;
    private static int KM_PRICE=10;
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int calculateShippingPrice() {
        int result=NORMAL_PRICE;
        if(breakable){
            result*=2;
        }
        result+=(distance*KM_PRICE);
        return result;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }
}
