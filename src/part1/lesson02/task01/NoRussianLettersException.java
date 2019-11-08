package part1.lesson02.task01;

public class NoRussianLettersException extends Exception {
    public NoRussianLettersException(String str) {
        super(String.format("Нет русской буквы а: %s", str));
    }
}

