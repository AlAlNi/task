package part1.lesson09;

public class Main {
    private static final String CLASS_NAME = "SomeClass";

    public static String getClassName() {
        return CLASS_NAME;
    }

    public static void main(String[] args) {
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