package part1.lesson02.task01;

public class MyNetRus extends Exception {
    private String detail;

    MyNetRus(String a) {
        detail = a;
    }

    public String toString() {
        return "Нет русской буквы а: " + detail;
    }
}

