package ru.practicum.dinner;

import java.util.HashMap; //импортировал HashMap для создания меню, откуда буду брать список блюд на комбо
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    static HashMap<String, ArrayList<String>> menuSet; //наше меню
    ArrayList<String> dishNames = new ArrayList<>(); //список блюд по категориям, находится в меню
    ArrayList<String> dishTypes = new ArrayList<>(); //список категорий блюд, не находится в меню
    ArrayList<String> combo = new ArrayList<>(); //"тело" комбо, то что выведем на печать по итогу

    Random random = new Random();

    DinnerConstructor() {
        menuSet = new HashMap<>();
    }

    void addTypes(String dishType, String dishName) { //метод добавляет в меню тип блюда и его название
        dishNames.add(dishName);
        menuSet.put(dishType, dishNames);
    }

    boolean checkMenu() { //метод проверяет есть ли в меню блюда
        if (menuSet.keySet().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    void printTypes() { //метод печатает из меню типы блюд

        for (String dishType : menuSet.keySet()) {
            dishTypes.add(dishType);
        }
        System.out.println(dishTypes);
    }

    boolean checkTypeForCombo(String typeForCombo) { //метод сравнивает введенные данные с данными из меню
        for (String checkType : menuSet.keySet()) {
            if (checkType.equals(typeForCombo)) {
                return true;
            }
        }
        return false;
    }

    void combination(int numberOfCombos, ArrayList<String> typesForCombo) { //метод генерирует комбо
        for (int i = 0; i < numberOfCombos; i++) { //сколько комбо будет
            System.out.println("Комбо " + (i + 1));

            for (String type : typesForCombo) { //берем ключи из списка typesForCombo
                ArrayList<String> dishesOfType = menuSet.get(type); //и по каждому создаем список с блюдами
                if (dishesOfType != null && !dishesOfType.isEmpty()) { //проверяем список на пригодность
                    /*
                    самая сложная строка: объявляем переменную dish и присваиваем ей значение из списка dishesOfType,
                    в качестве аргумента взял метод nextInt переменной random, а в качестве аргумента nextInt взял
                    длину списка dishesOfType. Таким образом, dish присваивается значение из нужного списка,
                    но значение индекса рандомно
                     */
                    String dish = dishesOfType.get(random.nextInt(dishesOfType.size()));
                    combo.add(dish);

                }
                System.out.println(combo);
                combo.clear();
            }
        }
    }

}