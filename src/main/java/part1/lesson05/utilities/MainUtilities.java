package part1.lesson05.utilities;

import java.util.Map;
import java.util.TreeMap;

public class MainUtilities {
    public static final String EMPTY = "";
    public static final String ITEM_MENU_EXIT = "|000-выход|";
    public static final String ITEM_MENU_NEW_ANIMAL = "|001-добавить животное|";
    public static final String ITEM_MENU_SEARCH = "|002-поиск|";
    public static final String ITEM_MENU_CHANGE_DATA = "|003-изменение данных|";
    public static final String ITEM_MENU_ANIMAL_LIST_NAME_PERSON = "|004-список по имени хозяина животного|";
    public static final String ITEM_MENU_ANIMAL_LIST_NICK_NAME = "|005-список животных по имени животного|";
    public static final String ITEM_MENU_ANIMAL_LIST_WEIGHT = "|006-список животных по весу животного|";
    public static final String ITEM_HOME_MENU = "|007-главное меню|";
    public static final String ITEM_MENU_SEX_PERSON_MAN = "|008-MAN|";
    public static final String ITEM_MENU_SEX_PERSON_WOMAN = "|009-WOMAN|";
    public static final String ITEM_MENU_SAVE_EDITION = "|010-сохранить изминения|";
    public static final String TEXT_INPUT = "введите ";
    public static final String TEXT_NICK_NAME_ANIMAL = "|имя животного: ";
    public static final String TEXT_NAME_PERSON = "|имя хозяина животного: ";
    public static final String TEXT_AGE_PERSON = "|возраст хозяина животного: ";
    public static final String TEXT_SEX_PERSON = "|пол хозяина животного: ";
    public static final String TEXT_ANIMAL_WEIGHT = "|вес животного в гр.: ";
    public static final String TEXT_SORT_METHOD = "|способ сортировки: ";
    public static final String TEXT_DATA_ADD = "|данные добавлены ";
    public static final String TEXT_SIZE_CATALOG = " размер каталога: ";
    public static final String TEXT_ID_CATALOG = "|номер в каталоге: ";
    public static final String TEXT_NEW_DATA = "|изменение данных: ";
    public static final String TEXT_ERR_SEARCH = " ничего не найдено ";
    public static final Map<Number, String> ITEMS_MENU_MAP_STRING = new TreeMap<>();

    static {
        ITEMS_MENU_MAP_STRING.put(0, ITEM_MENU_EXIT);
        ITEMS_MENU_MAP_STRING.put(1, ITEM_MENU_NEW_ANIMAL);
        ITEMS_MENU_MAP_STRING.put(2, ITEM_MENU_SEARCH);
        ITEMS_MENU_MAP_STRING.put(3, ITEM_MENU_CHANGE_DATA);
        ITEMS_MENU_MAP_STRING.put(4, ITEM_MENU_ANIMAL_LIST_NAME_PERSON);
        ITEMS_MENU_MAP_STRING.put(5, ITEM_MENU_ANIMAL_LIST_NICK_NAME);
        ITEMS_MENU_MAP_STRING.put(6, ITEM_MENU_ANIMAL_LIST_WEIGHT);
        ITEMS_MENU_MAP_STRING.put(7, ITEM_HOME_MENU);
        ITEMS_MENU_MAP_STRING.put(8, ITEM_MENU_SEX_PERSON_MAN);
        ITEMS_MENU_MAP_STRING.put(9, ITEM_MENU_SEX_PERSON_WOMAN);
        ITEMS_MENU_MAP_STRING.put(10, ITEM_MENU_SAVE_EDITION);
    }
}