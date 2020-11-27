package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class SoftUniParking {
    public static void main(String[] args){
        Scanner read=new Scanner(System.in);

        int numberCommands=Integer.parseInt(read.nextLine());
        Map<String,String> register=new LinkedHashMap<>();

        for (int i = 0; i < numberCommands; i++) {
            String[] parts=read.nextLine().split("\\s+");
            String command=parts[0];

            if(command.equals("register")){
                String nameOfThePerson=parts[1];
                String licensePlateNumber=parts[2];
                if(register.containsKey(nameOfThePerson)){
                    System.out.printf("ERROR: already registered with plate number %s%n",register.get(nameOfThePerson));
                }else {
                    register.put(nameOfThePerson,licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n",nameOfThePerson,licensePlateNumber);
                }

            }else if(command.equals("unregister")){
                String nameOfThePerson=parts[1];
                if(!register.containsKey(nameOfThePerson)){
                    System.out.printf("ERROR: user %s not found%n",nameOfThePerson);
                }else {
                    register.remove(nameOfThePerson);
                    System.out.printf("%s unregistered successfully%n",nameOfThePerson);
                }

            }
        }

        for (Map.Entry<String, String> entry : register.entrySet()) {
            System.out.printf("%s => %s%n",entry.getKey(),entry.getValue());
        }


    }
}
