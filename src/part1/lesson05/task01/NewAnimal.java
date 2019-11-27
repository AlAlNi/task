package part1.lesson05.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class NewAnimal {
    ArrayList<String> arrayAnimal = new ArrayList<>();
    boolean isExit = false;
    int numberOfMistakes;
    AnimalInfo animalInfo1 = new AnimalInfo();
    PersonInfo personInfo1 = new PersonInfo();

    public void NewAnimal() throws IOException {
        IntStream.range(0, TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.size())
                .filter(i -> "001".equals(TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.get(i).getItemTextInput()))
                .forEachOrdered(i -> arrayAnimal.add(TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.get(i).getTextInput()));
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
                arrayAnimal.set(3, ItemsMenu.TEXT_AGE_PERSON);
                numberOfMistakes++;
            }
            try {
                animalInfo1.setAnimalWeight(Integer.parseInt(arrayAnimal.get(1)));
            } catch (NumberFormatException e) {
                System.err.println("Не коректный ввод веса: " + arrayAnimal.get(1));
                arrayAnimal.set(1, ItemsMenu.TEXT_ANIMAL_WEIGHT);
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
            InfoArrayAnimalInfo infoArrayAnimalInfo = new InfoArrayAnimalInfo();
            infoArrayAnimalInfo.getSizeArrayAnimalInfo();
            if (numberOfMistakes > 0) {
                System.out.println("Повторите ввод с самого начала");
                arrayAnimal.set(0, TextInputMenu.TEXT_NICK_NAME_ANIMAL);
                arrayAnimal.set(1, TextInputMenu.TEXT_ANIMAL_WEIGHT);
                arrayAnimal.set(2, TextInputMenu.TEXT_NAME_PERSON);
                arrayAnimal.set(3, TextInputMenu.TEXT_AGE_PERSON);
                arrayAnimal.set(4, TextInputMenu.TEXT_SEX_PERSON);
            }
            if (numberOfMistakes == 0 && infoArrayAnimalInfo.sizeArrayAnimalInfo > 0) {
                animalInfo1.setPersonInfo(personInfo1);
                infoArrayAnimalInfo.getArrayAnimalInfo();
                infoArrayAnimalInfo.animalInfoArray.add(animalInfo1);
                infoArrayAnimalInfo.saveArrayAnimalInfo();
                infoArrayAnimalInfo.saveSizeArrayList();
                isExit = true;
            }
            if (numberOfMistakes == 0 && infoArrayAnimalInfo.sizeArrayAnimalInfo == 0) {
                animalInfo1.setPersonInfo(personInfo1);
                infoArrayAnimalInfo.animalInfoArray.add(animalInfo1);
                infoArrayAnimalInfo.saveArrayAnimalInfo();
                infoArrayAnimalInfo.saveSizeArrayList();
                isExit = true;
            }
        } while (!isExit);
    }

}
