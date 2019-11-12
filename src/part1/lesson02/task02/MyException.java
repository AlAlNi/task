package part1.lesson02.task02;

class MyException extends Exception {

    MyException(int p1) {
        super(String.format("Отрицательное число %s", p1));
    }
}

