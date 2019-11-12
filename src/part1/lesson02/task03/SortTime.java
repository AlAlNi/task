package part1.lesson02.task03;


class SortTime {
     void sortTime() throws Exception {
        KeyboardInputs keyboardInputs = new KeyboardInputs();
        keyboardInputs.bufferInput();
        FillPerson fillPerson = new FillPerson();
        fillPerson.fillPersons(keyboardInputs);
        Sorter sort1 = new BubbleSort();
        long sortTime1 = sort1.sort(fillPerson.personArrayList);
        Sorter sort2 = new ArraysSort();
        long sortTime2 = sort2.sort(fillPerson.personArrayListCopy);
        System.out.println("Время, потраченное на сортировку массива методом пузырька: " + sortTime1 / 1000. + " сек.");
        System.out.println("Время, потраченное на сортировку встроенными методами класса Arrays: " + sortTime2 / 1000. + " сек.");
    }
}
