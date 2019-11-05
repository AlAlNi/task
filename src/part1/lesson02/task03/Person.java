package part1.lesson02.task03;

import java.util.Set;

public class Person {

    int age;
    Sex sex;
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

    public int getAge() {return age;}
    public Sex getSex()
    {
        return sex;
    }
    public String getName()
    {
        return name;
    }

}
