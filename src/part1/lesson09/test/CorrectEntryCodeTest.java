package part1.lesson09.test;

import org.junit.jupiter.api.Test;
import part1.lesson09.Loader;
import part1.lesson09.MyClassLoader;
import part1.lesson09.Worker;

import java.io.ByteArrayInputStream;

class CorrectEntryCodeTest {
    private static final String CLASS_NAME = "SomeClass";

    @Test
    public void main() {
        ByteArrayInputStream in = new ByteArrayInputStream("System.out.println(123+23);\n\n".getBytes()); //имитируем ввод данных пользователем с консоли.
        System.setIn(in);
        Loader java = new Loader(CLASS_NAME);
        java.loading();
        ClassLoader loader = new MyClassLoader();
        Object o = getObject(loader);
        setObject(o);
    }

    private static void setObject(Object o) {
        if (o instanceof Worker) {
            Worker w = (Worker) o;
            w.doWork();
        }
    }

    private static Object getObject(ClassLoader loader) {
        try {
            Class<?> clazz = loader.loadClass(CLASS_NAME);
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}