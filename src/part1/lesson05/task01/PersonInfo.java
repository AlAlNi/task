package part1.lesson05.task01;

import java.io.Serializable;

public class PersonInfo extends AnimalInfo implements Serializable {
    private static final long serialVersionUID = 9013909351230891459l;
    private AnimalInfo animalInfo;
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
        return name + " " + sex + " " + age;
    }

    int getAgePerson() {
        return age;
    }

     void setAgePerson(int age) {
        this.age = age;
    }

    Sex getSexPerson() {
        return sex;
    }

     void setSexPerson(Sex sex) {
        this.sex = sex;
    }


    String getNamePerson() {
        return name;
    }
     void setNamePerson(String name) {this.name = name;}

    public AnimalInfo getAnimalInfo() {
        return animalInfo;
    }

}
