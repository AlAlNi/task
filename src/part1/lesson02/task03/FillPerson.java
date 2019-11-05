package part1.lesson02.task03;

import java.util.ArrayList;
import java.util.Random;

class FillPerson {
    static void fillPersons() {
        for (int i = 0; i < OsnMain.nA; i++) {
            Random n = new Random();
            Random m = new Random();
            Sex s = n.nextInt(10) % 2 == 0 ? Sex.MAN : Sex.WOMAN;
            ArrayList<Person> names = s == Sex.MAN ? OsnMain.obNameMan : OsnMain.obNameWoman;
            Person person = new Person(m.nextInt(101), s, names.get(m.nextInt(names.size())).name);
            if (OsnMain.obPerson.size() <= i) {

                OsnMain.obPerson.add(person);
            } else {
                OsnMain.obPerson.set(i, person);
            }
//        System.out.println(i);
        }
    }
}
