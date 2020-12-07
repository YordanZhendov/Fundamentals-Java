package ExamExercise1;

import com.sun.tools.javac.Main;

import java.util.*;
import java.util.stream.Collectors;

public class HeroesOfCodeandLogicVII {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        Map<String,Integer> hitHero=new LinkedHashMap<>();
        Map<String,Integer> manaHero=new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input=scanner.nextLine();
            String [] parts=input.split("\\s+");
            String nameOfHero=parts[0];
            int hitPoints=Integer.parseInt(parts[1]);
            int manaPoints=Integer.parseInt(parts[2]);

            if(hitPoints > 100){
                hitPoints=100;
            }
            if(manaPoints>200){
                manaPoints=200;
            }

            hitHero.put(nameOfHero,hitPoints);
            manaHero.put(nameOfHero,manaPoints);

        }

        String read=scanner.nextLine();
        while (!read.equals("End")){
            String[] all=read.split(" - ");
            String command=all[0];

            switch (command){
                case "CastSpell":
                    String nameHero=all[1];
                    int neededMana=Integer.parseInt(all[2]);
                    String spellName=all[3];

                    if(manaHero.get(nameHero)>=neededMana){
                        int currMana=manaHero.get(nameHero)-neededMana;
                        manaHero.put(nameHero,currMana);
                        int restMana=manaHero.get(nameHero);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",nameHero,spellName,restMana);
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!%n",nameHero,spellName);
                    }

                    break;
                case "TakeDamage":
                    String nameH=all[1];
                    int damage=Integer.parseInt(all[2]);
                    String attacker=all[3];

                    int leftHealth=hitHero.get(nameH)-damage;
                    if (leftHealth > 0) {
                        hitHero.put(nameH,leftHealth);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",nameH,damage,attacker,leftHealth);
                    }else {
                        hitHero.remove(nameH);
                        manaHero.remove(nameH);
                        System.out.printf("%s has been killed by %s!%n",nameH,attacker);
                    }

                    break;
                case "Recharge":
                    String nameHe=all[1];
                    int rechargeAmount=Integer.parseInt(all[2]);

                    int endMana=manaHero.get(nameHe)+rechargeAmount;
                    if(endMana>200){
                        int overMana=endMana-200;
                        int takenMana=Math.abs(rechargeAmount-overMana);
                        manaHero.put(nameHe,200);
                        System.out.printf("%s recharged for %d MP!%n",nameHe,takenMana);
                    }else {
                        manaHero.put(nameHe,endMana);
                        System.out.printf("%s recharged for %d MP!%n",nameHe,rechargeAmount);
                    }

                    break;
                case "Heal":
                    String nameHer=all[1];
                    int healthRechargeAmount=Integer.parseInt(all[2]);
                    int endHealthRecharge=hitHero.get(nameHer)+healthRechargeAmount;

                    if(endHealthRecharge>100){
                        int overHealth=endHealthRecharge-100;
                        int takenHealth=Math.abs(healthRechargeAmount-overHealth);
                        hitHero.put(nameHer,100);
                        System.out.printf("%s healed for %d HP!%n",nameHer,takenHealth);
                    }else {
                        hitHero.put(nameHer,endHealthRecharge);
                        System.out.printf("%s healed for %d HP!%n",nameHer,healthRechargeAmount);
                    }
                    break;
            }

            read=scanner.nextLine();
        }

        Map<String,Integer> newMap=new LinkedHashMap<>();
        hitHero.entrySet()
                .stream()
                .sorted((a,b)->{
                    int result=b.getValue()-a.getValue();
                    if(result==0){
                        result=a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(e-> newMap.put(e.getKey(),e.getValue()));

        for (Map.Entry<String, Integer> entry : newMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.printf("  HP: %d%n",entry.getValue());
            for (Map.Entry<String, Integer> e : manaHero.entrySet()) {
                if(e.getKey().equals(entry.getKey())){
                    System.out.printf("  MP: %d%n",e.getValue());
                }
            }
        }

        System.out.println();
    }
}



