package part1.lesson05.task01;


import java.util.UUID;


public class AnimalInfo {
    private String idAdmin;
    private String nickNameAnimal;
    private int animalWeight;
    PersonInfo personInfo;

    public AnimalInfo() {
    }

    public AnimalInfo(String nickNameAnimal, int animalWeight, String idAnimal, PersonInfo personInfo) {
        this.nickNameAnimal = nickNameAnimal;
        this.animalWeight = animalWeight;
        this.personInfo = personInfo;
        this.idAdmin = idAnimal;
    }

    @Override

    public String toString() {
        return ItemsMenu.TEXT_NAME_PERSON
                + personInfo.getNamePerson()
                + " "
                + ItemsMenu.TEXT_SEX_PERSON
                + personInfo.getSexPerson()
                + " "
                + ItemsMenu.TEXT_AGE_PERSON
                + personInfo.getAgePerson()
                + " "
                + ItemsMenu.TEXT_NICK_NAME_ANIMAL
                + nickNameAnimal
                + " "
                + ItemsMenu.TEXT_ANIMAL_WEIGHT
                + animalWeight;
    }

    int getAnimalWeight() {
        return animalWeight;
    }

    void setAnimalWeight(int animalWeight) {
        this.animalWeight = animalWeight;
    }

    PersonInfo getPersonInfo() {
        return personInfo;
    }

    String getNickNameAnimal() {
        return nickNameAnimal;
    }

    String getIdAdmin() {
        return idAdmin;
    }

    void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    void setIdAnimal(String idAnimal) {
        this.idAdmin = idAnimal;
    }

    void setNickNameAnimal(String nickNameAnimal) {
        this.nickNameAnimal = nickNameAnimal;
    }

}
