package javafullcourse;
import java.util.Scanner;

public class shoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String item;
        double priceItem;
        int itemQuant;
        char curr = '$';
        double total;

        System.out.print("enter the name of the item: ");
        item = scanner.nextLine();
        System.out.print("enter the price of the item: ");
        priceItem = scanner.nextDouble();
        System.out.print("enter the number of items you want to buy: ");
        itemQuant = scanner.nextInt();
        total = priceItem * itemQuant;
        System.out.println("You bought " + itemQuant +" "+ item +"/s");
        System.out.println("It will cost you " + total + curr);

        scanner.close();

    }

}
