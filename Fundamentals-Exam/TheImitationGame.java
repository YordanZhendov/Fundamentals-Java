package ExamExercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String read=scanner.nextLine();
        String encryptedMessage = read;

        read = scanner.nextLine();
        while (!read.equals("Decode")) {
            String[] parts = read.split("\\|");
            String command = parts[0];

            switch (command) {
                case "Move":
                    int nletters=Integer.parseInt(parts[1]);
                    encryptedMessage=encryptedMessage.substring(nletters)+encryptedMessage.substring(0,nletters);

                    break;
                case "Insert":
                    int index=Integer.parseInt(parts[1]);
                    String letter=parts[2];
                    encryptedMessage=encryptedMessage.substring(0,index)+letter+encryptedMessage.substring(index);

                    break;
                case "ChangeAll":
                    String subStr = parts[1];
                    String subReplace = parts[2];
                    while (encryptedMessage.contains(subStr)){
                        encryptedMessage=encryptedMessage.replace(subStr,subReplace);
                    }
                    break;

            }

            read = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s%n",encryptedMessage);


    }
}
