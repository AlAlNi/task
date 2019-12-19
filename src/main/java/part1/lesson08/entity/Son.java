package part1.lesson08.entity;

public class Son extends Father {
    private transient static int count;
    private String name;
    private int age;
    private boolean sex;

    public Son(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        count++;

        System.out.println("Son created. Total: " + count);
    }
    public Son() {
        count++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setCount(int count) {
        Son.count = count;
    }

    @Override
    public String toString() {
        return "<"
                + this.getClass().getSimpleName()
                + "{Name=" + this.name
                + "; Age=" + this.age
                + "; Sex=" + this.sex
                + "}>";
    }
}