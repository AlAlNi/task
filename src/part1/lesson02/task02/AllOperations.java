/**
 * Задание 2. Составить программу, генерирующую N случайных чисел. Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 *
 * @author AlAlNi
 */

package part1.lesson02.task02;


public class AllOperations {
    public static void main(String[] args) {
        ArrayOperations arrayOperations = new ArrayOperations();
        arrayOperations.randomNumber();
        arrayOperations.basicCalculation();
    }
}
