/**
 * Задание 1. Написать программу ”Hello, World!”.
 * В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 * Смоделировав ошибку «NullPointerException»
 * Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * Вызвав свой вариант ошибки через оператор throw
 *
 * @author AlAlNi
 */
package part1.lesson02.task01;

import static part1.lesson02.task01.TryHelloWorld.*;

public class HelloWorld {
    public static void main(String[] args) {
        tryHelloWorld();
    }
}
