package com.pmart5a;

import com.pmart5a.myclass.Filter;
import com.pmart5a.myclass.Logger;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.log("Запускаем программу");
        try (Scanner scanner = new Scanner(System.in)) {
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.println("Введите размер списка: ");
            int listSize = scanner.nextInt();
            logger.log("Введенное значение (размер списка): " + listSize);
            System.out.println("Введите верхнюю границу для значений: ");
            int upperBoundValues = scanner.nextInt();
            logger.log("Введенное значение (верхняя граница для значений): " + upperBoundValues);
            logger.log("Создаём и наполняем список");
            List<Integer> list = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < listSize; i++) {
                list.add(random.nextInt(upperBoundValues));
            }
            if (list.isEmpty()) {
                System.out.println("Список не сформирован");
                logger.log("Список не сформирован");
            } else {
                System.out.println("Сформированный случайный список: " + list);
                logger.log("Сформированный случайный список: " + list);
            }
            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите порог для фильтра: ");
            int thresholdForFilter = scanner.nextInt();
            logger.log("Введенное значение (порог для фильтра): " + thresholdForFilter);
            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(thresholdForFilter);
            List<Integer> filteredList = filter.filterOut(list);
            logger.log("Выводим результат на экран");
            if (filteredList.isEmpty()) {
                System.out.println("Отфильтрованный список пуст");
                logger.log("Отфильтрованный список пуст");
            } else {
                System.out.println("Отфильтрованный список: " + filteredList);
                logger.log("Отфильтрованный список: " + filteredList);
            }
            logger.log("Завершаем программу");
        } catch (InputMismatchException e) {
            logger.log("Ошибка! Введенное значение не соответсвует типу int или выходит за его границы.");
        }
    }
}