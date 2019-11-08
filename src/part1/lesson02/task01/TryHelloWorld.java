package part1.lesson02.task01;

import static part1.lesson02.task01.RunHelloWorld.*;

class TryHelloWorld {
    static void tryHelloWorld() {
        try {
            nullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            arrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            noRussianLettersA();
        } catch (NoRussianLettersException noRussianLettersException) {
            noRussianLettersException.printStackTrace();
        }
    }
}
