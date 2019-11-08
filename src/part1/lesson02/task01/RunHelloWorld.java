package part1.lesson02.task01;

class RunHelloWorld {
    private static final String[] str = new String[1];

    static void nullPointerException() throws NullPointerException {
        if (str[0].equals("")) {
            str[0] = "Hello, World!";
        }
    }

    static void arrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
        System.out.println(str[1]);
    }

    static void noRussianLettersA() throws NoRussianLettersException {
        str[0] = "Hello, World!";
        throw new NoRussianLettersException(str[0]);
    }
}
