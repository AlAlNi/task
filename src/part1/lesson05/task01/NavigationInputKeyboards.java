//
//package part1.lesson05.task01;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.UUID;
//import java.util.stream.IntStream;
//
//import static java.lang.System.*;
//import static part1.lesson05.task01.Sex.MAN;
//import static part1.lesson05.task01.Sex.WOMAN;
//
//public class NavigationInputKeyboards implements Serializable {
//    private Loading loading = new Loading();
//    private static final long serialVersionUID = 9013909351230891459L;
//
//    void inputKeyboards(String tempItemMainMenu) {
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
//            boolean exitMainMenu = false;
//            do {
//                if (loading.sizeArrayList == 0) {
//                    loading.unloadArrayList();
//                }
//                if ("001".equals(tempItemMainMenu)) {
//                    out.println(ItemsMenu.TEXT_SIZE_CATALOG + loading.getAnimalInfoArrayList().size());
//                    for (boolean exitInMainMenu = false; !exitInMainMenu; ) {
//                        AnimalInfo animalInfo = new AnimalInfo();
//                        animalInfo.setIdAnimal(UUID.randomUUID());
//                        out.println(ItemsMenu.TEXT_NICK_NAME_ANIMAL);
//                        animalInfo.setNickNameAnimal(bufferedReader.readLine());
//                        out.println(ItemsMenu.TEXT_ANIMAL_WEIGHT);
//                        animalInfo.setAnimalWeight(Integer.parseInt(bufferedReader.readLine()));
//                        out.println(ItemsMenu.TEXT_NAME_PERSON);
//                        PersonInfo personInfo = new PersonInfo();
//                        personInfo.setNamePerson(bufferedReader.readLine());
//                        out.println(ItemsMenu.TEXT_AGE_PERSON);
//                        personInfo.setAgePerson(Integer.parseInt(bufferedReader.readLine()));
//                        out.print(ItemsMenu.ITEM_MENU_SEX_PERSON_MAN);
//                        out.println(ItemsMenu.ITEM_MENU_SEX_PERSON_WOMAN);
//                        out.println(ItemsMenu.TEXT_SEX_PERSON);
//                        String tempSexPerson = bufferedReader.readLine();
//                        if ("006".equals(tempSexPerson)) {
//                            personInfo.setSexPerson(MAN);
//                            animalInfo.setPersonInfo(personInfo);
//                            loading.addArrayList(animalInfo);
//                        }
//                        if ("007".equals(tempSexPerson)) {
//                            personInfo.setSexPerson(WOMAN);
//                            animalInfo.setPersonInfo(personInfo);
//                            loading.addArrayList(animalInfo);
//                        }
//                        out.print(ItemsMenu.ITEM_HOME_MENU);
//                        out.println(ItemsMenu.ITEM_MENU_NEW_ANIMAL);
//                        String tempItemHomeMenu = bufferedReader.readLine();
//                        if ("005".equals(tempItemHomeMenu)) {
//                            loading.saveArrayList();
//                            loading.saveSizeArrayList();
//                            exitInMainMenu = true;
//                            IntStream.range(0, 5).mapToObj(ItemsMenu.ITEMS_MENU_MAP_STRING::get).forEach(System.out::print);
//                        }
//                    }
//                }
//                if ("002".equals(tempItemMainMenu)) {
//                    out.println(ItemsMenu.TEXT_NICK_NAME_ANIMAL);
//                    if (loading.getArrayListSearchFullMatch().size() > 0) {
//                        loading.getArrayListSearchFullMatch().clear();
//                    }
//                    if (loading.getArrayListSearchByLetter().size() > 0) {
//                        loading.getArrayListSearchByLetter().clear();
//                    }
//                    String tempSearchNickName = bufferedReader.readLine();
//                    SearchStringAnimal searchStringAnimal1 = new SearchStringAnimalFullMatch();
//                    ArrayList<AnimalInfo> arrayList1;
//                    arrayList1 = searchStringAnimal1.arrayListSearch(loading.getAnimalInfoArrayList(),
//                            loading.getArrayListSearchFullMatch(), tempSearchNickName);
//                    SearchStringAnimal searchStringAnimal2 = new SearchStringAnimalByLetter();
//                    ArrayList<AnimalInfo> arrayList2;
//                    arrayList2 = searchStringAnimal2.arrayListSearch(loading.getAnimalInfoArrayList(),
//                            loading.getArrayListSearchByLetter(), tempSearchNickName);
//                    if (arrayList1.size() > 0 && arrayList1.size() <= arrayList2.size()) {
//                        for (AnimalInfo info : arrayList1) {
//                            out.println(info);
//                        }
//                    }
//                    if (arrayList2.size() > 0 && arrayList1.size() == 0) {
//                        for (AnimalInfo info : arrayList2) {
//                            out.println(info);
//                        }
//                    }
//                    IntStream.range(0, 5).mapToObj(ItemsMenu.ITEMS_MENU_MAP_STRING::get).forEach(System.out::print);
//                }
//                if ("003".equals(tempItemMainMenu)) {
//                    if (loading.getArrayListSearchId().size() > 0) {
//                        loading.getArrayListSearchId().clear();
//                    }
//                    out.println(ItemsMenu.TEXT_ID_CATALOG);
//                    UUID tempSearchId = UUID.fromString(bufferedReader.readLine());
//                    EditById editById1 = new SearchId();
//                    ArrayList<AnimalInfo> arrayList3;
//                    arrayList3 = editById1.arrayListEdition(loading.getAnimalInfoArrayList(),
//                            loading.getArrayListSearchId(), tempSearchId);
//                    if (arrayList3.size() == 1) {
//                        out.println(arrayList3);
//                        out.println(ItemsMenu.TEXT_NEW_DATA + ItemsMenu.TEXT_NAME_PERSON);
//                        arrayList3.get(0).personInfo.setNamePerson(bufferedReader.readLine());
//                        out.println(ItemsMenu.TEXT_NEW_DATA + ItemsMenu.TEXT_SEX_PERSON);
//                        boolean isExit = false;
//                        do {
//                            out.print(ItemsMenu.ITEM_MENU_SEX_PERSON_MAN);
//                            out.println(ItemsMenu.ITEM_MENU_SEX_PERSON_WOMAN);
//                            String s = bufferedReader.readLine();
//                            if ("006".equals(s)) {
//                                arrayList3.get(0).personInfo.setSexPerson(MAN);
//                                isExit = true;
//                            }
//                            if ("007".equals(s)) {
//                                arrayList3.get(0).personInfo.setSexPerson(WOMAN);
//                                isExit = true;
//                            }
//                        } while (!isExit);
//                        out.println(ItemsMenu.TEXT_AGE_PERSON);
//                        arrayList3.get(0).personInfo.setAgePerson(Integer.parseInt(bufferedReader.readLine()));
//                        out.println(ItemsMenu.TEXT_NICK_NAME_ANIMAL);
//                        arrayList3.get(0).setNickNameAnimal(bufferedReader.readLine());
//                        out.println(ItemsMenu.TEXT_ANIMAL_WEIGHT);
//                        arrayList3.get(0).setAnimalWeight(Integer.parseInt(bufferedReader.readLine()));
//                        out.println(arrayList3);
//                        isExit = false;
//                        do {
//                            out.println(ItemsMenu.ITEM_MENU_SAVE_EDITION + ItemsMenu.ITEM_HOME_MENU);
//                            String s = bufferedReader.readLine();
//                            if ("011".equals(s)) {
//                                EditById editById2 = new EditId() {
//                                };
//                                ArrayList<AnimalInfo> arrayList4;
//                                arrayList4 = editById2.arrayListEdition(loading.getAnimalInfoArrayList(),
//                                        arrayList3, tempSearchId);
//                                Collections.copy(arrayList4, loading.getAnimalInfoArrayList());
//                                loading.saveArrayList();
//                                loading.saveSizeArrayList();
//                                isExit = true;
//                                out.println(ItemsMenu.TEXT_DATA_ADD);
//                                IntStream.range(0, 5).mapToObj(ItemsMenu.ITEMS_MENU_MAP_STRING::get).forEach(System.out::print);
//                            }
//                            if ("005".equals(s)) {
//                                isExit = true;
//                                IntStream.range(0, 5).mapToObj(ItemsMenu.ITEMS_MENU_MAP_STRING::get).forEach(System.out::print);
//                            }
//                        } while (!isExit);
//                    }
//                }
//                if ("004".equals(tempItemMainMenu)) {
//                    boolean exitMenu = false;
//                    do {
//                        out.print(ItemsMenu.ITEM_MENU_SORT_PERSON);
//                        out.print(ItemsMenu.ITEM_MENU_SORT_NICK_NAME_ANIMAL);
//                        out.print(ItemsMenu.ITEM_MENU_SORT_ANIMAL_WEIGHT);
//                        out.println(ItemsMenu.ITEM_HOME_MENU);
//                        out.println(ItemsMenu.TEXT_SORT_METHOD);
//                        SortCatalogAnimal sortCatalogAnimal = new SortCatalogAnimal();
//                        String ItemMenu = bufferedReader.readLine();
//                        sortCatalogAnimal.sortCatalogAnimal(ItemMenu);
////                        if ("008".equals(tempItemMenu)) {
////                            loading.getAnimalInfoArrayList().sort(comparing(a -> a.getNickNameAnimal()));
////                            for (AnimalInfo info : loading.getAnimalInfoArrayList()) {
////                                out.println(info);
////                            }
////                        }
////                        if ("009".equals(ItemMenu)) {
////                            loading.getAnimalInfoArrayList().sort(comparing(a->a.getPersonInfo().getNamePerson()));
////                            for (AnimalInfo info : loading.getAnimalInfoArrayList()) {
////                                out.println(info);
////                            }
////                        }
////                        if ("010".equals(ItemMenu)) {
////                            loading.getAnimalInfoArrayList().sort(comparing(a -> a.getAnimalWeight()));
////                            for (AnimalInfo info : loading.getAnimalInfoArrayList()) {
////                                out.println(info);
////                            }
////                        }
//                        if ("005".equals(ItemMenu)) {
//                            loading.saveArrayList();
//                            loading.saveSizeArrayList();
//                            exitMenu = true;
//                            IntStream.range(0, 5).mapToObj(ItemsMenu.ITEMS_MENU_MAP_STRING::get).forEach(System.out::print);
//                        }
//                    } while (!exitMenu);
//                }
//                if ("000".equals(tempItemMainMenu)) {
//                    exitMainMenu = true;
//                }
//            } while (!exitMainMenu);
//        } catch (NumberFormatException | IOException e) {
//            err.println(e);
//        }
//    }
//}
