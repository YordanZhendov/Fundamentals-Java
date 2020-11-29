package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] participants = scanner.nextLine().split(", ");
        Map<String, Integer> racers = new LinkedHashMap<>();
        for (int i = 0; i < participants.length; i++) {
            racers.put(participants[i], 0);
        }

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {

            Pattern pattern = Pattern.compile("(?<name>[a-zA-Z]+)|(?<distance>\\d+)");
            Matcher matcher = pattern.matcher(input);

            String name = "";
            String distance = "";
            while (matcher.find()) {
                if (matcher.group("name") != null) {
                    name += matcher.group("name");
                }
                if (matcher.group("distance") != null) {
                    distance += matcher.group("distance");
                }
            }
            if (!racers.containsKey(name)) {
                input = scanner.nextLine();
                continue;
            } else {

                int totalDist = 0;
                char[] di = distance.toCharArray();
                for (int i = 0; i < di.length; i++) {
                    totalDist += Integer.parseInt(String.valueOf(di[i]));

                }

                if (racers.containsKey(name)) {
                    int curr=racers.get(name)+totalDist;
                    racers.put(name,curr);
                }


            }

            input = scanner.nextLine();
        }

        Map<String,Integer> newRacers=new LinkedHashMap<>();

        racers.entrySet()
                .stream()
                .sorted((a,a2)->a2.getValue().compareTo(a.getValue()))
                .forEach(a-> newRacers.put(a.getKey(),a.getValue()));

        int count=0;
        for (Map.Entry<String, Integer> s : newRacers.entrySet()) {
            if(count>2){
                break;
            }
            if(count==0){
                System.out.printf("1st place: %s%n",s.getKey());
            }
            if(count==1){
                System.out.printf("2nd place: %s%n",s.getKey());
            }
            if(count==2){
                System.out.printf("3rd place: %s%n",s.getKey());
            }
            count++;

        }

        System.out.println();

    }
}
