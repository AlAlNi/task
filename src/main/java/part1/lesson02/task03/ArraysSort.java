package part1.lesson02.task03;

import part1.lesson02.task03.exception.DubNameAgeException;

import java.util.*;

/**
 * Класс для сортировки стандартными средствами класса Arrays
 *
 * @author AlAlNi
 */
public class ArraysSort implements Sorter {
    @Override
    public long sort(ArrayList<Person> peoples) {
        long start = new Date().getTime();
        peoples.sort(Comparator.comparing(Person::getSex).thenComparing((p1, p2) -> {
            int age1 = p1.getAge(), age2 = p2.getAge();
            try {
                if (age1 == age2 && p1.getName().equals(p2.getName())) throw new DubNameAgeException(p1, p2);
            } catch (DubNameAgeException e) {
                e.printStackTrace();
            }
            return age2 - age1;
        }).thenComparing(Person::getName));
        return new Date().getTime() - start;
    }
}
