package Exercise;

import java.util.*;
import java.util.stream.Stream;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String, List<String>>  book=new TreeMap<>();

        while (!input.equals("Lumpawaroo")){

            if(input.contains("|")){
                String [] parts=input.split("\\|");
                String forceName=parts[1].trim();
                String typeSide=parts[0].trim();

                for (Map.Entry<String, List<String>> entry : book.entrySet()) {
                    entry.getValue().remove(forceName);
                }

                if(!book.containsKey(typeSide)){
                    book.put(typeSide,new ArrayList<>());
                    book.get(typeSide).add(forceName);
                }else {
                    book.get(typeSide).add(forceName);
                }

            }
            if(input.contains("->")){
                String [] parts=input.split("->");
                String forceName=parts[0].trim();
                String typeSide=parts[1].trim();

                for (Map.Entry<String, List<String>> entry : book.entrySet()) {
                    entry.getValue().remove(forceName);
                }


                if(!book.containsKey(typeSide)){
                    book.put(typeSide,new ArrayList<>());
                    book.get(typeSide).add(forceName);
                }else {
                    book.get(typeSide).add(forceName);
                }

                System.out.printf("%s joins the %s side!%n",forceName,typeSide);

            }

            input=scanner.nextLine();
        }

        Map<String,List<String>> sortedBook=new LinkedHashMap<>();
        book.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparingInt(a ->a.getValue().size())))
                .forEachOrdered(x->sortedBook.put(x.getKey(),x.getValue()));



        for (Map.Entry<String, List<String>> entry : sortedBook.entrySet()) {

            if(entry.getValue().size() > 0){
                System.out.printf("Side: %s, Members: %d%n",entry.getKey(),entry.getValue().size());
            }

            entry.getValue().stream().sorted((a1,a2)-> a1.compareTo(a2))
                    .forEachOrdered(a->System.out.printf("! %s%n",a));
        }

    }
}