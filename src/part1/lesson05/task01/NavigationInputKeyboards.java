
package part1.lesson05.task01;


import part1.lesson05.task01.menu.MainMenu;

import java.io.*;
import java.util.*;

import static java.lang.System.*;
import static java.util.Comparator.*;
import static part1.lesson05.task01.Sex.MAN;
import static part1.lesson05.task01.Sex.WOMAN;

public class NavigationInputKeyboards implements Serializable {
    private Save save = new Save();
    private static final long serialVersionUID = 9013909351230891459L;

    void inputKeyboards() {
        MainMenu mainMenu = new MainMenu();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
            boolean exitMainMenu = false;
            do {
                if (save.sizeArrayList == 0) {
                    save.unloadArrayList();
                }
                String tempItemMainMenu = bufferedReader.readLine();
                if ("001".equals(tempItemMainMenu)) {
                    out.println(ItemsMenu.TEXT_SIZE_CATALOG + save.getAnimalInfoArrayList().size());
                    for (boolean exitInMainMenu = false; !exitInMainMenu; ) {
                        AnimalInfo animalInfo = new AnimalInfo();
                        animalInfo.setIdAnimal(UUID.randomUUID());
                        out.println(ItemsMenu.TEXT_INPUT_NICK_NAME_ANIMAL);
                        animalInfo.setNickNameAnimal(bufferedReader.readLine());
                        out.println(ItemsMenu.TEXT_INPUT_ANIMAL_WEIGHT);
                        animalInfo.setAnimalWeight(Integer.parseInt(bufferedReader.readLine()));
                        out.println(ItemsMenu.TEXT_INPUT_NAME_PERSON);
                        PersonInfo personInfo = new PersonInfo();
                        personInfo.setNamePerson(bufferedReader.readLine());
                        out.println(ItemsMenu.TEXT_INPUT_AGE_PERSON);
                        personInfo.setAgePerson(Integer.parseInt(bufferedReader.readLine()));
                        out.print(ItemsMenu.ITEM_MENU_SEX_PERSON_MAN);
                        out.println(ItemsMenu.ITEM_MENU_SEX_PERSON_WOMAN);
                        out.println(ItemsMenu.TEXT_INPUT_SEX_PERSON);
                        String tempSexPerson = bufferedReader.readLine();
                        if ("006".equals(tempSexPerson)) {
                            personInfo.setSexPerson(MAN);
                            animalInfo.setPersonInfo(personInfo);
                            save.addArrayList(animalInfo);
                        }
                        if ("007".equals(tempSexPerson)) {
                            personInfo.setSexPerson(WOMAN);
                            animalInfo.setPersonInfo(personInfo);
                            save.addArrayList(animalInfo);
                        }
                        out.print(ItemsMenu.ITEM_HOME_MENU);
                        out.println(ItemsMenu.ITEM_MENU_NEW_ANIMAL);
                        String tempItemHomeMenu = bufferedReader.readLine();
                        if ("005".equals(tempItemHomeMenu)) {
                            save.saveArrayList();
                            save.saveSizeArrayList();
                            exitInMainMenu = true;
                            mainMenu.mainMenu(ItemsMenu.ITEM_MENU_NEW_ANIMAL,
                                    ItemsMenu.ITEM_MENU_SEARCH,
                                    ItemsMenu.ITEM_MENU_CHANGE_DATA,
                                    ItemsMenu.ITEM_MENU_ANIMAL_LIST,
                                    ItemsMenu.ITEM_MENU_EXIT,
                                    ItemsMenu.PUNKT_MENU);
                        }
                    }
                }
                if ("002".equals(tempItemMainMenu)) {
                    out.println(ItemsMenu.TEXT_INPUT_NICK_NAME_ANIMAL);
                    String tempSearchNickName = bufferedReader.readLine();
                    SearchNickName searchNickName1 = new searchFullMatchNickName();
                    ArrayList<AnimalInfo> arrayList;
                    arrayList = searchNickName1.arrayListSearch(save.getAnimalInfoArrayList(),
                            save.getAnimalInfoArrayListSearch(), tempSearchNickName);
                    for (AnimalInfo info : arrayList) {
                        out.println(info);
                    }
                    mainMenu.mainMenu(ItemsMenu.ITEM_MENU_NEW_ANIMAL,
                            ItemsMenu.ITEM_MENU_SEARCH,
                            ItemsMenu.ITEM_MENU_CHANGE_DATA,
                            ItemsMenu.ITEM_MENU_ANIMAL_LIST,
                            ItemsMenu.ITEM_MENU_EXIT,
                            ItemsMenu.PUNKT_MENU);
                }
                if ("004".equals(tempItemMainMenu)) {
                    boolean exitMenu = false;
                    do {
                        out.print(ItemsMenu.ITEM_MENU_SORT_PERSON);
                        out.print(ItemsMenu.ITEM_MENU_SORT_NICK_NAME_ANIMAL);
                        out.print(ItemsMenu.ITEM_MENU_SORT_ANIMAL_WEIGHT);
                        out.println(ItemsMenu.ITEM_HOME_MENU);
                        out.println(ItemsMenu.TEXT_INPUT_SORT_METHOD);
                        String tempItemMenu = bufferedReader.readLine();
                        if ("008".equals(tempItemMenu)) {
                            save.getAnimalInfoArrayList().sort(comparing(a -> a.getPersonInfo().getNamePerson()));
                            for (AnimalInfo info : save.getAnimalInfoArrayList()) {
                                out.println(info);
                            }
                        }
                        if ("009".equals(tempItemMenu)) {
                            save.getAnimalInfoArrayList().sort(comparing(AnimalInfo::getNickNameAnimal));
                            for (AnimalInfo info : save.getAnimalInfoArrayList()) {
                                out.println(info);
                            }
                        }
                        if ("010".equals(tempItemMenu)) {
                            save.getAnimalInfoArrayList().sort(comparing(AnimalInfo::getAnimalWeight));
                            for (AnimalInfo info : save.getAnimalInfoArrayList()) {
                                out.println(info);
                            }
                        }
                        if ("005".equals(tempItemMenu)) {
                            save.saveArrayList();
                            save.saveSizeArrayList();
                            exitMenu = true;
                            mainMenu.mainMenu(ItemsMenu.ITEM_MENU_NEW_ANIMAL,
                                    ItemsMenu.ITEM_MENU_SEARCH,
                                    ItemsMenu.ITEM_MENU_CHANGE_DATA,
                                    ItemsMenu.ITEM_MENU_ANIMAL_LIST,
                                    ItemsMenu.ITEM_MENU_EXIT,
                                    ItemsMenu.PUNKT_MENU);
                        }
                    } while (!exitMenu);
                }
                if ("000".equals(tempItemMainMenu)) {
                    exitMainMenu = true;
                }
            } while (!exitMainMenu);
        } catch (NumberFormatException | IOException e) {
            err.println(e);
        }
    }
}
