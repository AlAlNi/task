package part1.lesson09;

public class SomeClass implements Worker {
    static {
        System.out.println("Hello1");
    }

    @Override
    public void doWork() {
        System.out.println("Hello2");
    }
}
