package part1.lesson02.task03;

import part1.lesson02.task03.exception.DubNameAgeException;

import java.util.ArrayList;
import java.util.Date;

/**
 * Класс, реализующий интерфейс Sorter. Сортирует переданный массив методом пузырька
 */
public class BubbleSort implements Sorter {
    @Override
    public long sort(ArrayList<Person> peoples) {
        long start = new Date().getTime();
        boolean sorted = false; //сортируем пузырьком
        Person temp;
        //сортируем мужчин сначала
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < peoples.size() - 1; i++) {
                if (peoples.get(i).getSex() == Sex.WOMAN && peoples.get(i + 1).getSex() == Sex.MAN) {
                    temp = peoples.get(i);
                    peoples.set(i, peoples.get(i + 1));
                    peoples.set((i + 1), temp);
                    sorted = false;
                }
            }
        }
        sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < peoples.size() - 1; i++) {
                if (peoples.get(i).getAge() < peoples.get(i + 1).getAge() && peoples.get(i + 1).getSex() == peoples.get(i + 1).getSex()) {
                    temp = peoples.get(i);
                    peoples.set(i, peoples.get(i + 1));
                    peoples.set((i + 1), temp);
                    sorted = false;
                }
            }
        }
        sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < peoples.size() - 1; i++) {
                if (peoples.get(i).getAge() == peoples.get(i + 1).getAge()) {
                    try {
                        String n1 = peoples.get(i).getName();
                        String n2 = peoples.get(i + 1).getName();
                        if (n1.equals(n2)) throw new DubNameAgeException(peoples.get(i), peoples.get(i + 1));
                        if (n1.compareTo(n2) > 0) {
                            temp = peoples.get(i);
                            peoples.set(i, peoples.get(i + 1));
                            peoples.set((i + 1), temp);
                            sorted = false;
                        }
                    } catch (DubNameAgeException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return new Date().getTime() - start;
    }
}