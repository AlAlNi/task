package part1.lesson02.task01;

public class task01 {

    public static void main(String[] args) {

         String str[] = new String[1] ;

        try {

            if (str[0].equals("")) {
                str[0] = "Hello, World!";
            }
        }
        catch (NullPointerException e)
        {
            System.out.println(e);
            str[0] = "Hello, World!";
        }

        try {
            System.out.println(str[1]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        try {
            throw new NumberFormatException();
        }
        catch (NumberFormatException e)
        {
            System.out.println(e);
        }
        System.out.println(str[0]);
    }
}
