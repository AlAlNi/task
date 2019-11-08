package part1.lesson02.task03.exception;

/**
 * Класс пользовательского исключения при вводе числа менее требуемого значения
 */
public class WrongNumberException extends Exception {
    public WrongNumberException(int p1, int p2) {
        super(String.format("Неверное число(%s). Введите число от %s: и более", p1, p2));
    }
}