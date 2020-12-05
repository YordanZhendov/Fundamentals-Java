package ExamExercise1;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String read = scanner.nextLine();
        while (!read.equals("Done")) {
            String[] parts = read.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "TakeOdd":
                    char[] letters = input.toCharArray();
                    StringBuilder let = new StringBuilder();
                    for (int i = 0; i < letters.length; i++) {
                        if (i % 2 != 0) {
                            let.append(letters[i]);
                        }
                        input=let.toString();
                    }
                        System.out.println(input);

                    break;
                case "Cut":
                    int startIndex=Integer.parseInt(parts[1]);
                    int lengthIndex=Integer.parseInt(parts[2]);

                    input=input.substring(0,startIndex)+input.substring(startIndex+lengthIndex);
                    System.out.println(input);
                    break;
                case "Substitute":
                    String existingSubstring=parts[1];
                    String toBeReplacedSubstring=parts[2];

                    if(input.contains(existingSubstring)){
                        input=input.replaceAll(existingSubstring,toBeReplacedSubstring);
                        System.out.println(input);
                    }else {
                        System.out.println("Nothing to replace!");
                    }

                    break;

            }
            read = scanner.nextLine();
        }

        System.out.printf("Your password is: %s",input);
    }
}
