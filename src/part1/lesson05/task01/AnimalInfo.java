package part1.lesson05.task01;


import java.io.Serializable;
import java.util.UUID;


public class AnimalInfo implements Serializable {
    private static final long serialVersionUID = 9013909351230891459l;
    private UUID idAdmin;
    private String nickNameAnimal;
    private int animalWeight;
    PersonInfo personInfo;

    public AnimalInfo() {
    }

    public AnimalInfo(String nickNameAnimal, int animalWeight, UUID idAnimal, PersonInfo personInfo) {
        this.nickNameAnimal = nickNameAnimal;
        this.animalWeight = animalWeight;
        this.personInfo = personInfo;
        this.idAdmin = idAnimal;
    }

    @Override

    public String toString() {
        return ItemsMenu.TEXT_NAME_PERSON + personInfo.getNamePerson() +" "+ ItemsMenu.TEXT_SEX_PERSON + personInfo.getSexPerson() +" "+ ItemsMenu.TEXT_AGE_PERSON + personInfo.getAgePerson() +" "+ ItemsMenu.TEXT_NICK_NAME_ANIMAL + nickNameAnimal +" "+ ItemsMenu.TEXT_ANIMAL_WEIGHT + animalWeight +" "+ ItemsMenu.TEXT_ID_CATALOG + idAdmin;
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

    UUID getIdAdmin() {
        return idAdmin;
    }

    void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    void setIdAnimal(UUID idAnimal) {
        this.idAdmin = idAnimal;
    }

    void setNickNameAnimal(String nickNameAnimal) {
        this.nickNameAnimal = nickNameAnimal;
    }

}
