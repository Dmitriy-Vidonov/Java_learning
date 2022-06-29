package BuildUtils;

public class FindPrice {
    public static double priceIs(double length, double height, double pricePerSquareMeter){
        return  (FindArea.areaIs(length, height)) / 100 * pricePerSquareMeter;
    }
}
