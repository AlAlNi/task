//Задание 1. Написать программу ”Hello, World!”.
// В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
//
//        Смоделировав ошибку «NullPointerException»
//        Смоделировав ошибку «ArrayIndexOutOfBoundsException»
//        Вызвав свой вариант ошибки через оператор throw

package part1.lesson02.task01;

public class task01 {
    private static String[] str = new String[1];

    public static void main(String[] args) throws MyNetRus {


        try {
            nullPointerException();

        } catch (NullPointerException e) {
            System.out.println(e);
        }
        try {
            arrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        try {
            myNetRus();
        } catch (MyNetRus myNetRus) {
            myNetRus.printStackTrace();
        }


    }

    private static void nullPointerException() throws NullPointerException {


        if (str[0].equals("")) {
            str[0] = "Hello, World!";
        }
    }

    private static void arrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {

        System.out.println(str[1]);

    }

    private static void myNetRus() throws MyNetRus {

        str[0] = "Hello, World!";
        throw new MyNetRus(str[0]);


    }
}