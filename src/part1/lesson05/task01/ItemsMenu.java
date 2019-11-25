package part1.lesson05.task01;

import java.util.Map;
import java.util.TreeMap;

class ItemsMenu {
    static final String PUNKT_MENU = "";
    static final String ITEM_MENU_EXIT = "|000-выход|";
    static final String ITEM_MENU_NEW_ANIMAL = "|001-добавить животное|";
    static final String ITEM_MENU_SEARCH = "|002-поиск|";
    static final String ITEM_MENU_CHANGE_DATA = "|003-изменение данных|";
    static final String ITEM_MENU_ANIMAL_LIST_NAME_PERSON = "|004-список по имени хозяина животного|";
    static final String ITEM_MENU_ANIMAL_LIST_NICK_NAME = "|005-список животных по имени животного|";
    static final String ITEM_MENU_ANIMAL_LIST_WEIGHT = "|006-список животных по весу животного|";
    static final String ITEM_HOME_MENU = "|007-главное меню|";
    static final String ITEM_MENU_SEX_PERSON_MAN = "|008-MAN|";
    static final String ITEM_MENU_SEX_PERSON_WOMAN = "|009-WOMAN|";
    static final String ITEM_MENU_SAVE_EDITION = "|010-сохранить изминения|";
    static final String TEXT_INPUT = "введите ";
    static final String TEXT_NICK_NAME_ANIMAL = "|имя животного: ";
    static final String TEXT_NAME_PERSON = "|имя хозяина животного: ";
    static final String TEXT_AGE_PERSON = "|возраст хозяина животного: ";
    static final String TEXT_SEX_PERSON = "|пол хозяина животного: ";
    static final String TEXT_ANIMAL_WEIGHT = "|вес животного в гр.: ";
    static final String TEXT_SORT_METHOD = "|способ сортировки: ";
    static final String TEXT_DATA_ADD = "|данные добавлены ";
    static final String TEXT_SIZE_CATALOG = " размер каталога: ";
    static final String TEXT_ID_CATALOG = "|номер в каталоге: ";
    static final String TEXT_NEW_DATA = "|изменение данных: ";
    static final String TEXT_ERR_SEARCH = " ничего не найдено ";
    static final Map<Number, String> ITEMS_MENU_MAP_STRING = new TreeMap<>();

    static {
        ITEMS_MENU_MAP_STRING.put(0, ITEM_MENU_EXIT);
        ITEMS_MENU_MAP_STRING.put(1, ITEM_MENU_NEW_ANIMAL);
        ITEMS_MENU_MAP_STRING.put(2, ITEM_MENU_SEARCH);
        ITEMS_MENU_MAP_STRING.put(3, ITEM_MENU_CHANGE_DATA);
        ITEMS_MENU_MAP_STRING.put(4,  ITEM_MENU_ANIMAL_LIST_NAME_PERSON );
        ITEMS_MENU_MAP_STRING.put(5, ITEM_MENU_ANIMAL_LIST_NICK_NAME);
        ITEMS_MENU_MAP_STRING.put(6, ITEM_MENU_ANIMAL_LIST_WEIGHT);
        ITEMS_MENU_MAP_STRING.put(7, ITEM_HOME_MENU);
        ITEMS_MENU_MAP_STRING.put(8, ITEM_MENU_SEX_PERSON_MAN);
        ITEMS_MENU_MAP_STRING.put(9, ITEM_MENU_SEX_PERSON_WOMAN);
        ITEMS_MENU_MAP_STRING.put(10, ITEM_MENU_SAVE_EDITION);
    }
}