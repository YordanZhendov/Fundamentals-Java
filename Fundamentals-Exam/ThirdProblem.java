import java.util.*;

public class ThirdProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<String>> guests = new LinkedHashMap<>();
        int countUnlike = 0;

        while (!input.equals("Stop")) {
            String[] parts = input.split("-");
            String command = parts[0];
            String guest = "";
            String meal = "";
            switch (command) {
                case "Like":
                    guest = parts[1];
                    meal = parts[2];

                    if (!guests.containsKey(guest)) {
                        guests.put(guest, new ArrayList<>());
                        guests.get(guest).add(meal);
                    } else {
                        if (guests.get(guest).contains(meal)) {
                            break;
                        } else {
                            guests.get(guest).add(meal);
                        }
                    }


                    break;
                case "Unlike":
                    guest = parts[1];
                    meal = parts[2];
                    if (!guests.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else if (!guests.get(guest).contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    } else {
                        guests.get(guest).remove(meal);
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                        countUnlike++;
                    }

                    break;
            }
            input = scanner.nextLine();
        }

        Map<String, List<String>> guestsOrdered = new LinkedHashMap<>();
        guests.entrySet().stream()
                .sorted((a, b) -> {
                    int aMeals = a.getValue().size();
                    int bMeals = b.getValue().size();

                    if (aMeals != bMeals) {
                        return Integer.compare(bMeals, aMeals);
                    } else {
                        return a.getKey().compareTo(b.getKey());
                    }

                })
                .forEach(a -> guestsOrdered.put(a.getKey(), a.getValue()));

        for (Map.Entry<String, List<String>> entry : guestsOrdered.entrySet()) {
            if (entry.getValue().size() == 0) {
                System.out.printf("%s:", entry.getKey());

            } else {
                System.out.printf("%s: ", entry.getKey());
                System.out.printf(String.join(", ", entry.getValue()));
            }
            System.out.println();
        }
        System.out.printf("Unliked meals: %d", countUnlike);

    }
}
