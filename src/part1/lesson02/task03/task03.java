package part1.lesson02.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class task03 {

    public static void main(String[] args) throws IOException, MyException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Person> obNameMan = new ArrayList<>();
        ArrayList<Person> obNameWoman = new ArrayList<>();
        ArrayList<Person> obPerson = new ArrayList<>();
        Object temp;
        System.out.println("Введите список мужских имён в конце списка наберите: end или конец");
        while (true) {

            String name = reader.readLine();
            if (name.equals("end")|name.equals("конец"))
            {
                break;
            }
            obNameMan.add( new Person(name));
        }
        System.out.println("Введите список женских имён в конце списка наберите: end или конец");
        while (true) {

            String sex;
            String name = reader.readLine();
            if (name.equals("end")|name.equals("конец"))
            {
                break;
            }
            obNameWoman.add( new Person(name));
        }
        System.out.println("Введите длину генирированного масива(число от 10000 и более:)");
        String sA = reader.readLine();
        int nA = Integer.parseInt(sA);
        for (int i = 0; i < nA; i++)
        {
            Random n = new Random();
            Random m = new Random();
            if (n.nextInt(10)%2==0) {
                obPerson.add(new Person(m.nextInt(101),"Woman",obNameWoman.get(m.nextInt(obNameWoman.size())).name)); }
            obPerson.add(new Person(m.nextInt(101),"Man",obNameMan.get(m.nextInt(obNameMan.size())).name));
        }

        for (int i=0;i<nA;i++) {
            temp = (obPerson.get(i).name+obPerson.get(i).age);
            for (int y = 0; y < nA; y++) {
                try {
                    if (temp.equals(obPerson.get(y).name + obPerson.get(y).age)) {
                        
                    }
                }
            }
        }
    }



}
