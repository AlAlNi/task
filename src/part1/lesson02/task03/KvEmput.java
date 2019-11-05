package part1.lesson02.task03;

import part1.lesson02.task03.Exception.MinChException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class KvEmput {

    static void bufferMan() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите список мужских имён в конце списка наберите: end или конец");
        while (true) {

            String name = reader.readLine();
            if (name.equals("end") | name.equals("конец")) {
                break;
            }
            OsnMain.obNameMan.add(new Person(name));
        }
    }
    static void bufferWoman() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите список женских имён в конце списка наберите: end или конец");
        while (true) {

            String sex;
            String name = reader.readLine();
            if (name.equals("end") | name.equals("конец")) {
                break;
            }
            OsnMain.obNameWoman.add(new Person(name));
        }
    }
        static void bufferMinCh() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OsnMain.minCh = 10000;
            while (true) {
                System.out.println("Введите длину генирированного масива(число от " + OsnMain.minCh + " и более):");
                String sA = reader.readLine();
                OsnMain.nA = Integer.parseInt(sA);
                try {

                    if (OsnMain.nA < OsnMain.minCh)
                        throw new MinChException(OsnMain.minCh);

                    break;
                } catch (MinChException e) {
                    e.printStackTrace();
                }
            }
        }
}
