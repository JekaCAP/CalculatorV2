package Libraly;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");

        int choice = scanner.nextInt();

        double a, b;
        if (choice == 1) {
            System.out.println("Введите два числа для сложения:");
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            double sum = a + b;
            System.out.println("Сумма: " + sum);
        } else if (choice == 2) {
            System.out.println("Введите два числа для вычитания:");
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            double difference = a - b;
            System.out.println("Разность: " + difference);
        } else if (choice == 3) {
            System.out.println("Введите два числа для умножения:");
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            double multiplication = a * b;
            System.out.println("Умножение: " + multiplication);
        } else if (choice == 4) {
            System.out.println("Введите два числа для деления:");
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            double division = a / b;
            System.out.println("Деление: " + division);
        } else {
            System.out.println("Некорректный выбор операции.");
        }

        scanner.close();
    }
}
