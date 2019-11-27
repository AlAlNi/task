package part1.lesson05.task01;

import java.util.ArrayList;

public class SearchStringAnimalByLetter {
    public ArrayList<AnimalInfo> arrayListSearch(ArrayList<AnimalInfo> arrayList,
                                                 ArrayList<AnimalInfo> arrayListCopy, String stringSearch) {
        for (AnimalInfo info : arrayList) {
            if (stringSearch.equalsIgnoreCase(info.getNickNameAnimal().substring(0, (stringSearch.length())))) {
                arrayListCopy.add(info);
            }
        }
        return arrayListCopy;
    }

}