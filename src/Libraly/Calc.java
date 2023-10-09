package Libraly;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем словарь для соответствия римских чисел арабским
        Map<Character, Integer> romanToArabic = new HashMap<>();
        romanToArabic.put('I', 1);
        romanToArabic.put('V', 5);
        romanToArabic.put('X', 10);
        romanToArabic.put('L', 50);
        romanToArabic.put('C', 100);

        System.out.println("Введите выражение (например, 2 + 3 или IV - II):");
        String input = scanner.nextLine();

        // Разделяем введенную строку на операнды и операцию
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            System.out.println("Ошибка: некорректный формат выражения.");
            return;
        }

        String operand1 = parts[0];
        String operator = parts[1];
        String operand2 = parts[2];

        // Проверяем, являются ли операнды арабскими числами
        boolean isArabic = operand1.matches("\\d+") && operand2.matches("\\d+");

        // Проверяем, являются ли операнды римскими числами
        boolean isRoman = operand1.matches("[IVXLCDM]+") && operand2.matches("[IVXLCDM]+");

        if (!isArabic && !isRoman) {
            System.out.println("Ошибка: неподдерживаемый формат чисел.");
            return;
        }

        int num1, num2;
        if (isArabic) {
            num1 = Integer.parseInt(operand1);
            num2 = Integer.parseInt(operand2);
        } else {
            num1 = romanToArabic(operand1, romanToArabic);
            num2 = romanToArabic(operand2, romanToArabic);
        }

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Ошибка: неподдерживаемая операция.");
                return;
        }

        String output;
        if (isArabic) {
            output = String.valueOf(result);
        } else {
            output = arabicToRoman(result);
        }

        System.out.println("Результат: " + output);
    }

    // Метод для преобразования римского числа в арабское
    private static int romanToArabic(String roman, Map<Character, Integer> romanToArabic) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            int value = romanToArabic.get(c);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
                prevValue = value;
            }
        }

        return result;
    }

    // Метод для преобразования арабского числа в римское
    private static String arabicToRoman(int number) {
        StringBuilder roman = new StringBuilder();

        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(symbols[i]);
                number -= values[i];
            }
        }

        return roman.toString();
    }
}
    //работы калькулятора с арабскими числами могут быть отрицательные числа и ноль. Результатом работы калькулятора с римскими числами могут быть только положительные числа, если результат работы меньше единицы, программа должна указать на исключение.