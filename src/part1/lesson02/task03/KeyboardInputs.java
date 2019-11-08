package part1.lesson02.task03;

import part1.lesson02.task03.exception.WrongNumberException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class KeyboardInputs {
    static int customNumberElements;
    static final ArrayList<Person> nameWomanArrayList = new ArrayList<>();
    static final ArrayList<Person> nameManArrayList = new ArrayList<>();

    static void bufferMan() throws IOException {
        System.out.println("Введите пять мужских имён(посли каждого имени нажемайте enter)");
        for (int i = 0; i < 5; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            nameManArrayList.add(new Person(name));
        }
    }

    static void bufferWoman() throws IOException {
        System.out.println("Введите шесть женских имён(после каждого имени нажимайте enter)");
        for (int i = 0; i < 6; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            nameWomanArrayList.add(new Person(name));
        }
    }

    static void inputSizeArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            int minNumberElements = 10000;
            System.out.println("Введите длину генирированного масива(число от " + minNumberElements + " и более):");
            String sA = reader.readLine();
            try {
                customNumberElements = Integer.parseInt(sA);
                if (customNumberElements < minNumberElements) {
                    throw new WrongNumberException(customNumberElements, minNumberElements);
                } else break;
            } catch (WrongNumberException | NumberFormatException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}