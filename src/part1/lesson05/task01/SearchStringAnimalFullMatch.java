package part1.lesson05.task01;

import java.util.ArrayList;


public class SearchStringAnimalFullMatch implements SearchStringAnimal {
    @Override
    public ArrayList<AnimalInfo> arrayListSearch(ArrayList<AnimalInfo> arrayList,ArrayList<AnimalInfo> arrayListCopy, String stringSearch) {
        for (AnimalInfo info : arrayList) {
            if (stringSearch.equalsIgnoreCase(info.getNickNameAnimal())) {
                arrayListCopy.add(info);
            }
        }
        return arrayListCopy;
    }
}

