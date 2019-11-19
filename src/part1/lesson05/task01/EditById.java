package part1.lesson05.task01;

import java.util.ArrayList;
import java.util.UUID;

public interface EditById {
    ArrayList<AnimalInfo> arrayListEdition(ArrayList<AnimalInfo> arrayList, ArrayList<AnimalInfo> arrayListCopy, UUID idSearch);
}
