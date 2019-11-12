package part1.lesson02.task01;


class TryHelloWorld {
    static void tryHelloWorld() {
        RunHelloWorld runHelloWorld = new RunHelloWorld();
        try {
            runHelloWorld.nullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            runHelloWorld.arrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            runHelloWorld.noRussianLettersA();
        } catch (NoRussianLettersException noRussianLettersException) {
            noRussianLettersException.printStackTrace();
        }
    }
}
