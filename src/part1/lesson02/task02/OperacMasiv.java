package part1.lesson02.task02;

import java.util.ArrayList;
import java.util.Random;

public class OperacMasiv {
    private static ArrayList<Integer> dCh = new ArrayList<>();
    private static int m;

    static void sodMas() {
        Random s = new Random();
        Random n = new Random();

        m = s.nextInt(100);


        for (int i = 0; i < m; i++) {
            dCh.add(s.nextInt());
        }
    }

    static void prShet() {
        for (int i = 0; i < m; i++) {
            try {
                if (dCh.get(i) < 0)
                    throw new MyException(dCh.get(i));

                if (dCh.get(i) == Math.pow(Math.sqrt(dCh.get(i)), 2)) {
                    System.out.println(dCh.get(i));
                }
            } catch (MyException e) {
                System.out.println(e);
            }
        }
    }
}
