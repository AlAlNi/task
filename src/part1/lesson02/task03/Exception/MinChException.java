package part1.lesson02.task03.Exception;

public class MinChException extends Exception {
    private int detail;
    public MinChException(int a)
    {
        detail = a;
    }
    public String toString() {
        return "Введите число от: " + detail+" и более";
    }
}


