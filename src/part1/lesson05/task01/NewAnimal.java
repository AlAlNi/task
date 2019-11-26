package part1.lesson05.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class NewAnimal {
    ArrayList<String> arrayListInputAnimal = new ArrayList<>();
    boolean isExit = false;
    int numberOfMistakes;
    AnimalInfo animalInfo1 = new AnimalInfo();
    AnimalInfo animalInfo2 = new AnimalInfo();
    PersonInfo personInfo1 = new PersonInfo();
    PersonInfo personInfo2 = new PersonInfo();
    Load load = new Load();
    private static final long serialVersionUID = 9013909351230891459L;

    public void NewAnimal() throws IOException {
        IntStream.range(0, TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.size())
                .filter(i -> "001".equals(TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.get(i).getItemTextInput()))
                .forEachOrdered(i -> arrayListInputAnimal.add(TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.get(i).getTextInput()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            numberOfMistakes = 0;
            for (int i = 0; i < arrayListInputAnimal.size(); i++) {
                System.out.println(arrayListInputAnimal.get(i));
                arrayListInputAnimal.set(i, bufferedReader.readLine());
            }
            animalInfo1.setNickNameAnimal(arrayListInputAnimal.get(0));
            personInfo1.setNamePerson(arrayListInputAnimal.get(2));
            try {
                personInfo1.setAgePerson(Integer.parseInt(arrayListInputAnimal.get(3)));
            } catch (NumberFormatException e) {
                System.err.println("Не коректный ввод возроста: " + arrayListInputAnimal.get(3));
                arrayListInputAnimal.set(3, ItemsMenu.TEXT_AGE_PERSON);
                numberOfMistakes++;
            }
            try {
                animalInfo1.setAnimalWeight(Integer.parseInt(arrayListInputAnimal.get(1)));
            } catch (NumberFormatException e) {
                System.err.println("Не коректный ввод веса: " + arrayListInputAnimal.get(1));
                arrayListInputAnimal.set(1, ItemsMenu.TEXT_ANIMAL_WEIGHT);
                numberOfMistakes++;
            }
            if ("man".equalsIgnoreCase(arrayListInputAnimal.get(4))) {
                personInfo1.setSexPerson(Sex.MAN);
            }
            if ("woman".equalsIgnoreCase(arrayListInputAnimal.get(4))) {
                personInfo1.setSexPerson(Sex.WOMAN);
            }
            if (!"man".equalsIgnoreCase(arrayListInputAnimal.get(4)) && !"woman".equalsIgnoreCase(arrayListInputAnimal.get(4))) {
                System.err.println("Неверно указан пол хозяина животного(WOMAN,MAN): " + arrayListInputAnimal.get(4));
                numberOfMistakes++;
            }
            if (numberOfMistakes == 0) {
                animalInfo1.setPersonInfo(personInfo1);
                isExit = true;
            }
            if (numberOfMistakes > 0) {
                System.err.println("Повторите ввод с самого начала");
                arrayListInputAnimal.set(0, TextInputMenu.TEXT_NICK_NAME_ANIMAL);
                arrayListInputAnimal.set(1, TextInputMenu.TEXT_ANIMAL_WEIGHT);
                arrayListInputAnimal.set(2, TextInputMenu.TEXT_NAME_PERSON);
                arrayListInputAnimal.set(3, TextInputMenu.TEXT_AGE_PERSON);
                arrayListInputAnimal.set(4, TextInputMenu.TEXT_SEX_PERSON);
            }
        } while (!isExit);

        if (load.sizeArrayList == 0) {
            load.unloadArrayList();
        }
//        for (int i = 0; i < load.getAnimalInfoArrayList().size(); i++) {
//            animalInfo2.setNickNameAnimal(load.getAnimalInfoArrayList().get(i).getNickNameAnimal());
//            animalInfo2.setAnimalWeight(load.getAnimalInfoArrayList().get(i).getAnimalWeight());
//            animalInfo2.personInfo.setNamePerson(load.getAnimalInfoArrayList().get(i).getPersonInfo().getNamePerson());
//            animalInfo2.personInfo.setAgePerson(load.getAnimalInfoArrayList().get(i).getPersonInfo().getAgePerson());
//            animalInfo2.personInfo.setSexPerson(load.getAnimalInfoArrayList().get(i).getPersonInfo().getSexPerson());
//            Predicate<AnimalInfo> predicate = (animalInfo) -> animalInfo1.equals(animalInfo2);
//            System.out.println(predicate);
//        }
    }
}
