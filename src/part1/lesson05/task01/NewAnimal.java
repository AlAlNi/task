package part1.lesson05.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class NewAnimal {
    ArrayList<String> arrayListInputAnimal = new ArrayList<>();

    public void NewAnimal() throws IOException {
        IntStream.range(0, TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.size())
                .filter(i -> "001".equals(TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.get(i).getItemTextInput()))
                .forEachOrdered(i -> arrayListInputAnimal.add(TextInputMenu.TEXT_QUESTIONS_MENU_INPUT.get(i).getTextInput()));
        boolean isExit = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            for (int i = 0; i < arrayListInputAnimal.size(); i++) {
                System.out.println(arrayListInputAnimal.get(i));
                arrayListInputAnimal.set(i, bufferedReader.readLine());
            }
            AnimalInfo animalInfo = new AnimalInfo();
            PersonInfo personInfo = new PersonInfo();
            animalInfo.setNickNameAnimal(arrayListInputAnimal.get(0));
            arrayListInputAnimal.set(0, TextInputMenu.TEXT_NICK_NAME_ANIMAL);
            personInfo.setNamePerson(arrayListInputAnimal.get(2));
            arrayListInputAnimal.set(2, ItemsMenu.TEXT_NAME_PERSON);
            try {
                personInfo.setAgePerson(Integer.parseInt(arrayListInputAnimal.get(3)));
                arrayListInputAnimal.set(3, ItemsMenu.TEXT_AGE_PERSON);
            } catch (NumberFormatException e) {
                System.err.println("Не коректный ввод возроста");
                arrayListInputAnimal.set(3, ItemsMenu.TEXT_AGE_PERSON);
            }
            try {
                personInfo.setAnimalWeight(Integer.parseInt(arrayListInputAnimal.get(1)));
                arrayListInputAnimal.set(1, ItemsMenu.TEXT_ANIMAL_WEIGHT);
            } catch (NumberFormatException e) {
                System.err.println("Некоректный ввод веса животного");
                arrayListInputAnimal.set(1, ItemsMenu.TEXT_ANIMAL_WEIGHT);
            }
            if ("man".equalsIgnoreCase(arrayListInputAnimal.get(4))) {
                personInfo.setSexPerson(Sex.MAN);
                arrayListInputAnimal.set(4, TextInputMenu.TEXT_SEX_PERSON);
                isExit = true;
            }
            if ("woman".equalsIgnoreCase(arrayListInputAnimal.get(4))) {
                personInfo.setSexPerson(Sex.WOMAN);
                arrayListInputAnimal.set(4, TextInputMenu.TEXT_SEX_PERSON);
                isExit = true;
            }
            if (!"man".equalsIgnoreCase(arrayListInputAnimal.get(4)) && !"woman".equalsIgnoreCase(arrayListInputAnimal.get(4))) {
                System.err.println("Укажите пол хозяина животного(WOMAN,MAN)");
                arrayListInputAnimal.set(4, TextInputMenu.TEXT_SEX_PERSON);
            }
        } while (!isExit);
    }
}
