package part1.lesson08.objects;

public class YourFather {
    private String name;
    private int age;
    private boolean hairy;
    private SObject someone;

    public YourFather(String name, int age, boolean hairy, SObject someone) {
        this.name = name;
        this.age = age;
        this.hairy = hairy;
        this.someone = someone;
    }

    public YourFather() {

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{Name=" + this.name + "; Age=" + this.age + "; Hairy=" + this.hairy + " Child=" + this.someone + "}";
    }
}
