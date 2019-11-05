package part1.lesson02.task03;

public class Person {

    private int age;
    private Sex sex;
    String name;
    Person(int age, Sex sex, String name)
    {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }
    Person(String name)
    {
        this.name = name;
    }

    int getAge() {return age;}
    Sex getSex()
    {
        return sex;
    }
    String getName()
    {
        return name;
    }

}
