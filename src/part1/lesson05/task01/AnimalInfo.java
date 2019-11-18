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
        return "|хозяин: " + personInfo.getNamePerson() +"| |пол хозяина: "+ personInfo.getSexPerson()+"| |возраст хозяина: "+ personInfo.getAgePerson()+"| |кличка животного: " + nickNameAnimal + "| |вес животного: " + animalWeight + "| |номер в катологе: " + idAdmin;
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
