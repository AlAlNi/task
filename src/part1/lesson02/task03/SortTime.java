package part1.lesson02.task03;

import java.io.IOException;

import static part1.lesson02.task03.FillPerson.*;
import static part1.lesson02.task03.KeyboardInputs.*;

class SortTime {
    public void sortTime() throws IOException {
        KeyboardInputs keyboardInputs = new KeyboardInputs();
        keyboardInputs.bufferMan();
        keyboardInputs.bufferWoman();
        keyboardInputs.inputSizeArray();
        FillPerson fillPerson = new FillPerson();
        fillPerson.fillPersons();
        Sorter sort1 = new BubbleSort();
        long sortTime1 = sort1.sort(personArrayList);
        Sorter sort2 = new ArraysSort();
        long sortTime2 = sort2.sort(personArrayListCopy);
        System.out.println("Время, потраченное на сортировку массива методом пузырька: " + sortTime1 / 1000. + " сек.");
        System.out.println("Время, потраченное на сортировку встроенными методами класса Arrays: " + sortTime2 / 1000. + " сек.");
    }
}
