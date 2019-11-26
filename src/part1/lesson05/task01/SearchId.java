package part1.lesson05.task01;

import java.util.ArrayList;
import java.util.UUID;

public class SearchId implements EditById {

    @Override
    public ArrayList<AnimalInfo> arrayListEdition(ArrayList<AnimalInfo> arrayList, ArrayList<AnimalInfo> arrayListCopy, UUID idSearch) {
        for (AnimalInfo info : arrayList) {
            if (idSearch.equals(info.getIdAdmin())) {
                arrayListCopy.add(info);
            }
        }
        return arrayListCopy;
    }
}
