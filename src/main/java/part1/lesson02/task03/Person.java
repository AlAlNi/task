package part1.lesson02.task03;

public class Person {

    private int age;
    private Sex sex;
    private String name;

    Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    int getAge() {
        return age;
    }

    Sex getSex() {
        return sex;
    }

    String getName() {
        return name;
    }
}
