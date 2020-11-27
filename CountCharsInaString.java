package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInaString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] input=scanner.nextLine().split("");
        Map<String,Integer> letters=new LinkedHashMap<>();

        for (String s : input) {
            if (s.equals(" ")) {
                continue;
            }
            if(!letters.containsKey(s)){
                letters.put(s,1);
            }else {
                int count=letters.get(s)+1;
                letters.put(s,count);
            }
        }

        for (Map.Entry<String,Integer> entry:letters.entrySet()){
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
