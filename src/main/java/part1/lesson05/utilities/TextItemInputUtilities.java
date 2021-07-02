package part1.lesson05.utilities;

public class TextItemInputUtilities {
    private String itemTextInput;
    private String textInput;

    public TextItemInputUtilities() {

    }

    public TextItemInputUtilities(String itemTextInput, String textInput) {
        this.itemTextInput = itemTextInput;
        this.textInput = textInput;
    }

    public String getItemTextInput() {
        return itemTextInput;
    }

    public String getTextInput() {
        return textInput;
    }

    public void setItemTextInput(String itemTextInput) {
        this.itemTextInput = itemTextInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }
}
