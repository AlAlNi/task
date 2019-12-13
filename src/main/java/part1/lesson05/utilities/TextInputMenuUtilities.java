package part1.lesson05.utilities;

import java.util.ArrayList;

public class TextInputMenuUtilities {
   public static final String TEXT_NICK_NAME_ANIMAL = "|имя животного: ";
    public  static final String TEXT_NAME_PERSON = "|имя хозяина животного: ";
    public  static final String TEXT_AGE_PERSON = "|возраст хозяина животного: ";
    public  static final String TEXT_SEX_PERSON = "|пол хозяина животного: ";
    public   static final String TEXT_ANIMAL_WEIGHT = "|вес животного в гр.: ";
    public   static final ArrayList<TextItemInputUtilities> TEXT_QUESTIONS_MENU_INPUT = new ArrayList<>();

    static {
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInputUtilities("001", TEXT_NICK_NAME_ANIMAL));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInputUtilities("001", TEXT_ANIMAL_WEIGHT));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInputUtilities("001", TEXT_NAME_PERSON));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInputUtilities("001", TEXT_AGE_PERSON));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInputUtilities("001", TEXT_SEX_PERSON));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInputUtilities("004", TEXT_NICK_NAME_ANIMAL));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInputUtilities("004", TEXT_NAME_PERSON));
        TEXT_QUESTIONS_MENU_INPUT.add(new TextItemInputUtilities("004", TEXT_AGE_PERSON));
    }
}
