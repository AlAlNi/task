package part1.lesson05.task01;

import java.util.ArrayList;
import java.util.Collections;

public class searchByLetterNickName implements SearchNickName {


    @Override
    public ArrayList<AnimalInfo> arrayListSearch(ArrayList<AnimalInfo> arrayList,
                                                 ArrayList<AnimalInfo> arrayListCopy, String nickNameSearch) {
        for (AnimalInfo info : arrayList) {
            if (nickNameSearch.equalsIgnoreCase(info.getNickNameAnimal().substring(0, (nickNameSearch.length())))) {
                arrayListCopy.add(info);
            }
        }
        return arrayListCopy;
    }
}