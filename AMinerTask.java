package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String,Integer> gathered=new LinkedHashMap<>();
        while (!input.equals("stop")){
            String resource=input;
            int quantity=Integer.parseInt(scanner.nextLine());

            if(!gathered.containsKey(resource)){
                gathered.put(resource,quantity);
            }else {
                int currQuantity=gathered.get(resource)+quantity;
                gathered.put(resource,currQuantity);
            }
            input=scanner.nextLine();
        }

        for (Map.Entry<String,Integer> entry:gathered.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }


    }
}
