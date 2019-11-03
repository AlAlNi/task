package part1.lesson02.task03;

public class Person {

    int age;
    String sex;
    String name;
    Person(int age, String sex, String name)
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
    public String getSex()
    {
        return sex;
    }
    public String getName()
    {
        return name;
    }

}
