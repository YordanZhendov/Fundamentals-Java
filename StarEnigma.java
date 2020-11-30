package Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> decoded = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            char[] charParts = input.toCharArray();
            int count = 0;
            for (int j = 0; j < charParts.length; j++) {
                char curr = charParts[j];
                switch (curr) {
                    case 'S':
                    case 'T':
                    case 'A':
                    case 'R':
                    case 's':
                    case 't':
                    case 'a':
                    case 'r':
                        count++;
                        break;
                }
            }
            StringBuilder decodedWord = new StringBuilder();
            for (int j = 0; j < charParts.length; j++) {
                char curr = charParts[j];
                int charNum = (int) (curr) - count;
                char newCurr = (char) charNum;
                decodedWord.append(newCurr);
            }
            decoded.add(decodedWord.toString());
        }

        List<String> planet = new ArrayList<>();
        List<String> attack = new ArrayList<>();
        List<String> destroy = new ArrayList<>();

        for (int i = 0; i < decoded.size(); i++) {
            Pattern pattern = Pattern.compile("@(?<planetname>[A-Za-z]+)[^!@\\-:>]*:(?<stars>\\d+)[^!@\\-:>]*!(?<attack>[A|D])![^!@\\-:>]*->(?<soldier>\\d+)");
            Matcher matcher = pattern.matcher(decoded.get(i));

            if (matcher.find()) {
                String planett=(matcher.group("planetname"));
                String comm=matcher.group("attack");
                if(comm.equals("A")){
                    attack.add(planett);
                }else {
                    destroy.add(planett);
                }

            }

        }
        Collections.sort(attack);
        Collections.sort(destroy);


        System.out.printf("Attacked planets: %d%n",attack.size());
        for (String s : attack) {
            System.out.printf("-> %s%n",s);
        }


        System.out.printf("Destroyed planets: %d%n",destroy.size());
        for (String d : destroy) {
            System.out.printf("-> %s%n",d);
        }

    }
}
