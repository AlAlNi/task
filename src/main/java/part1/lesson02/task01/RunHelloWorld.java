package part1.lesson02.task01;

import static part1.lesson05.utilities.MainUtilities.EMPTY;

class RunHelloWorld {
    private static final String[] str = new String[1];

    void nullPointerException() throws NullPointerException {
        if (str[0].equals(EMPTY)) {
            str[0] = "Hello, World!";
        }
    }

    void arrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
        System.out.println(str[1]);
    }

    void noRussianLettersA() throws NoRussianLettersException {
        str[0] = "Hello, World!";
        throw new NoRussianLettersException(str[0]);
    }
}
