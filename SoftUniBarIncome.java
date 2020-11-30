package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        List<String> nameOfCustomer=new ArrayList<>();
        List<String> productName=new ArrayList<>();
        List<Integer> quantityOfProduct=new ArrayList<>();
        List<Double> priceOfTheProduct=new ArrayList<>();

        while (!input.equals("end of shift")){
            Pattern pattern=Pattern.compile("^%(?<name>[A-Z][a-z]+)%[^%$.|]*<(?<product>\\w+)>[^%$.|]*?\\|(?<quantity>[0-9]+)\\|[^%$.|]*?(?<price>\\d+\\.*\\d*)\\$$");
            Matcher matcher=pattern.matcher(input);

            if(matcher.find()){
                nameOfCustomer.add(matcher.group("name"));
                productName.add(matcher.group("product"));
                quantityOfProduct.add(Integer.parseInt(matcher.group("quantity")));
                priceOfTheProduct.add(Double.parseDouble(matcher.group("price")));
            }
            input=scanner.nextLine();
        }

        double totalSum=0.0;
        for (int i= 0; i < nameOfCustomer.size(); i++) {
            double currPrice=priceOfTheProduct.get(i)*quantityOfProduct.get(i);
            totalSum+=currPrice;
            System.out.printf("%s: %s - %.2f%n",nameOfCustomer.get(i),productName.get(i),currPrice);
        }
        System.out.printf("Total income: %.2f%n",totalSum);


    }
}
//%(?<name>[a-zA-Z]+)%<(?<product>[a-zA-z]+)>\|(?<quantity>\d+)\|(?<price>\d+\.\d*)\$