package part1.lesson05.task01;

import java.io.IOException;

class SearchItemsMenu {
    String inputText(String stringTextInputMenu) throws IOException {
        if ("001".equals(stringTextInputMenu)) {
            NewAnimal newAnimal = new NewAnimal();
            newAnimal.NewAnimal();
        }
        return ItemsMenu.TEXT_DATA_ADD;
    }
}