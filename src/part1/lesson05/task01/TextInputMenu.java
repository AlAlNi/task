package part1.lesson05.task01;

import java.util.ArrayList;

public class TextInputMenu {
    static final String TEXT_NICK_NAME_ANIMAL = "|имя животного: ";
    static final String TEXT_NAME_PERSON = "|имя хозяина животного: ";
    static final String TEXT_AGE_PERSON = "|возраст хозяина животного: ";
    static final String TEXT_SEX_PERSON = "|пол хозяина животного: ";
    static final String TEXT_ANIMAL_WEIGHT = "|вес животного в гр.: ";
    static final ArrayList<TextItemInput> TEXT_QUESTIONS_MENU_INPUT = new ArrayList<>();

    static {
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInput("001", TEXT_NICK_NAME_ANIMAL));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInput("001", TEXT_ANIMAL_WEIGHT));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInput("001", TEXT_NAME_PERSON));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInput("001", TEXT_AGE_PERSON));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInput("001", TEXT_SEX_PERSON));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInput("004", TEXT_NICK_NAME_ANIMAL));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInput("004", TEXT_NAME_PERSON));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInput("004", TEXT_AGE_PERSON));
    }
}
