package part1.lesson05.task01.entity;


import part1.lesson05.task01.utilities.ItemsMenuUtilities;

import java.io.Serializable;

public class AnimalInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idAdmin;
    private String nickNameAnimal;
    private int animalWeight;
    private PersonInfo personInfo;

    public AnimalInfo() {
    }

    public AnimalInfo(String nickNameAnimal, int animalWeight, int idAnimal, PersonInfo personInfo) {
        this.nickNameAnimal = nickNameAnimal;
        this.animalWeight = animalWeight;
        this.personInfo = personInfo;
        this.idAdmin = idAnimal;
    }

    @Override

    public String toString() {
        return ItemsMenuUtilities.TEXT_NAME_PERSON
                + personInfo.getNamePerson()
                + " "
                + ItemsMenuUtilities.TEXT_SEX_PERSON
                + personInfo.getSexPerson()
                + " "
                + ItemsMenuUtilities.TEXT_AGE_PERSON
                + personInfo.getAgePerson()
                + " "
                + ItemsMenuUtilities.TEXT_NICK_NAME_ANIMAL
                + nickNameAnimal
                + " "
                + ItemsMenuUtilities.TEXT_ANIMAL_WEIGHT
                + animalWeight
                + " "
                + ItemsMenuUtilities.TEXT_ID_CATALOG
                + idAdmin;
    }

    public String toStringNoId() {
        return personInfo.getNamePerson()
                + personInfo.getSexPerson()
                + personInfo.getAgePerson()
                + nickNameAnimal
                + animalWeight;
    }

    public int getAnimalWeight() {
        return animalWeight;
    }

    public void setAnimalWeight(int animalWeight) {
        this.animalWeight = animalWeight;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public String getNickNameAnimal() {
        return nickNameAnimal;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAdmin = idAnimal;
    }

    public void setNickNameAnimal(String nickNameAnimal) {
        this.nickNameAnimal = nickNameAnimal;
    }

}
