package Exercise;

import java.sql.Struct;
import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();

        Map<String, List<String>> accountsCompany=new TreeMap<>();

        while (!input.equals("End")){
            String[] parts=input.split(" -> ");
            String name=parts[0];
            String iD=parts[1];

            if(!accountsCompany.containsKey(name)){
                accountsCompany.put(name,new ArrayList<>());
                accountsCompany.get(name).add(iD);
            }else {
                if(!accountsCompany.get(name).contains(iD)){
                    accountsCompany.get(name).add(iD);
                }
            }
            input=scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : accountsCompany.entrySet()) {
            System.out.println(String.join("",entry.getKey()));
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n",entry.getValue().get(i));

            }
        }


    }
}
//          SoftUni -> AA12345
//        SoftUni -> BB12345
//        Microsoft -> CC12345
//        HP -> BB12345
//        End
////////////////////
//        HP
//        -- BB12345
//        Microsoft
//        -- CC12345
//        SoftUni
//        -- AA12345
//        -- BB12345
