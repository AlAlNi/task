//Задание 2. Составить программу, генерирующую N случайных чисел. Для каждого числа k вычислить квадратный корень q.
//        Если квадрат целой части q числа равен k, то вывести это число на экран.
//        Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.


package part1.lesson02.task02;

import java.util.ArrayList;
import java.util.Random;

public class task02 {

    public static void main(String[] args) throws MyException {

        Random s = new Random();
        Random n = new Random();

        int m = s.nextInt(100);

        ArrayList<Integer> dCh = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            dCh.add(-100 + s.nextInt(200));
        }
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