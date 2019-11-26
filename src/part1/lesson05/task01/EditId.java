package part1.lesson05.task01;

import java.util.ArrayList;
import java.util.UUID;

public class EditId implements EditById {

    @Override
    public ArrayList<AnimalInfo> arrayListEdition(ArrayList<AnimalInfo> arrayList, ArrayList<AnimalInfo> arrayListCopy, UUID idSearch) {
        for (int i =0;i<arrayList.size();i++)
        {
            if (idSearch.equals(arrayList.get(i).getIdAdmin()))
            {
                arrayList.set(i,arrayListCopy.get(0));
            }
        }
            return arrayList;
    }
}
