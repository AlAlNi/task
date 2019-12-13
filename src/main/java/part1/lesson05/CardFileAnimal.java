/**
 * Разработать программу – картотеку домашних животных. У каждого животного есть уникальный идентификационный номер,
 * кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * Реализовать:
 * метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 */
package part1.lesson05;


import part1.lesson05.utilities.ItemsMenuUtilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class CardFileAnimal {
    public static void main(String[] args) throws IOException {
        IntStream.range(0, 7).mapToObj(ItemsMenuUtilities.ITEMS_MENU_MAP_STRING::get).forEach(System.out::print);
        System.out.println("");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        SearchItemsMenu searchStringInputMenu1 = new SearchItemsMenu();
        String inputText = searchStringInputMenu1.inputText(bufferedReader.readLine());
        bufferedReader.close();
        System.out.println(inputText);
    }
}