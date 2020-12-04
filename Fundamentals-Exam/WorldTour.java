package ExamExercise1;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();

        String read=scanner.nextLine();
        while (!read.equals("Travel")){
            String [] parts=read.split(":");
            String command=parts[0];

            if(command.equals("Add Stop")){
                int atIndex=Integer.parseInt(parts[1]);
                String toBeAdded=parts[2];
                if(atIndex>=0 && atIndex<input.length()){
                    input=input.substring(0,atIndex)+toBeAdded+input.substring(atIndex);
                }

                System.out.println(input);

            }else if(command.equals("Remove Stop")){
                int atIndex=Integer.parseInt(parts[1]);
                int endIndex=Integer.parseInt(parts[2]);
                if(atIndex>=0 && atIndex<input.length() && endIndex>=0 && endIndex<input.length()){
                    input=input.substring(0,atIndex)+input.substring(endIndex+1);
                }

                System.out.println(input);
            }else if(command.equals("Switch")){
                String oldSt=parts[1];
                String newSt=parts[2];
                input=input.replace(oldSt,newSt);

                System.out.println(input);
            }

            read=scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s",input);
    }
}
