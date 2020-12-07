package ExamExercise1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        Map<String,String> pieceComposer=new TreeMap<>();
        Map<String,String> pieceKey=new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input=scanner.nextLine();
            String [] parts=input.split("\\|");
            String piece=parts[0];
            String composer=parts[1];
            String key=parts[2];

            pieceComposer.put(piece,composer);
            pieceKey.put(piece,key);
        }

        String input=scanner.nextLine();
        while (!input.equals("Stop")){
            String [] parts=input.split("\\|");
            String command=parts[0];

            switch (command){
                case "Add":
                    String piece=parts[1];
                    String composer=parts[2];
                    String key=parts[3];

                    if(pieceComposer.containsKey(piece)){
                        System.out.printf("%s is already in the collection!%n",piece);
                    }else {
                        pieceComposer.put(piece,composer);
                        pieceKey.put(piece,key);
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                    }

                    break;
                case "Remove":
                    String pieceR=parts[1];
                    if(pieceComposer.containsKey(pieceR)){
                        pieceComposer.remove(pieceR);
                        pieceKey.remove(pieceR);
                        System.out.printf("Successfully removed %s!%n",pieceR);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",pieceR);
                    }

                    break;
                case "ChangeKey":
                    String pieceC=parts[1];
                    String newKey=parts[2];

                    if(pieceComposer.containsKey(pieceC)){
                        pieceKey.put(pieceC,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",pieceC,newKey);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",pieceC);
                    }

                    break;

            }
            input=scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : pieceComposer.entrySet()) {
            System.out.printf("%s -> Composer: %s",entry.getKey(),entry.getValue());
            for (Map.Entry<String, String> entryTwo : pieceKey.entrySet()) {
                if(entryTwo.getKey().equals(entry.getKey())){
                    System.out.printf(", Key: %s%n",entryTwo.getValue());
                }

            }

        }

    }
}
