package part1.lesson08.objects;

public class SObject extends YourFather {
    private transient static int count;
    private String name;
    private int age;
    private boolean sex;

    public SObject(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        count++;

        System.out.println("SObject created. Total: " + count);
    }
    public SObject() {
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
        SObject.count = count;
    }

    @Override
    public String toString() {
        return "<" + this.getClass().getSimpleName() + "{Name=" + this.name + "; Age=" + this.age + "; Sex=" + this.sex + "}>";
    }
}