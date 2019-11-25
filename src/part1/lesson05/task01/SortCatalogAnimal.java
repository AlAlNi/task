package part1.lesson05.task01;

import static java.lang.System.out;
import static java.util.Comparator.comparing;

public class SortCatalogAnimal {
    Load load;
        void sortCatalogAnimal(String itemMenu) {
        if ("008".equals(itemMenu))
        {
            load.getAnimalInfoArrayList().sort(comparing(a -> a.getNickNameAnimal()));
            for (AnimalInfo info : load.getAnimalInfoArrayList()) {
                out.println(info);
            }
        }
    }
//    void sortCatalogAnimal(Comparator comparator) {
//        Load load = new Load();
//        load.getAnimalInfoArrayList().sort(comparator);
//    }
}

//    Comparator<AnimalInfo> comparatorByName;
//                        comparatorByName = new Comparator<AnimalInfo>() {
//                            @Override
//                            public int compare(AnimalInfo o1, AnimalInfo o2) {
//                                return o1.getNickNameAnimal().compareTo(o2.getPersonInfo().getNamePerson());
//                            }
//                        };
//                        SortCatalogAnimal sortCatalogAnimal = new SortCatalogAnimal();
// sortCatalogAnimal.sortCatalogAnimal(comparatorByName);
//                        for (AnimalInfo info : load.getAnimalInfoArrayList()) {
//                            out.println(info);
//                        }