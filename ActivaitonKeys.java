package ExamFinalExercise;

import java.util.Scanner;

public class ActivaitonKeys {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String activationKey=scanner.nextLine();

        String input=scanner.nextLine();

        while (!input.equals("Generate")){
            String [] parts=input.split(">>>");
            String command=parts[0];

            if(command.equals("Slice")){
                int startInd=Integer.parseInt(parts[1]);
                int endInd=Integer.parseInt(parts[2]);
                String party=activationKey.substring(startInd,endInd);
                activationKey=activationKey.replaceAll(party,"");

                System.out.println(activationKey);

            }
            if(command.equals("Flip")){
                String upOrLow=parts[1];

                if(upOrLow.equals("Upper")){
                    int startInd=Integer.parseInt(parts[2]);
                    int endInd=Integer.parseInt(parts[3]);
                    activationKey=activationKey.substring(0,startInd)+
                            activationKey.substring(startInd,endInd).toUpperCase()+activationKey.substring(endInd);

                    System.out.println(activationKey);

                }

                if(upOrLow.equals("Lower")){
                    int startInd=Integer.parseInt(parts[2]);
                    int endInd=Integer.parseInt(parts[3]);
                    activationKey=activationKey.substring(0,startInd)+
                            activationKey.substring(startInd,endInd).toLowerCase()+activationKey.substring(endInd);
                    System.out.println(activationKey);

                }

            }
            if(command.equals("Contains")){
                String subString=parts[1];
                if(activationKey.contains(subString)){
                    System.out.printf("%s contains %s%n",activationKey,subString);
                }else {
                    System.out.println("Substring not found!");
                }
            }

            input=scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s%n",activationKey);

    }
}