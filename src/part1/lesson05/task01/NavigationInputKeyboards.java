
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
                        out.println(ItemsMenu.TEXT_NICK_NAME_ANIMAL);
                        animalInfo.setNickNameAnimal(bufferedReader.readLine());
                        out.println(ItemsMenu.TEXT_ANIMAL_WEIGHT);
                        animalInfo.setAnimalWeight(Integer.parseInt(bufferedReader.readLine()));
                        out.println(ItemsMenu.TEXT_NAME_PERSON);
                        PersonInfo personInfo = new PersonInfo();
                        personInfo.setNamePerson(bufferedReader.readLine());
                        out.println(ItemsMenu.TEXT_AGE_PERSON);
                        personInfo.setAgePerson(Integer.parseInt(bufferedReader.readLine()));
                        out.print(ItemsMenu.ITEM_MENU_SEX_PERSON_MAN);
                        out.println(ItemsMenu.ITEM_MENU_SEX_PERSON_WOMAN);
                        out.println(ItemsMenu.TEXT_SEX_PERSON);
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
                    out.println(ItemsMenu.TEXT_NICK_NAME_ANIMAL);
                    if (save.getArrayListSearchFullMatch().size() > 0) {
                        save.getArrayListSearchFullMatch().clear();
                    }
                    if (save.getArrayListSearchByLetter().size() > 0) {
                        save.getArrayListSearchByLetter().clear();
                    }
                    String tempSearchNickName = bufferedReader.readLine();
                    SearchString searchString1 = new SearchStringFullMatch();
                    ArrayList<AnimalInfo> arrayList1;
                    arrayList1 = searchString1.arrayListSearch(save.getAnimalInfoArrayList(),
                            save.getArrayListSearchFullMatch(), tempSearchNickName);
                    SearchString searchString2 = new SearchStringByLetter();
                    ArrayList<AnimalInfo> arrayList2;
                    arrayList2 = searchString2.arrayListSearch(save.getAnimalInfoArrayList(),
                            save.getArrayListSearchByLetter(), tempSearchNickName);
                    if (arrayList1.size() > 0 && arrayList1.size() <= arrayList2.size()) {
                        for (AnimalInfo info : arrayList1) {
                            out.println(info);
                        }
                    }
                    if (arrayList2.size() > 0 && arrayList1.size() == 0) {
                        for (AnimalInfo info : arrayList2) {
                            out.println(info);
                        }
                    }
                    mainMenu.mainMenu(ItemsMenu.ITEM_MENU_NEW_ANIMAL,
                            ItemsMenu.ITEM_MENU_SEARCH,
                            ItemsMenu.ITEM_MENU_CHANGE_DATA,
                            ItemsMenu.ITEM_MENU_ANIMAL_LIST,
                            ItemsMenu.ITEM_MENU_EXIT,
                            ItemsMenu.PUNKT_MENU);
                }
                if ("003".equals(tempItemMainMenu)) {
                    if (save.getArrayListSearchId().size() > 0) {
                        save.getArrayListSearchId().clear();
                    }
                    out.println(ItemsMenu.TEXT_ID_CATALOG);
                    UUID tempSearchId = UUID.fromString(bufferedReader.readLine());
                    EditById editById1 = new SearchId();
                    ArrayList<AnimalInfo> arrayList3;
                    arrayList3 = editById1.arrayListEdition(save.getAnimalInfoArrayList(),
                            save.getArrayListSearchId(), tempSearchId);
                    if (arrayList3.size() == 1) {
                        out.println(arrayList3);
                        out.println(ItemsMenu.TEXT_NEW_DATA + ItemsMenu.TEXT_NAME_PERSON);
                        arrayList3.get(0).personInfo.setNamePerson(bufferedReader.readLine());
                        out.println(ItemsMenu.TEXT_NEW_DATA + ItemsMenu.TEXT_SEX_PERSON);
                        boolean isExit = false;
                        do {
                            out.print(ItemsMenu.ITEM_MENU_SEX_PERSON_MAN);
                            out.println(ItemsMenu.ITEM_MENU_SEX_PERSON_WOMAN);
                            String s = bufferedReader.readLine();
                            if ("006".equals(s)) {
                                arrayList3.get(0).personInfo.setSexPerson(MAN);
                                isExit = true;
                            }
                            if ("007".equals(s)) {
                                arrayList3.get(0).personInfo.setSexPerson(WOMAN);
                                isExit = true;
                            }
                        } while (!isExit);
                        out.println(ItemsMenu.TEXT_AGE_PERSON);
                        arrayList3.get(0).personInfo.setAgePerson(Integer.parseInt(bufferedReader.readLine()));
                        out.println(ItemsMenu.TEXT_NICK_NAME_ANIMAL);
                        arrayList3.get(0).setNickNameAnimal(bufferedReader.readLine());
                        out.println(ItemsMenu.TEXT_ANIMAL_WEIGHT);
                        arrayList3.get(0).setAnimalWeight(Integer.parseInt(bufferedReader.readLine()));
                        out.println(arrayList3);
                        isExit=false;
                        do {
                            out.println(ItemsMenu.ITEM_MENU_SAVE_EDITION + ItemsMenu.ITEM_HOME_MENU);
                            String s = bufferedReader.readLine();
                            if ("011".equals(s)) {
                                EditById editById2 = new EditId() {
                                };
                                ArrayList<AnimalInfo> arrayList4;
                                arrayList4 = editById2.arrayListEdition(save.getAnimalInfoArrayList(),
                                        arrayList3, tempSearchId);
                                Collections.copy(arrayList4, save.getAnimalInfoArrayList());
                                save.saveArrayList();
                                save.saveSizeArrayList();
                                isExit = true;
                                out.println(ItemsMenu.TEXT_DATA_ADD);
                                mainMenu.mainMenu(ItemsMenu.ITEM_MENU_NEW_ANIMAL,
                                        ItemsMenu.ITEM_MENU_SEARCH,
                                        ItemsMenu.ITEM_MENU_CHANGE_DATA,
                                        ItemsMenu.ITEM_MENU_ANIMAL_LIST,
                                        ItemsMenu.ITEM_MENU_EXIT,
                                        ItemsMenu.PUNKT_MENU);
                            }
                            if ("005".equals(s)) {
                                isExit = true;
                                mainMenu.mainMenu(ItemsMenu.ITEM_MENU_NEW_ANIMAL,
                                        ItemsMenu.ITEM_MENU_SEARCH,
                                        ItemsMenu.ITEM_MENU_CHANGE_DATA,
                                        ItemsMenu.ITEM_MENU_ANIMAL_LIST,
                                        ItemsMenu.ITEM_MENU_EXIT,
                                        ItemsMenu.PUNKT_MENU);
                            }
                        } while (!isExit);
                    }
                }
                if ("004".equals(tempItemMainMenu)) {
                    boolean exitMenu = false;
                    do {
                        out.print(ItemsMenu.ITEM_MENU_SORT_PERSON);
                        out.print(ItemsMenu.ITEM_MENU_SORT_NICK_NAME_ANIMAL);
                        out.print(ItemsMenu.ITEM_MENU_SORT_ANIMAL_WEIGHT);
                        out.println(ItemsMenu.ITEM_HOME_MENU);
                        out.println(ItemsMenu.TEXT_SORT_METHOD);
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
