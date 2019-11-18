package part1.lesson05.task01;

import java.util.ArrayList;


public class searchFullMatchNickName implements SearchNickName {
    @Override
    public ArrayList<AnimalInfo> arrayListSearch(ArrayList<AnimalInfo> arrayList,ArrayList<AnimalInfo> arrayListCopy, String nickNameSearch) {
        for (AnimalInfo info : arrayList) {
            if (nickNameSearch.equalsIgnoreCase(info.getNickNameAnimal())) {
                arrayListCopy.add(info);
            }
        }
        return arrayListCopy;
    }
}

