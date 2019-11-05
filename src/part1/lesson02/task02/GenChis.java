//Задание 2. Составить программу, генерирующую N случайных чисел. Для каждого числа k вычислить квадратный корень q.
//        Если квадрат целой части q числа равен k, то вывести это число на экран.
//        Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.


package part1.lesson02.task02;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

public class GenChis {


    public static void main(String[] args) throws MyException {

        OperacMasiv.sodMas();
        OperacMasiv.prShet();

    }

}