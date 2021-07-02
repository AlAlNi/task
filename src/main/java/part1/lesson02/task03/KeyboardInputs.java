package part1.lesson02.task03;

import part1.lesson02.task03.exception.WrongNumberException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


class KeyboardInputs {
    int customNumberElements;
    ArrayList<String> nameWomanArrayList = new ArrayList<>();
    ArrayList<String> nameManArrayList = new ArrayList<>();

    void bufferInput() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите пять мужских имён(посли каждого имени нажемайте enter)");
            for (
                    int i = 0;
                    i < 5; i++) {
                nameManArrayList.add(reader.readLine());
            }
            System.out.println("Введите шесть женских имён(после каждого имени нажимайте enter)");
            for (
                    int i = 0;
                    i < 6; i++) {
                nameWomanArrayList.add(reader.readLine());
            }
            do {
                final int minNumberElements = 10000;
                try {
                    System.out.println("Введите длину генирированного масива(число от " + minNumberElements + " и более):");
                    customNumberElements = Integer.parseInt(reader.readLine());
                    if (customNumberElements < minNumberElements) {
                        throw new WrongNumberException(customNumberElements, minNumberElements);
                    } else break;
                } catch (WrongNumberException | NumberFormatException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }
}
