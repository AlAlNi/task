package part1.lesson02.task03;

public class MyException extends Exception {
    private double detail;
    MyException(double a)
    {
        detail = a;
    }
    public String toString() {
        return "Совпадение возраста и пола:" + detail;
    }
}

