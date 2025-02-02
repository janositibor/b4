package shipping;

public class NationalPackage implements Transportable{
    private static int NORMAL_PRICE=1000;
    private int weight;
    private boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int calculateShippingPrice() {
        int result=NORMAL_PRICE;
        if(breakable){
            result*=2;
        }
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
}
