package Exercise;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        Shadowmourne - requires 250 Shards
//        Valanyr - requires 250 Fragments
//        Dragonwrath - requires 250 Motes

//        Shards, Fragments and Motes are KEY MATERIALS

        String input=scanner.nextLine().toLowerCase();
        Map<String, Integer> items=new TreeMap<>();
        items.put("fragments",0);
        items.put("shards",0);
        items.put("motes",0);
        Map<String, Integer> cashItems=new TreeMap<>();
        while (true){
            String [] parts=input.split(" ");
            boolean enough=false;
            for (int i = 0; i < parts.length; i++) {
                int quantity=Integer.parseInt(parts[i]);
                String nameItem=parts[i+1];
                i++;

                if(nameItem.equals("shards") ||
                        nameItem.equals("motes") ||
                        nameItem.equals("fragments")){
                    if(!items.containsKey(nameItem)){
                        items.put(nameItem,quantity);
                    }else {
                        int currQuantity=items.get(nameItem)+quantity;
                        items.put(nameItem,currQuantity);
                    }
                }else {
                    if(!cashItems.containsKey(nameItem)){
                        cashItems.put(nameItem,quantity);
                    }else {
                        int currQuantity=cashItems.get(nameItem)+quantity;
                        cashItems.put(nameItem,currQuantity);
                    }
                }


                for (Map.Entry<String, Integer> entry : items.entrySet()) {
                    if(entry.getKey().equals("fragments") && entry.getValue() >=250) {
                        System.out.println("Valanyr obtained!");
                        int after = items.get("fragments") - 250;
                        items.put("fragments", after);
                        enough=true;
                        break;
                    }else if(entry.getKey().equals("motes") && entry.getValue() >=250){
                        System.out.println("Dragonwrath obtained!");
                        int after=items.get("motes")-250;
                        items.put("motes",after);
                        enough=true;
                        break;
                    }else if(entry.getKey().equals("shards") && entry.getValue() >=250){
                        System.out.println("Shadowmourne obtained!");
                        int after=items.get("shards")-250;
                        items.put("shards",after);
                        enough=true;
                        break;
                    }
                }

                if(enough){
                    break;
                }

            }

            if(enough){
                break;
            }

            input=scanner.nextLine().toLowerCase();
        }
        Map<String,Integer> sortedItems=new LinkedHashMap<>();

        items.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x->sortedItems.put(x.getKey(),x.getValue()));


        for (Map.Entry<String, Integer> entry : sortedItems.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : cashItems.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }

    }
}
