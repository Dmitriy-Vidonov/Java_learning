import java.util.Scanner;
import BuildUtils.FindArea;
import BuildUtils.FindPrice;

public class WallPrice {
    public static void main(String[] args) {
        System.out.println("Введите высоту стены в см: ");
        Scanner in = new Scanner(System.in);
        double height = in.nextDouble();

        System.out.println("Введите длину стены в см:");
        double length = in.nextDouble();

        System.out.println("Введите стоимость материала за квадрат, руб.:");
        double price = in.nextDouble();

        System.out.println("Общая площадь стены равна - " + FindArea.areaIs(length, height) + " см.");
        System.out.println("Стоимость стены итого: " + FindPrice.priceIs(length, height, price) + " руб.");
    }
    
}
