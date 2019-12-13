package part1.lesson05;

import part1.lesson05.entity.AnimalInfo;
import part1.lesson05.entity.PersonInfo;
import part1.lesson05.entity.Sex;
import part1.lesson05.utilities.ItemsMenuUtilities;
import part1.lesson05.utilities.TextInputMenuUtilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class NewAnimal {
    ArrayList<String> arrayAnimal = new ArrayList<>();
    boolean isExit = false;
    int numberOfMistakes;
    AnimalInfo animalInfo1 = new AnimalInfo();
    PersonInfo personInfo1 = new PersonInfo();
    InfoArrayAnimalInfo infoArrayAnimalInfo = new InfoArrayAnimalInfo();

    public void addNewAnimal() throws IOException {
        IntStream.range(0, TextInputMenuUtilities.TEXT_QUESTIONS_MENU_INPUT.size())
                .filter(i -> "001".equals(TextInputMenuUtilities.TEXT_QUESTIONS_MENU_INPUT.get(i).getItemTextInput()))
                .forEachOrdered(i -> arrayAnimal.add(TextInputMenuUtilities.TEXT_QUESTIONS_MENU_INPUT.get(i).getTextInput()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            numberOfMistakes = 0;
            for (int i = 0; i < arrayAnimal.size(); i++) {
                System.out.println(arrayAnimal.get(i));
                arrayAnimal.set(i, bufferedReader.readLine());
            }
            animalInfo1.setNickNameAnimal(arrayAnimal.get(0));
            personInfo1.setNamePerson(arrayAnimal.get(2));
            try {
                personInfo1.setAgePerson(Integer.parseInt(arrayAnimal.get(3)));
            } catch (NumberFormatException e) {
                System.err.println("Не коректный ввод возроста: " + arrayAnimal.get(3));
                arrayAnimal.set(3, ItemsMenuUtilities.TEXT_AGE_PERSON);
                numberOfMistakes++;
            }
            try {
                animalInfo1.setAnimalWeight(Integer.parseInt(arrayAnimal.get(1)));
            } catch (NumberFormatException e) {
                System.err.println("Не коректный ввод веса: " + arrayAnimal.get(1));
                arrayAnimal.set(1, ItemsMenuUtilities.TEXT_ANIMAL_WEIGHT);
                numberOfMistakes++;
            }
            if ("man".equalsIgnoreCase(arrayAnimal.get(4)) || "мужчина".equalsIgnoreCase(arrayAnimal.get(4))) {
                personInfo1.setSexPerson(Sex.MAN);
            }
            if ("woman".equalsIgnoreCase(arrayAnimal.get(4)) || "женщина".equalsIgnoreCase(arrayAnimal.get(4))) {
                personInfo1.setSexPerson(Sex.WOMAN);
            }
            if (!"man".equalsIgnoreCase(arrayAnimal.get(4))
                    && !"woman".equalsIgnoreCase(arrayAnimal.get(4))
                    && !"мужчина".equalsIgnoreCase(arrayAnimal.get(4))
                    && !"женщина".equalsIgnoreCase(arrayAnimal.get(4))) {
                System.err.println("Неверно указан пол хозяина животного(WOMAN,MAN): " + arrayAnimal.get(4));
                numberOfMistakes++;
            }
            infoArrayAnimalInfo.getSizeArrayAnimalInfo();
            infoArrayAnimalInfo.getArrayAnimalInfo();
            animalInfo1.setPersonInfo(personInfo1);
//            AnimalInfo animalInfoTestReplay = new AnimalInfo();
//            PersonInfo personInfoTestReplay = new PersonInfo();
//            if (infoArrayAnimalInfo.sizeArrayAnimalInfo > 0) {
//                IntStream.range(0, infoArrayAnimalInfo.animalInfoArray.size()).forEach(i -> {
//                    animalInfoTestReplay.setNickNameAnimal
//                            (infoArrayAnimalInfo.animalInfoArray.get(i).getNickNameAnimal());
//                    animalInfoTestReplay.setAnimalWeight
//                            (infoArrayAnimalInfo.animalInfoArray.get(i).getAnimalWeight());
//                    personInfoTestReplay.setNamePerson
//                            (infoArrayAnimalInfo.animalInfoArray.get(i).getPersonInfo().getNamePerson());
//                    personInfoTestReplay.setAgePerson
//                            (infoArrayAnimalInfo.animalInfoArray.get(i).getPersonInfo().getAgePerson());
//                    personInfoTestReplay.setSexPerson
//                            (infoArrayAnimalInfo.animalInfoArray.get(i).getPersonInfo().getSexPerson());
//                    animalInfoTestReplay.setPersonInfo(personInfoTestReplay);
//                    if (animalInfoTestReplay.equals(animalInfo1.toStringNoId())) {
//                        System.err.println("Такое животное уже добавлено" + animalInfoTestReplay.toStringNoId());
//                        numberOfMistakes++;
//                    }
//                });
//            }
            if (numberOfMistakes > 0) {
                System.out.println("Повторите ввод с самого начала");
                arrayAnimal.set(0, TextInputMenuUtilities.TEXT_NICK_NAME_ANIMAL);
                arrayAnimal.set(1, TextInputMenuUtilities.TEXT_ANIMAL_WEIGHT);
                arrayAnimal.set(2, TextInputMenuUtilities.TEXT_NAME_PERSON);
                arrayAnimal.set(3, TextInputMenuUtilities.TEXT_AGE_PERSON);
                arrayAnimal.set(4, TextInputMenuUtilities.TEXT_SEX_PERSON);
            }
            if (numberOfMistakes == 0 && infoArrayAnimalInfo.sizeArrayAnimalInfo > 0) {
                infoArrayAnimalInfo.animalInfoArray.sort(Comparator.comparing(AnimalInfo::getIdAdmin));
                infoArrayAnimalInfo.getArrayAnimalInfo();
                animalInfo1.setIdAnimal(infoArrayAnimalInfo.animalInfoArray.get(infoArrayAnimalInfo.animalInfoArray.size() - 1).getIdAdmin() + 1);
                infoArrayAnimalInfo.animalInfoArray.add(animalInfo1);
                infoArrayAnimalInfo.saveArrayAnimalInfo();
                infoArrayAnimalInfo.saveSizeArrayList();
                isExit = true;
            }
            if (numberOfMistakes == 0 && infoArrayAnimalInfo.sizeArrayAnimalInfo == 0) {
                animalInfo1.setIdAnimal(1);
                infoArrayAnimalInfo.animalInfoArray.add(animalInfo1);
                infoArrayAnimalInfo.saveArrayAnimalInfo();
                infoArrayAnimalInfo.saveSizeArrayList();
                isExit = true;
            }
        } while (!isExit);
    }

}
