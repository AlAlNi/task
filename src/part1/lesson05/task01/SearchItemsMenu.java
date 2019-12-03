package part1.lesson05.task01;

import part1.lesson05.task01.utilities.ItemsMenuUtilities;

import java.io.IOException;

class SearchItemsMenu {
    String inputText(String stringTextInputMenu) throws IOException {
        if ("001".equals(stringTextInputMenu)) {
            NewAnimal newAnimal = new NewAnimal();
            newAnimal.addNewAnimal();
        }
        return ItemsMenuUtilities.TEXT_DATA_ADD;
    }
}