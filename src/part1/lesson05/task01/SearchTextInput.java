package part1.lesson05.task01;

import java.io.IOException;

class SearchTextInput {
    String inputText(String stringTextInputMenu) throws IOException {
        switch (stringTextInputMenu) {
            case "001":
                NewAnimal newAnimal = new NewAnimal();
                newAnimal.NewAnimal();
                break;
        }
        return ItemsMenu.TEXT_DATA_ADD;
    }
}