package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() { //метод печатает меню
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() { //метод добавляет блюдо в меню
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addTypes(dishType, dishName);
    }

    private static void generateDishCombo() { //метод для сбора параметров комбо и дальнейшей реализации комбо
        System.out.println("Начинаем конструировать обед...");

        if (dc.checkMenu()) { //если меню пустое, то не стоит и начинать
            System.out.println("Извините, список меню пуст. Добавьте новое блюдо и попробуйте снова.");
        } else {
            System.out.println("Укажите какие типы блюд вы бы хотели видет в комбо.");
            System.out.println("Доступны следующие типы:");
            dc.printTypes(); //тихонечно печатает по-котовски что доступно

            ArrayList<String> typesForCombo = new ArrayList<>(); //создал список ключей, по которым будем генерировать
            String typeForCombo = scanner.nextLine();

            while (!typeForCombo.isEmpty()) {
                if (!dc.checkTypeForCombo(typeForCombo)) {
                    System.out.println("Введенный тип блюда отсутствует в меню, пожалуйста введите из списка:");
                    dc.printTypes();
                    typeForCombo = scanner.nextLine();
                } else {
                    typesForCombo.add(typeForCombo);
                    System.out.println(typeForCombo + " добавлено в комбо. Добавьте еще тип блюда, либо нажмите Enter.");
                    typeForCombo = scanner.nextLine();
                }
            }

            System.out.println("Введите желаемое количество вариантов комбо:");
            int numberOfCombos = scanner.nextInt(); //переменная, отвечает за количество комбинаций (итераций)

            dc.combination(numberOfCombos, typesForCombo); //выше был сбор информации, сейчас реализация
        }
    }
}
