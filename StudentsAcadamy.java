package Exercise;

import java.util.*;
import java.util.stream.Collector;

public class StudentsAcadamy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrade = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsGrade.containsKey(name)) {
                studentsGrade.put(name, new ArrayList<>());
                studentsGrade.get(name).add(grade);
            } else {
                studentsGrade.get(name).add(grade);
            }
        }
        Map<String, Double> endGrades = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> e : studentsGrade.entrySet()) {
            double total = 0.0;
            for (int i = 0; i < e.getValue().size(); i++) {
                total += e.getValue().get(i);
            }
            double print = total / e.getValue().size();
            endGrades.put(e.getKey(), print);
        }


        endGrades
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEachOrdered(a-> {
                    if(a.getValue()>=4.50){
                        System.out.printf("%s -> %.2f%n",a.getKey(),a.getValue());
                    }
        });

    }
}
