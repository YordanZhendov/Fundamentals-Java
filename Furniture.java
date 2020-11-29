package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();

        List<String> products=new ArrayList<>();
        List<String> prices=new ArrayList<>();
        List<String> quantity=new ArrayList<>();

        while (!input.equals("Purchase")){


            Pattern pattern=Pattern.compile(">>(?<name>[A-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>[0-9]+)");
            Matcher matcher=pattern.matcher(input);

            while (matcher.find()){
                products.add(matcher.group("name"));
                quantity.add(matcher.group("quantity"));
                prices.add(matcher.group("price"));

            }

            input=scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String product : products) {
                System.out.println(product);
        }

        double totalPrice=0.0;
        for (int i = 0; i < prices.size(); i++) {
            double price=Double.parseDouble(prices.get(i));
            double quant=Double.parseDouble(quantity.get(i));
            totalPrice+=price*quant;
        }
        System.out.printf("Total money spend: %.2f",totalPrice);

    }
}
