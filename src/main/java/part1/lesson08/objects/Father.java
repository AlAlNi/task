package part1.lesson08.objects;

public class Father {
    private String name;
    private int age;
    private boolean hairy;
    private Son someone;

    public Father(String name, int age, boolean hairy, Son someone) {
        this.name = name;
        this.age = age;
        this.hairy = hairy;
        this.someone = someone;
    }

    public Father() {

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + "{Name=" + this.name
                + "; Age=" + this.age
                + "; Hairy=" + this.hairy
                + " Child=" + this.someone
                + "}";
    }
}
