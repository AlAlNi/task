package part1.lesson09;

public class Main {
    static {
    }
    public static void main(String[] args) throws Exception {
        Worker worker = new SomeClass();
        worker.doWork();
        useCustomClassLoader();
    }
    private static void useCustomClassLoader() throws Exception {
        ClassLoader cl = new MyClassLoader();
        Class<?> someClass = cl.loadClass("SomeClass");
        Worker worker = (Worker) someClass.newInstance();
        worker.doWork();
    }
}
