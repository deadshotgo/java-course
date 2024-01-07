package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choose;
            menuBar();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    actionUser(scanner);
                    break;
                case 0:
                    System.out.println("Дякую за використання нашого сервісу");
                    scanner.close();
                    System.exit(0);
                    break;
            }

        }
    }

    public static boolean isPalindrome(String words) {

        words = words.replaceAll("\\s+", "").toLowerCase();

        int leftIndex = 0;
        int rightIndex = words.length() - 1;

        while (leftIndex < rightIndex) {
            if (words.charAt(leftIndex) != words.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    private static void actionUser(Scanner scanner) {
        System.out.println("Введіть слово котре бажаєте перевірити на паліндром: ");
        String words = scanner.nextLine().toLowerCase();

        if (isPalindrome(words))
            System.out.println(words + " слово є паліндромом.");
         else
            System.out.println(words + " слово не є паліндромом.");
    }

    private static void menuBar() {
        System.out.println("Обери дію:");
        System.out.println("1. Перевірка на паліндром");
        System.out.println("0. Вихід");
    }
}