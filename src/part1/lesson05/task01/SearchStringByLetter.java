package part1.lesson05.task01;

import java.util.ArrayList;

public class SearchStringByLetter implements SearchString {


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