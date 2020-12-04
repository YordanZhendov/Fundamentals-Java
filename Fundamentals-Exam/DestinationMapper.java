package ExamExercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();

        Pattern pattern=Pattern.compile("(?<sign>[=\\/])(?<location>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher=pattern.matcher(input);

        List<String> locations=new ArrayList<>();

        while (matcher.find()){
            locations.add(matcher.group("location"));
        }

        int travelPoints=0;
        for (int i = 0; i < locations.size(); i++) {
            travelPoints+=locations.get(i).length();
        }

        System.out.print("Destinations: ");
        System.out.print(String.join(", ",locations));
        System.out.println();
        System.out.printf("Travel Points: %d%n",travelPoints);

    }
}