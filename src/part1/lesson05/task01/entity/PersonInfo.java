package part1.lesson05.task01.entity;

import java.io.Serializable;

public class PersonInfo extends AnimalInfo implements Serializable {

    private int age;
    private Sex sex;
    private String name;

    public PersonInfo() {

    }

    public PersonInfo(String name, int age, Sex sex) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    @Override
    public String toString() {
        return name
                + " "
                + sex
                + " "
                + age;
    }

    public  int getAgePerson() {
        return age;
    }

    public   void setAgePerson(int age) {
        this.age = age;
    }

    public   Sex getSexPerson() {
        return sex;
    }

    public  void setSexPerson(Sex sex) {
        this.sex = sex;
    }

    public   String getNamePerson() {
        return name;
    }

    public  void setNamePerson(String name) {
        this.name = name;
    }
}
