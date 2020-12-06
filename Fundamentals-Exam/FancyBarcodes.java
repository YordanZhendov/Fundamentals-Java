package ExamExercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String read = scanner.nextLine();
            Pattern pattern = Pattern.compile("^(@#+)(?<barcode>[A-Z][a-zA-Z0-9]{4,}[A-Z])(@#+)$");
            Matcher matcher = pattern.matcher(read);

            if (matcher.find()) {
                String product = matcher.group("barcode");
                if (product.length() < 6) {
                    System.out.println("Invalid Product");
                } else {
                    char[] chars = product.toCharArray();
                    String digits = "";
                    for (int j = 0; j < chars.length; j++) {
                        if (Character.isDigit(chars[j])) {
                            digits += chars[j];
                        }
                    }
                    if (digits.equals("")) {
                        digits = "00";
                    }

                    System.out.printf("Product group: %s%n", digits);

                }
            }else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
