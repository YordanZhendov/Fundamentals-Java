package Exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args){
        Scanner read=new Scanner(System.in);

        Map<String, List<String>> catalogNumbers=new LinkedHashMap<>();

        String input=read.nextLine();

        while (!input.equals("end")){
            String[] parts=input.split(" : ");
            String courseName=parts[0];
            String nameStudents=parts[1];

            if(!catalogNumbers.containsKey(courseName)){
                catalogNumbers.put(courseName,new LinkedList<>());
                catalogNumbers.get(courseName).add(nameStudents);
            }else {
                catalogNumbers.get(courseName).add(nameStudents);
            }

            input=read.nextLine();
        }
        Map<String, List<String>> sortedCatalog=new LinkedHashMap<>();

        catalogNumbers.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparingInt(a ->a.getValue().size())))
                .forEachOrdered(x->sortedCatalog.put(x.getKey(),x.getValue()));

        for (Map.Entry<String, List<String>> course : sortedCatalog.entrySet()) {
            System.out.printf("%s: %d%n",course.getKey(),course.getValue().size());

            List<String> sortedNames=new ArrayList<>();
            for (int i = 0; i < course.getValue().size(); i++) {
                sortedNames.add(course.getValue().get(i));
            }
            Collections.sort(sortedNames);
            for (int i = 0; i < sortedNames.size(); i++) {
                System.out.printf("-- %s%n",sortedNames.get(i));

            }


        }

        System.out.println();
    }
}
