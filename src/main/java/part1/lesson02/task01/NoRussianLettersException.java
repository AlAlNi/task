package part1.lesson02.task01;

class NoRussianLettersException extends Exception {
    NoRussianLettersException(String str) {
        super(String.format("Нет русской буквы а: %s", str));
    }
}

