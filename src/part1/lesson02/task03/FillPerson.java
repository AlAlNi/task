package part1.lesson02.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static part1.lesson02.task03.KeyboardInputs.*;
import static part1.lesson02.task03.Sex.*;

class FillPerson {
    static ArrayList<Person> personArrayList = new ArrayList<>();
    static ArrayList<Person> personArrayListCopy = new ArrayList<>();

     void fillPersons() {
         KeyboardInputs keyboardInputs = new KeyboardInputs();
        for (int i = 0; i < keyboardInputs.customNumberElements; i++) {
            Random random = new Random();
            Sex s = ((random.nextInt(10) % 2) == 0) ? MAN : WOMAN;
            ArrayList<String> names = (s == MAN) ? keyboardInputs.nameManArrayList : keyboardInputs.nameWomanArrayList;
            Person person = new Person(random.nextInt(101), s, names.get(random.nextInt(names.size())));
            if (personArrayList.size() <= i) {
                personArrayList.add(person);
            } else {
                personArrayList.set(i, person);
            }
        }
        Collections.copy(personArrayList, personArrayListCopy);
    }
}