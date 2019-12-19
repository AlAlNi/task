package part1.lesson05;

import part1.lesson05.utilities.MainUtilities;

import java.io.IOException;

class SearchItemsMenu {
    String inputText(String stringTextInputMenu) throws IOException {
        if ("001".equals(stringTextInputMenu)) {
            NewAnimal newAnimal = new NewAnimal();
            newAnimal.addNewAnimal();
        }
        return MainUtilities.TEXT_DATA_ADD;
    }
}