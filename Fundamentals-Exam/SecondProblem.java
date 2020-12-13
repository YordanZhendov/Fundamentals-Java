import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondProblem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        List<String> numbers=new ArrayList<>();
        List<Integer> endNum=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input=scanner.nextLine();
            Pattern pattern=Pattern.compile("^([$%])(?<tag>[A-Z]{1,}[a-z]{2,})\\1:\\s((?<groups>[\\[][0-9]+[\\]])\\|(?<groups2>[\\[][0-9]+[\\]])\\|(?<groups3>[\\[][0-9]+[\\]])\\|)$");
            Matcher matcher=pattern.matcher(input);
            String tag="";

            if(matcher.find()){
                numbers.add(matcher.group("groups"));
                numbers.add(matcher.group("groups2"));
                numbers.add(matcher.group("groups3"));
                tag=matcher.group("tag");

                for (int j = 0; j < numbers.size(); j++) {
                    pattern=Pattern.compile("(?<num>\\d+)");
                    matcher=pattern.matcher(numbers.get(j));

                    if(matcher.find()){
                        endNum.add(Integer.parseInt(matcher.group("num")));
                    }
                }
               StringBuilder message=new StringBuilder();
                for (int j = 0; j < endNum.size(); j++) {
                    int e=endNum.get(j);
                    char curr = (char) e;
                    message.append(curr);
                }

                System.out.printf("%s: %s%n",tag,message.toString());
                numbers.clear();
                endNum.clear();
            }else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
