//Задание 3. Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
//        sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN),
//        name (имя - строка). Создать два класса,
//        методы которых будут реализовывать сортировку объектов.
//        Предусмотреть единый интерфейс для классов сортировки.
//        Реализовать два различных метода сортировки этого массива по правилам:
//        первые идут мужчины
//        выше в списке тот, кто более старший
//        имена сортируются по алфавиту
//        Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
//        Предусмотреть генерацию исходного массива (10000 элементов и более).
//        Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.


package part1.lesson02.task03;

import part1.lesson02.task03.Exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class OsMain {
    private static ArrayList<Person> obPerson = new ArrayList<>();
    private static int nA;
    private static ArrayList<Person> obNameMan = new ArrayList<>();
    private static ArrayList<Person> obNameWoman = new ArrayList<>();

    public static void main(String[] args) throws IOException, DubNameAgeException, MinChException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int minCh = 10000;


        System.out.println("Введите список мужских имён в конце списка наберите: end или конец");
        while (true) {

            String name = reader.readLine();
            if (name.equals("end") | name.equals("конец")) {
                break;
            }
            obNameMan.add(new Person(name));
        }
        System.out.println("Введите список женских имён в конце списка наберите: end или конец");
        while (true) {

            String sex;
            String name = reader.readLine();
            if (name.equals("end") | name.equals("конец")) {
                break;
            }
            obNameWoman.add(new Person(name));
        }

        while (true) {
            System.out.println("Введите длину генирированного масива(число от " + minCh + " и более):");
            String sA = reader.readLine();
            nA = Integer.parseInt(sA);
            try {

                if (nA < minCh)
                    throw new MinChException(minCh);

                break;
            } catch (MinChException e) {
                e.printStackTrace();
            }
        }

        fillPersons();
//        System.out.println(obPerson.toString());
        Sorter sort1 = new Sorter1();
        long sortTime1 = sort1.sort(obPerson);
//        System.out.println(obPerson.toString());
        System.out.println("Время, потраченное на сортировку массива методом пузырька: " + sortTime1 / 1000. + " сек.");

        fillPersons();
        Sorter sort2 = new Sorter2();
        long sortTime2 = sort2.sort(obPerson);
        //System.out.println(Arrays.toString(peoples));
        System.out.println("Время, потраченное на сортировку встроенными методами класса Arrays: " + sortTime2 / 1000. + " сек.");
    }

    private static void fillPersons() {
        for (int i = 0; i < nA; i++) {
            Random n = new Random();
            Random m = new Random();
            Sex s = n.nextInt(10) % 2 == 0 ? Sex.MAN : Sex.WOMAN;
            ArrayList<Person> names = s == Sex.MAN ? obNameMan : obNameWoman;
            Person person = new Person(m.nextInt(101), s, names.get(m.nextInt(names.size())).name);
            if (obPerson.size() <= i) {

                obPerson.add(person);
            } else {
                obPerson.set(i, person);
            }
//        System.out.println(i);
        }

    }
}
