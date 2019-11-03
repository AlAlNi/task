package part1.lesson02.task02;

public class MyException extends Exception {
    private double detail;
    MyException (double a)
    {
        detail = a;
    }
    public String toString() {
        return "Отрицательное число[" + detail +"]";
    }
}

