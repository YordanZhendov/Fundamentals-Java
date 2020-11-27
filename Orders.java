package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String,Double> price=new LinkedHashMap<>();
        Map<String,Double> quantity=new LinkedHashMap<>();

        while (!input.equals("buy")){
            String[] parts=input.split("\\s+");
            String product=parts[0];
            double productPrice=Double.parseDouble(parts[1]);
            double productQuantity=Double.parseDouble(parts[2]);

            if(!price.containsKey(product)){
                price.put(product,productPrice);
                quantity.put(product,productQuantity);
            }else {
                double currPrice=productPrice;
                double currQuantity=quantity.get(product)+productQuantity;
                price.put(product,currPrice);
                quantity.put(product,currQuantity);
            }
            input=scanner.nextLine();
        }

        for (String s : quantity.keySet()) {
            if(price.keySet().contains(s)){
                price.put(s,price.get(s)*quantity.get(s));
            }
        }

        for (Map.Entry<String, Double> e : price.entrySet()) {
            System.out.printf("%s -> %.2f%n",e.getKey(),e.getValue());
        }


    }
}
//        Beer 2.20 100
//        IceTea 1.50 50
//        NukaCola 3.30 80
//        Water 1.00 500
//   buy
//        Beer -> 220.00
//        IceTea -> 75.00
//        NukaCola -> 264.00
//        Water -> 500.00