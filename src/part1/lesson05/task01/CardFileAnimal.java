/**
 * Разработать программу – картотеку домашних животных. У каждого животного есть уникальный идентификационный номер,
 * кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * Реализовать:
 * метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 */
package part1.lesson05.task01;

import part1.lesson05.task01.menu.MainMenu;

public class CardFileAnimal {
    public static void main(String[] args) {
        NavigationInputKeyboards navigationInputKeyboards = new NavigationInputKeyboards();
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu(ItemsMenu.ITEM_MENU_NEW_ANIMAL,
                ItemsMenu.ITEM_MENU_SEARCH,
                ItemsMenu.ITEM_MENU_CHANGE_DATA,
                ItemsMenu.ITEM_MENU_ANIMAL_LIST,
                ItemsMenu.ITEM_MENU_EXIT,
                ItemsMenu.PUNKT_MENU);
        navigationInputKeyboards.inputKeyboards();
    }
}