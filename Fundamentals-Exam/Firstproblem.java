import java.util.Scanner;

public class Firstproblem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        String word=input;

        input=scanner.nextLine();
        while (!input.equals("End")){
            String [] parts=input.split("\\s+");
            String command=parts[0];

            switch (command.toLowerCase()){
                case "translate":
                    String chara=parts[1];
                    String replacement=parts[2];
                    word=word.replaceAll(chara,replacement);
                    System.out.println(word);
                    break;
                case "includes":
                    String other=parts[1];
                    if(word.contains(other)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "start":
                    String startString=parts[1];
                    String [] tiles=word.split("\\s+") ;
                    String start=tiles[0];
                    if(start.equals(startString)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "lowercase":
                    word=word.toLowerCase();
                    System.out.println(word);
                    break;
                case "findindex":
                    char index=parts[1].charAt(0);
                    char[] charsWord=word.toCharArray();
                    int lastOne=0;
                    for (int i = 0; i < charsWord.length; i++) {
                        if(charsWord[i]==index){
                            lastOne=i;
                        }
                    }
                    System.out.println(lastOne);
                    break;
                case "remove":
                    int startIndex=Integer.parseInt(parts[1]);
                    int count=Integer.parseInt(parts[2]);
                    int endIndex=startIndex+count;
                    word=word.substring(0,startIndex)+word.substring(endIndex);
                    System.out.println(word);
                    break;
            }
            input=scanner.nextLine();
        }
    }

}
////Thi5 I5 MY 5trING!//
//Translate 5 s
//Includes string
//Start //This
//Lowercase
//FindIndex i
//Remove 0 10
//End
