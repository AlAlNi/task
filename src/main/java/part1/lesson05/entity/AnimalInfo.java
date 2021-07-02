package part1.lesson05.entity;


import part1.lesson05.utilities.MainUtilities;

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
        return MainUtilities.TEXT_NAME_PERSON
                + personInfo.getNamePerson()
                + " "
                + MainUtilities.TEXT_SEX_PERSON
                + personInfo.getSexPerson()
                + " "
                + MainUtilities.TEXT_AGE_PERSON
                + personInfo.getAgePerson()
                + " "
                + MainUtilities.TEXT_NICK_NAME_ANIMAL
                + nickNameAnimal
                + " "
                + MainUtilities.TEXT_ANIMAL_WEIGHT
                + animalWeight
                + " "
                + MainUtilities.TEXT_ID_CATALOG
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
