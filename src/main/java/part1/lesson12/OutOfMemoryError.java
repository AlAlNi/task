package part1.lesson12;

import javassist.CannotCompileException;
import javassist.ClassPool;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class OutOfMemoryError {

    /**
     * Добавляем в лист новые объекты, периодически удаляя часть, чтобы сработал GC
     */
    public static void heapError() {
        ArrayList<Double> list = new ArrayList<>();

        while (true) {
            IntStream.range(0, 10000000).mapToObj(i -> Math.random()).forEach(list::add);
            System.out.println("Total Memory: " + Runtime.getRuntime().totalMemory()/1000 + " Mb");
            list.subList(0, 5000000).clear();
            System.out.println("Total Memory after deleting: " + Runtime.getRuntime().totalMemory()/1000 + " Mb");
        }
    }

    /**
     * Создаём новые классы до тех пор, пока не будет заполнен Metaspace
     */
    public static void metaspaceError(){
        ClassPool classPool = ClassPool.getDefault();

        for (int i = 0; i < 1000000000; i++) {
            try {
               classPool.makeClass("OutOfMemory" + i + ".Main ").toClass();
            }
            catch (CannotCompileException e) {
                System.err.println("Ошибка во время создания класса " + e.getMessage());
            }
        }
    }
}
